package net.uraneptus.snowpig.common.datagens;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.uraneptus.snowpig.core.tags.SnowPigEntityTags;

import java.util.concurrent.CompletableFuture;

public class SnowPigEntityTagProvider extends FabricTagProvider<EntityType<?>> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance

     * @param registriesFuture the backing registry for the tag type
     */
    public SnowPigEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ENTITY_TYPE, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(SnowPigEntityTags.KILLER_FOR_SNOWPIG_DISC)
                .add(EntityType.STRAY)
                .addOptional(new Identifier("tinyskeletons:baby_stray"));
    }
}
