package de.ilovejava.bukkit.udm.xml.config;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class Marshallers {

	@SneakyThrows(JAXBException.class)
	public static Marshaller newInstance(Class<? extends ConfigFile> clazz) {
		Marshaller marshaller = null;
			marshaller = JAXBContext.newInstance(clazz).createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		return marshaller;
	}

}
