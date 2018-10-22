package de.ilovejava.bukkit.udm.db.mongodb;



import com.mongodb.MongoClient;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MongoDB {

	//TODO: Connection Pooling
	public static MongoClient getConnection() {
		return new MongoClient(MongoConfig.getInstance().getHost(), MongoConfig.getInstance().getPort());
	}

}
