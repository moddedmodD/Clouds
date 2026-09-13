package me.moddedmod.clouds.client;

import com.terraformersmc.modmenu.api.ModMenuApi;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import me.moddedmod.clouds.client.options.CloudsScreen;
import net.minecraft.network.chat.Component;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return _ -> new CloudsScreen(Component.literal("Clouds"));
    }
}
