package de.ilovejava.pools;

import java.sql.Connection;
import java.util.Optional;

import com.mongodb.MongoClient;

import de.unitygaming.bukkit.udm.db.mariadb.MariaDB;
import de.unitygaming.bukkit.udm.db.mongodb.MongoDB;
import de.unitygaming.bukkit.udm.db.redis.Redis;
import redis.clients.jedis.Jedis;

public interface PoolConnection {
	public static  Optional<Connection> getMariaDBConnection(String db) {
		return MariaDB.getConnection(db);
	}
	
	public static MongoClient getMongoClient() {
		return MongoDB.getConnection();
	}
	
	public static Jedis getRedisPoll() {
		return Redis.getConnection();
	}
}
