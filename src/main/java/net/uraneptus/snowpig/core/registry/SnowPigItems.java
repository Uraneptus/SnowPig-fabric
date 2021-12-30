package net.uraneptus.snowpig.core.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.common.items.FrozenHam;
import net.uraneptus.snowpig.core.ModIntegrations;

@SuppressWarnings("unused")
public class SnowPigItems {
    public static final Item FROZEN_PORKCHOP = register("frozen_porkchop", new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).meat().statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 2), 1.0f).build())));
    public static final Item FROZEN_HAM = register("frozen_ham", new FrozenHam(2, -1.2F, new Item.Settings().group(ModIntegrations.isFDLoaded() ? ModIntegrations.getFdItemGroup() : ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 2), 1.0f).build())));
    public static final SpawnEggItem SNOW_PIG_EGG = register("snow_pig_spawn_egg", new SpawnEggItem(SnowPigEntity.SNOW_PIG, 0x70CFF3, 0xE2FBFA, new Item.Settings().group(ItemGroup.MISC)));
    public static Item MUSIC_DISC_FROSTY_SNIG = register("music_disc_frosty_snig", new MusicDiscItem(12, SnowPigSounds.MUSIC_DISC_FROSTY_SNIG, new Item.Settings().group(ItemGroup.MISC).maxCount(1).rarity(Rarity.RARE)));

    public static <T extends Item> T register(String path, T item) {
        Registry.register(Registry.ITEM, SnowPig.id(path), item);

        return item;
    }
}