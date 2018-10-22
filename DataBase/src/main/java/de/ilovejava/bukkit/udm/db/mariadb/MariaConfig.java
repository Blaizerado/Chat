package de.ilovejava.bukkit.udm.db.mariadb;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Supplier;

import de.ilovejava.bukkit.udm.xml.XmlDocument;
import de.ilovejava.bukkit.udm.xml.config.ConfigFile;
import de.ilovejava.bukkit.udm.xml.config.Configuration;
import lombok.Getter;

@XmlDocument(folder = "Datenbankeinstellungen", file = "MariaDB")
@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.FIELD)
public class MariaConfig extends ConfigFile {

	private static final Supplier<MariaConfig> SUPPLIER = Configuration.provide(MariaConfig.class);

	public static MariaConfig getInstance() {
		return SUPPLIER.get();
	}

	@Getter
	@XmlAttribute(name = "host")
	public String host = "localhost";

	@Getter
	@XmlAttribute(name = "port")
	private int port = 3306;

	@Getter
	@XmlAttribute(name = "pool-size-min")
	private int minPoolSize = 4;
	
	@Getter
	@XmlAttribute(name = "pool-size-max")
	private int maxPoolSize = 32;
	
	@Getter
	@XmlElement(name = "user")
	private String user = "minecraft";

	@Getter
	@XmlElement(name = "password")
	private String password = "minecraft";

}
