package com.soliid.ab_ignis.datagen;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.item.ModItems;
import com.soliid.ab_ignis.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider
{
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, AbIgnis.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        this.tag(ItemTags.AXES)
                .add(ModItems.FLINT_HATCHET.get());
        this.tag(ItemTags.SWORDS)
                .add(ModItems.FLINT_KNIFE.get());
        this.tag(ItemTags.SHOVELS)
                .add(ModItems.CROOK.get());
        this.tag(ModTags.Items.SIEVEABLE)
                .add(Items.SAND);
        this.tag(ModTags.Items.SIEVEABLE)
                .add(Items.DIRT);
    }
}
