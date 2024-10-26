package com.soliid.ab_ignis.datagen;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.item.ModItems;
import com.soliid.ab_ignis.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider
{
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, AbIgnis.MOD_ID);
    }

    @Override
    protected void start()
    {
        add("twine_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build(),

        }, ModItems.FIBER.get()));
    }
}
