package net.uraneptus.snowpig.common.datagens;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
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
    }
}
