package net.uraneptus.snowpig.core.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.uraneptus.snowpig.SnowPig;

public class ItemReg {
    public static final Item FROZEN_PORKCHOP = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder()
        .hunger(3).saturationModifier(0.6f).meat().statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 2), 1.0f).build()));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(SnowPig.MOD_ID, "frozen_porkchop"), FROZEN_PORKCHOP);
    }
}
