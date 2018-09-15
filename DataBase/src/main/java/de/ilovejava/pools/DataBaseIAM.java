package de.ilovejava.pools;

import java.sql.Connection;
import java.util.Optional;

import com.mongodb.MongoClient;

import de.unitygaming.bukkit.udm.db.mariadb.MariaDB;
import de.unitygaming.bukkit.udm.db.mongodb.MongoDB;
import de.unitygaming.bukkit.udm.db.redis.Redis;
import redis.clients.jedis.Jedis;

public class DataBaseIAM implements PoolConnection{

	@Override
	public Optional<Connection> mariaDB(String database) {
		
		return MariaDB.getConnection(database);
	}

	@Override
	public MongoClient mongoDB() {
		// TODO Auto-generated method stub
		return MongoDB.getConnection();
	}

	@Override
	public Jedis redis() {
		// TODO Auto-generated method stub
		return Redis.getConnection();
	}
	
}
