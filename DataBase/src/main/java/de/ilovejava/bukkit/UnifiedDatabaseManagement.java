package de.ilovejava.bukkit;

import java.sql.Connection;
import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

import de.ilovejava.bukkit.udm.db.mariadb.MariaConfig;
import de.ilovejava.bukkit.udm.db.mongodb.MongoConfig;
import de.ilovejava.bukkit.udm.db.redis.RedisConfig;
import de.ilovejava.bukkit.udm.xml.config.Configuration;
import de.ilovejava.pools.PoolConnection;
import lombok.Getter;

public class UnifiedDatabaseManagement extends JavaPlugin {

	@Getter
	private static volatile UnifiedDatabaseManagement instance = null;
	@Override
	public void onLoad() {
		instance = this;
	}

	@Override
	public void onEnable() {
		/*
		 *  Creating default Configuration files if necessary
		 */
		Configuration.saveDefault(RedisConfig.class);
		Configuration.saveDefault(MariaConfig.class);
		Configuration.saveDefault(MongoConfig.class);
	}

	@Override
	public void onDisable() {
		instance = null;
	}

}
