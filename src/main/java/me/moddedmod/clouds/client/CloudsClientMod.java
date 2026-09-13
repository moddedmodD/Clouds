package me.moddedmod.clouds.client;

import me.moddedmod.clouds.client.options.CloudsOptions;
import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloudsClientMod implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Clouds");

	public static int colorIndex = 0;
	public static final String[] colorStr = {"WHITE", "RED", "BLUE", "GREEN", "PURPLE", "PINK", "BLACK"};
	public static int[] colorVal = {0xFFFFFFFF, 0xFFFF0000, 0xFF0000FF, 0xFF00FF00, 0xFF800080, 0xFFFFC0CB, 0xFF000000};

	@Override
	public void onInitializeClient() {
		LOGGER.info("Clouds initialized");

		CloudsOptions.loadFromDisk();
	}
}
