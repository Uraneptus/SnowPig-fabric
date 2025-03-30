package net.uraneptus.snowpig.core.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Rarity;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.common.items.FrozenHamItem;
import net.uraneptus.snowpig.common.items.FrozenItem;
import net.uraneptus.snowpig.core.ModIntegrations;
import net.uraneptus.snowpig.core.registry.data.SnowPigConsumableComponents;
import net.uraneptus.snowpig.core.registry.data.SnowPigFoodComponents;

import java.util.function.Function;

@SuppressWarnings("unused")
public class SnowPigItems {
    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, SnowPig.id(id));
    }


    public static final Item FROZEN_PORKCHOP = register("frozen_porkchop", settings -> new FrozenItem(400, settings), new Item.Settings().food(SnowPigFoodComponents.FROZEN_MEAT, SnowPigConsumableComponents.FROZEN_MEAT));

    public static final Item FROZEN_HAM = register("frozen_ham", settings -> new FrozenHamItem(600,
            settings),
            new Item.Settings()
                    .food(SnowPigFoodComponents.FROZEN_MEAT, SnowPigConsumableComponents.FROZEN_MEAT)
                    .component(DataComponentTypes.ATTRIBUTE_MODIFIERS, createHamModifiers(2.0f, -1.2F))
    );

    public static final Item SNOW_PIG_SPAWN_EGG = register("snow_pig_spawn_egg", settings -> new SpawnEggItem(SnowPigEntityTypes.SNOW_PIG, settings));
    public static Item MUSIC_DISC_FROSTY_SNIG = register("music_disc_frosty_snig", new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(SnowPigJukeboxSongs.FROSTY_SNIG));

    public static AttributeModifiersComponent createHamModifiers(float baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder()
                .add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, baseAttackDamage, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .build();
    }
    public static Item register(String path, Item.Settings settings) {
        return Items.register(keyOf(path), Item::new, settings);
    }
    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings){
        return Items.register(keyOf(path), factory, settings);
    }
    public static Item register(String path, Function<Item.Settings, Item> factory){
        return Items.register(keyOf(path), factory);
    }


    public static void init(){

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.PORKCHOP, FROZEN_PORKCHOP, FROZEN_HAM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addBefore(Items.MUSIC_DISC_OTHERSIDE, MUSIC_DISC_FROSTY_SNIG);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.addBefore(Items.SPIDER_SPAWN_EGG, SNOW_PIG_SPAWN_EGG);
        });
        if (ModIntegrations.isFDLoaded()){
            ItemGroupEvents.modifyEntriesEvent(ModIntegrations.getFdItemGroup()).register(entries -> {
                entries.add(FROZEN_HAM);
            });
        }
    }
}