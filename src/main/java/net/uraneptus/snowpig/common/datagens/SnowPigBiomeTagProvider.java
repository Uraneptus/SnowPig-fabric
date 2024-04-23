package net.uraneptus.snowpig.common.datagens;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.uraneptus.snowpig.core.tags.SnowPigBiomeTags;

import java.util.concurrent.CompletableFuture;

public class SnowPigBiomeTagProvider extends FabricTagProvider<Biome> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public SnowPigBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(SnowPigBiomeTags.SPAWNS_SNOW_PIG)
                .add(BiomeKeys.SNOWY_PLAINS)
                .add(BiomeKeys.ICE_SPIKES)
                .add(BiomeKeys.FROZEN_OCEAN)
                .add(BiomeKeys.SNOWY_TAIGA)
                .add(BiomeKeys.FROZEN_RIVER)
                .add(BiomeKeys.SNOWY_BEACH)
                .add(BiomeKeys.FROZEN_PEAKS)
                .add(BiomeKeys.JAGGED_PEAKS)
                .add(BiomeKeys.SNOWY_SLOPES)
                .add(BiomeKeys.GROVE)
        ;
    }
}
