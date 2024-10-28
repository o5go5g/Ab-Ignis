package com.soliid.ab_ignis.datagen;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AbIgnis.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        simpleItem(ModItems.CROOK);
        simpleItem(ModItems.IRON_BLOOM);
        simpleItem(ModItems.RAW_TIN);
        simpleItem(ModItems.TIN_INGOT);
        simpleItem(ModItems.FIBER);
        simpleItem(ModItems.TWINE);
        simpleItem(ModItems.BONE_SHARD);
        simpleItem(ModItems.TANNED_LEATHER);
        simpleItem(ModItems.LIMESALT);
        simpleItem(ModItems.MESH);
        simpleItem(ModItems.FLINT_HATCHET);
        simpleItem(ModItems.FLINT_KNIFE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AbIgnis.MOD_ID, "item/" + item.getId().getPath()));
    }
}
