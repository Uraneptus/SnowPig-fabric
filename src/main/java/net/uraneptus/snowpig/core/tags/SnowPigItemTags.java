package net.uraneptus.snowpig.core.tags;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.uraneptus.snowpig.SnowPig;

public class SnowPigItemTags {

    public static final TagKey<Item> KNIVES = of(new Identifier("c", "tools/knives"));


    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, SnowPig.id(id));
    }
    private static TagKey<Item> of(Identifier id) {
        return TagKey.of(RegistryKeys.ITEM, id);
    }
}
