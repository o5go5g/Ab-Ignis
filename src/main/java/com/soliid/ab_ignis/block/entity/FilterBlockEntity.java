package com.soliid.ab_ignis.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FilterBlockEntity extends BlockEntity
{
    public FilterBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FILTER_BLOCK_ENTITY.get(), pPos, pBlockState);
    }
}
