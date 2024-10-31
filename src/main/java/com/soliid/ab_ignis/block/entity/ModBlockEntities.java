package com.soliid.ab_ignis.block.entity;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AbIgnis.MOD_ID);

    public static final RegistryObject<BlockEntityType<FilterBlockEntity>> FILTER_BLOCK_ENTITY = BLOCK_ENTITIES.register("filter_block_entity",
            () -> BlockEntityType.Builder.of(FilterBlockEntity::new, ModBlocks.FILTER.get()).build(null));
}
