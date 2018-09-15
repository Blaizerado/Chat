package de.unitygaming.bukkit.udm.xml.config;

import static java.lang.String.format;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import de.unitygaming.bukkit.udm.xml.XmlDocument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

@Log(topic = "UDM | XML-CONFIG")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Configuration {

	private static final String XML_SUFFIX = ".xml";

	private static File getFile(Class<? extends ConfigFile> config) {
		if (!config.isAnnotationPresent(XmlDocument.class)) {
			return Paths.get("settings", "other", config.getSimpleName().concat(XML_SUFFIX)).toFile();
		}

		XmlDocument annotation = config.getAnnotation(XmlDocument.class);
		return Paths.get("settings", annotation.folder(), annotation.file().concat(XML_SUFFIX)).toFile();
	}

	public static boolean isExistent(Class<? extends ConfigFile> config) {
		return Configuration.getFile(config).exists();
	}

	@SneakyThrows(ReflectiveOperationException.class)
	public static void saveDefault(Class<? extends ConfigFile> config) {
		synchronized (config) {
			if (Configuration.isExistent(config)) return;

			ConfigFile cfg;
			cfg = config.newInstance();
			Configuration.save(cfg);
		}
	}

	@SneakyThrows(JAXBException.class)
	public static void save(ConfigFile config) {
		synchronized (config.getClass()) {
			synchronized (config) {
				File file = getFile(config.getClass());
				file.getParentFile().mkdirs();

				Marshaller marshaller = Marshallers.newInstance(config.getClass());
				marshaller.marshal(config, file);
		}
	  }
	}

	public static <T extends ConfigFile> Supplier<T> provide(final Class<T> config) {
		return Suppliers.memoizeWithExpiration(new Supplier<T>() {

			@Override
			public T get() {
				log.info(format("Reloading configuration '%s'", config.getName()));
				return Configuration.load(config);
			}

		}, 5, TimeUnit.MINUTES);
	}
	
	public static <T extends ConfigFile> T load(Class<T> config) {
		synchronized (config) {
			if (!Configuration.isExistent(config)) {
				Configuration.saveDefault(config);
			}

			File file = Configuration.getFile(config);
			return JAXB.unmarshal(file, config);
		}
	}

	public static void delete(Class<? extends ConfigFile> config) {
		synchronized (config) {
			if (!Configuration.isExistent(config)) return;

			File file = Configuration.getFile(config);
			file.delete();
		}
	}
}
