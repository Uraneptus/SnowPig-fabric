package net.uraneptus.snowpig.core;

import com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModIntegrations {
    public static boolean isFDLoaded() {
        return FabricLoader.getInstance().getModContainer("farmersdelight").isPresent();
    }

    public static RegistryKey<ItemGroup> getFdItemGroup() {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("farmersdelight", "main"));
    }
//
//    public static Item getHam(){
//        return ItemsRegistry.HAM.get();
//    }
}