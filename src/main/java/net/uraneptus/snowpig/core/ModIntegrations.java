package net.uraneptus.snowpig.core;

import com.nhoryzon.mc.farmersdelight.FarmersDelightMod;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;

public class ModIntegrations {
    public static boolean isFDLoaded() {
        return FabricLoader.getInstance().getModContainer("farmersdelight").isPresent();
    }

    public static final ItemGroup getFdItemGroup() {
        return FarmersDelightMod.ITEM_GROUP;
    }
}