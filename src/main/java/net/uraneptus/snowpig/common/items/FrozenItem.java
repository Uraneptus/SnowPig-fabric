package net.uraneptus.snowpig.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FrozenItem extends Item {

    private final int freezingTicks;
    public FrozenItem(int freezingTicks, Settings settings) {
        super(settings);
        this.freezingTicks = freezingTicks;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.setFrozenTicks(user.getFrozenTicks() + this.freezingTicks);
        return super.finishUsing(stack, world, user);
    }
}
