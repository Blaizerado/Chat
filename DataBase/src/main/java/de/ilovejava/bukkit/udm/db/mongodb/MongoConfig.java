package de.ilovejava.bukkit.udm.db.mongodb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Supplier;

import de.ilovejava.bukkit.udm.xml.XmlDocument;
import de.ilovejava.bukkit.udm.xml.config.ConfigFile;
import de.ilovejava.bukkit.udm.xml.config.Configuration;
import lombok.Getter;

@XmlDocument(folder = "Datenbankeinstellungen", file = "MongoDB")
@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.FIELD)
public class MongoConfig extends ConfigFile {

	private static final Supplier<MongoConfig> SUPPLIER = Configuration.provide(MongoConfig.class);

	public static MongoConfig getInstance() {
		return SUPPLIER.get();
	}

	@Getter
	@XmlAttribute(name = "host")
	private String host = "localhost";

	@Getter
	@XmlAttribute(name = "port")
	private int port = 27017;

}

