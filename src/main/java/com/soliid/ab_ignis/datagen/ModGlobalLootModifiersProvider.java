package com.soliid.ab_ignis.datagen;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.block.ModBlocks;
import com.soliid.ab_ignis.item.ModItems;
import com.soliid.ab_ignis.loot.AddItemModifier;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.Set;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, AbIgnis.MOD_ID);
    }
    @Override
    protected void start() {
        add("fiber_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModItems.CROOK.get())).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()}, ModItems.FIBER.get()));
        add("bones_from_pig", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/pig")).build(),
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.KILLER, new EntityPredicate.Builder().equipment(new EntityEquipmentPredicate.Builder().mainhand(ItemPredicate.Builder.item().of(ModItems.FLINT_KNIFE.get()).build()).build()).build()).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()}, Items.BONE));
        add("bones_from_cow", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/cow")).build(),
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.KILLER, new EntityPredicate.Builder().equipment(new EntityEquipmentPredicate.Builder().mainhand(ItemPredicate.Builder.item().of(ModItems.FLINT_KNIFE.get()).build()).build()).build()).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()}, Items.BONE));
        add("bones_from_sheep", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/sheep")).build(),
                LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.KILLER, new EntityPredicate.Builder().equipment(new EntityEquipmentPredicate.Builder().mainhand(ItemPredicate.Builder.item().of(ModItems.FLINT_KNIFE.get()).build()).build()).build()).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()}, Items.BONE));
        }
}