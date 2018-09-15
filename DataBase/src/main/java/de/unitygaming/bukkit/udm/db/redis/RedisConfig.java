package de.unitygaming.bukkit.udm.db.redis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Supplier;

import de.unitygaming.bukkit.udm.xml.XmlDocument;
import de.unitygaming.bukkit.udm.xml.config.ConfigFile;
import de.unitygaming.bukkit.udm.xml.config.Configuration;
import lombok.Getter;

@XmlDocument(folder = "Datenbankeinstellungen", file = "Redis")
@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.FIELD)
public class RedisConfig extends ConfigFile {

	private static final Supplier<RedisConfig> SUPPLIER = Configuration.provide(RedisConfig.class);

	public static RedisConfig getInstance() {
		return SUPPLIER.get();
	}

	@Getter
	@XmlAttribute(name = "host")
	private String host = "localhost";

	@Getter
	@XmlAttribute(name = "port")
	private int port = 6379;
	
	@Getter
	@XmlAttribute(name = "pool-size-max")
	private int maxPoolSize = 32;
	
	@Getter
	@XmlAttribute(name = "pool-size-min")
	private int minPoolSize = 8;

}