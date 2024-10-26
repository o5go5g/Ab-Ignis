package com.soliid.ab_ignis.datagen;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.item.ModItems;
import com.soliid.ab_ignis.loot.AddItemModifier;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, AbIgnis.MOD_ID);
    }
    @Override
    protected void start() {
        add("fiber_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModItems.CROOK.get())).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.FIBER.get()));
    }
}