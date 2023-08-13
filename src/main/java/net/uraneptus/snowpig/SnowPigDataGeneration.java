package net.uraneptus.snowpig;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.uraneptus.snowpig.common.datagens.*;

public class SnowPigDataGeneration implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(SnowPigEntityLootTableProvider::new);
        pack.addProvider(SnowPigBiomeTagProvider::new);
        pack.addProvider(SnowPigEntityTagProvider::new);
        pack.addProvider(SnowPigItemTagProvider::new);
        pack.addProvider(SnowPigRecipeProvider::new);
    }
}
