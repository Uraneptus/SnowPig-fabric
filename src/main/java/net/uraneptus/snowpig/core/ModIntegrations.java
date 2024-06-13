package net.uraneptus.snowpig.core;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModIntegrations {
    public static boolean isFDLoaded() {
        return FabricLoader.getInstance().isModLoaded("farmersdelight");
    }

    public static RegistryKey<ItemGroup> getFdItemGroup() {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of("farmersdelight", "main"));
    }
//
//    public static Item getHam(){
//        return ItemsRegistry.HAM.get();
//    }
}