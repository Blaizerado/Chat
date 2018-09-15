package de.ilovejava.pools;

import java.sql.Connection;
import java.util.Optional;

import com.mongodb.MongoClient;

import redis.clients.jedis.Jedis;

public interface PoolConnection {
	public Optional<Connection> mariaDB(String database);
	   
    public MongoClient mongoDB();
   
    public Jedis redis();
}
