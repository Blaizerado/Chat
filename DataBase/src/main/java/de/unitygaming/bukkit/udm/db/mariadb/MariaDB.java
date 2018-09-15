package de.unitygaming.bukkit.udm.db.mariadb;

import static java.lang.String.format;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MariaDB{

	private static final String CONNECTION_STRING = "jdbc:mariadb://%s:%d/%s?pool&minPoolSize=%d&maxPoolSize=%d";
	private static Connection connection = null;
	public static Optional<Connection> getConnection(String database) {
		try {
			connection = DriverManager.getConnection(
					format(CONNECTION_STRING, 
							MariaConfig.getInstance().getHost(), 
							MariaConfig.getInstance().getPort(), 
							database,
							MariaConfig.getInstance().getMinPoolSize(),
							MariaConfig.getInstance().getMaxPoolSize()), 
					MariaConfig.getInstance().getUser(), 
					MariaConfig.getInstance().getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.ofNullable(connection);
	}
}
