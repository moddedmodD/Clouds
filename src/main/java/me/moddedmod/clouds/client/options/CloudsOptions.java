package me.moddedmod.clouds.client.options;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.moddedmod.clouds.client.CloudsClientMod;
import net.fabricmc.loader.api.FabricLoader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class CloudsOptions {

    private static final String FILE_NAME = "clouds-options.json";
    private static final String INDEX = "index";
    private static final Gson GSON = new
            GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static void writeToDisk(){

        new Thread(() -> {
            Path path = FabricLoader.getInstance().getConfigDir().resolve(FILE_NAME);

            try (FileWriter writer = new FileWriter(String.valueOf(path))){
                JsonObject json = new JsonObject();

                json.addProperty(INDEX, CloudsClientMod.colorIndex);

                GSON.toJson(json, writer);
            } catch (IOException e) {
                throw new IllegalStateException("Failed to apply changes to Informium " + e);
            }
        }
        ).start();
    }
    public static void loadFromDisk(){
        Path path = FabricLoader.getInstance().getConfigDir().resolve(FILE_NAME);
        if (!path.toFile().exists()){
            writeToDisk();
        } else {
            try (FileReader reader = new FileReader(path.toFile())){
                JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

                if (json.has(INDEX)){
                    CloudsClientMod.colorIndex = json.get(INDEX).getAsInt();
                }
            } catch (IOException e){
                throw new IllegalStateException(e);
            }
        }
    }
}
