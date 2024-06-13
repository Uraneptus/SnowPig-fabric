package net.uraneptus.snowpig.core.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.common.items.FrozenHamItem;
import net.uraneptus.snowpig.common.items.FrozenItem;

@SuppressWarnings("unused")
public class SnowPigItems {

    public static final FoodComponent FROZZEN_MEAT = new FoodComponent.Builder().nutrition(5).saturationModifier(0.3f).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 2), 1.0f).build();
    public static final Item FROZEN_PORKCHOP = register("frozen_porkchop", new FrozenItem(400, new Item.Settings().food(FROZZEN_MEAT)));
    public static final Item FROZEN_HAM = register("frozen_ham", new FrozenHamItem(2.0f, -1.2F, 600, new Item.Settings().food(FROZZEN_MEAT)));
    public static final Item SNOW_PIG_EGG = register("snow_pig_spawn_egg", new SpawnEggItem(SnowPigEntityTypes.SNOW_PIG, 0x70CFF3, 0xE2FBFA, new Item.Settings()));
    public static Item MUSIC_DISC_FROSTY_SNIG = register("music_disc_frosty_snig", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(SnowPigJukeboxSongs.FROSTY_SNIG)));

    public static Item register(String path, Item item) {
        return Registry.register(Registries.ITEM, SnowPig.id(path), item);
    }

    public static void init(){

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.PORKCHOP, FROZEN_PORKCHOP, FROZEN_HAM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addBefore(Items.MUSIC_DISC_OTHERSIDE, MUSIC_DISC_FROSTY_SNIG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.addBefore(Items.SPIDER_SPAWN_EGG, SNOW_PIG_EGG);
        });
    }
}