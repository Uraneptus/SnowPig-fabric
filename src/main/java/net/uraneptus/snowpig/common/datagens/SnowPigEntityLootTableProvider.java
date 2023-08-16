package net.uraneptus.snowpig.common.datagens;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.uraneptus.snowpig.core.registry.SnowPigEntityTypes;
import net.uraneptus.snowpig.core.registry.SnowPigItems;
import net.uraneptus.snowpig.core.tags.SnowPigEntityTags;

import java.util.function.BiConsumer;

public class SnowPigEntityLootTableProvider extends SimpleFabricLootTableProvider {

    protected static final EntityPredicate.Builder NEEDS_ENTITY_ON_FIRE = EntityPredicate.Builder.create().flags(net.minecraft.predicate.entity.EntityFlagsPredicate.Builder.create().onFire(true).build());

    public SnowPigEntityLootTableProvider(FabricDataOutput output) {
        super(output, LootContextTypes.ENTITY);
    }


    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(Registries.ENTITY_TYPE.getId(SnowPigEntityTypes.SNOW_PIG).withPrefixedPath("entities/"), LootTable.builder()

                /*
                    Porkchop Pool
                 */
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F)).with(ItemEntry.builder(SnowPigItems.FROZEN_PORKCHOP)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))
                        .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
                                NEEDS_ENTITY_ON_FIRE))).apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))))

                /*
                    Music Disc Pool
                 */
                .pool(LootPool.builder().with(ItemEntry.builder(SnowPigItems.MUSIC_DISC_FROSTY_SNIG))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER,
                                EntityPredicate.Builder.create().type(SnowPigEntityTags.KILLER_FOR_SNOWPIG_DISC))))
        );
//
//
//        exporter.accept(Registries.ENTITY_TYPE.getId(SnowPigEntityTypes.SNOW_PIG).withPrefixedPath("entities/"), LootTable.builder()
//
//                /*
//                    Frozen Porkchop Pool
//                 */
//                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F)).with(ItemEntry.builder(SnowPigItems.FROZEN_PORKCHOP)
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
//                        .apply(FurnaceSmeltLootFunction.builder().conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
//                                NEEDS_ENTITY_ON_FIRE))).apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)))))
//
//                /*
//                    Frozen Ham Pool
//                 */
//                .pool(LootPool.builder().with(ItemEntry.builder(SnowPigItems.FROZEN_HAM))
//                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER, EntityPredicate.Builder.create().equipment(EntityEquipmentPredicate.Builder.create().mainhand(ItemPredicate.Builder.create().tag(ItemTags.SWORDS).build()).build())))
//                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.5F, 0.1F))
//                        .build())
//
//                /*
//                    Music Disc Pool
//                 */
//                .pool(LootPool.builder().with(ItemEntry.builder(SnowPigItems.MUSIC_DISC_FROSTY_SNIG))
//                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER,
//                                EntityPredicate.Builder.create().type(SnowPigEntityTags.KILLER_FOR_SNOWPIG_DISC))))
//        );
    }

}
