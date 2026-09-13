package me.moddedmod.clouds.client.options;

import me.moddedmod.clouds.client.CloudsClientMod;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.NonNull;

public class CloudsScreen extends Screen {

    public CloudsScreen(Component title){
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        this.addRenderableWidget(Button.builder(Component.literal("Clouds color: "+ (CloudsClientMod.colorStr[CloudsClientMod.colorIndex])), _ -> {
            CloudsClientMod.colorIndex = (CloudsClientMod.colorIndex + 1) % CloudsClientMod.colorStr.length;
            CloudsOptions.writeToDisk();
            this.init();
        }).tooltip(Tooltip.create(Component.literal("Clouds color"))).bounds((this.width / 2) - (120 / 2), 20, 120, 20).build());
    }
}
