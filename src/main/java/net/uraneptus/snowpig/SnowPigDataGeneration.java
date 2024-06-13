package net.uraneptus.snowpig;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.uraneptus.snowpig.common.datagens.*;
import net.uraneptus.snowpig.core.registry.SnowPigJukeboxSongs;

public class SnowPigDataGeneration implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(SnowPigEntityLootTableProvider::new);
        pack.addProvider(SnowPigModelProvider::new);
        pack.addProvider(SnowPigBiomeTagProvider::new);
        pack.addProvider(SnowPigEntityTagProvider::new);
        pack.addProvider(SnowPigItemTagProvider::new);
        pack.addProvider(SnowPigRecipeProvider::new);
        pack.addProvider(SnowPigJukeboxSongProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.JUKEBOX_SONG, SnowPigJukeboxSongs::bootstrap);
    }
}
