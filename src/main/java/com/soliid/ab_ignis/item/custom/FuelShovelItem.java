package com.soliid.ab_ignis.item.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelShovelItem extends ShovelItem
{
    private int burnTime = 0;
    public FuelShovelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, int burnTime) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}
