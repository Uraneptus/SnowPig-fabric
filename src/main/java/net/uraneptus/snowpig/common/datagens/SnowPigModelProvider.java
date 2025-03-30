package net.uraneptus.snowpig.common.datagens;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.uraneptus.snowpig.core.registry.SnowPigItems;

public class SnowPigModelProvider extends FabricModelProvider {
    public SnowPigModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(SnowPigItems.FROZEN_HAM, Models.HANDHELD);
        itemModelGenerator.register(SnowPigItems.FROZEN_PORKCHOP, Models.GENERATED);
        itemModelGenerator.register(SnowPigItems.MUSIC_DISC_FROSTY_SNIG, Models.GENERATED);
        itemModelGenerator.register(SnowPigItems.SNOW_PIG_SPAWN_EGG, Models.GENERATED);
    }
}
