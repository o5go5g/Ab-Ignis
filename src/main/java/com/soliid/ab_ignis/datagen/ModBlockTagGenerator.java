package com.soliid.ab_ignis.datagen;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider
{

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AbIgnis.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.TIN_BLOCK.get(),
                ModBlocks.RAW_TIN_BLOCK.get(),
                ModBlocks.TIN_ORE.get(),
                ModBlocks.DEEPSLATE_TIN_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.BONE.get()
        );
    }
}
