package net.uraneptus.snowpig.common.items;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.uraneptus.snowpig.core.ModIntegrations;

public class FrozenHamItem extends FrozenItem {

    private final int attackDamage;
    private final float attackSpeed;

    public FrozenHamItem(int attackDamage, float attackSpeed,int freezingTicks, Settings settings) {
        super(freezingTicks, settings);
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }


    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return ModIntegrations.isFDLoaded();
    }

    @Override
    public AttributeModifiersComponent getAttributeModifiers(ItemStack stack) {
        return AttributeModifiersComponent.builder()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", attackDamage, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                .build();
    }
}