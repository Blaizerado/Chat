package de.unitygaming.bukkit.udm.db.redis;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Redis {
	
	private static final JedisPool POOL = Redis.getConnectionPool();

	public static Jedis getConnection() {
		return POOL.getResource();
	}
	
	//TODO: Automatic Cleanup
	private static JedisPool getConnectionPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		
		config.setMaxTotal(RedisConfig.getInstance().getMaxPoolSize());
		config.setMinIdle(RedisConfig.getInstance().getMinPoolSize());
		
		return new JedisPool(config, RedisConfig.getInstance().getHost(), RedisConfig.getInstance().getPort());
	}

}
