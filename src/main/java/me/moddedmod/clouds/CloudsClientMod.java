package me.moddedmod.clouds;

import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloudsClientMod implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Clouds");

	@Override
	public void onInitializeClient() {
		LOGGER.info("Hello Fabric world!");
	}
}
