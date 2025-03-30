package net.uraneptus.snowpig.common.items;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.uraneptus.snowpig.core.ModIntegrations;

public class FrozenHamItem extends FrozenItem {

    public FrozenHamItem(int freezingTicks, Settings settings) {
        super(freezingTicks, settings);
    }
    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return ModIntegrations.isFDLoaded();
    }
}