package de.unitygaming.bukkit.udm.xml.config;

/**
 * Marker for classes that contain configuration parameters. <br>
 * Beside that, some basic comfort utilities are provided.
 */
public abstract class ConfigFile {

	/**
	 * Saves the configuration to it's internally specified path on disk. <br>
	 * <b>Delegates to {@link Configuration#save(ConfigFile)}</b>
	 */
	public final void save() {
		Configuration.save(this);
	}

}
