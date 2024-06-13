package net.uraneptus.snowpig.common.items;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.uraneptus.snowpig.core.ModIntegrations;

public class FrozenHamItem extends FrozenItem {

    public FrozenHamItem(float attackDamage, float attackSpeed,int freezingTicks, Settings settings) {
        super(freezingTicks, settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS, createAttributeModifiers(attackDamage, attackSpeed)));
    }


    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return ModIntegrations.isFDLoaded();
    }

    public static AttributeModifiersComponent createAttributeModifiers(float baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, baseAttackDamage, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .build();
    }

}