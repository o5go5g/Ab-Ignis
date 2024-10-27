package com.soliid.ab_ignis.item;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.item.custom.FuelItem;
import com.soliid.ab_ignis.item.custom.FuelShovelItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AbIgnis.MOD_ID);

    public static final RegistryObject<Item> IRON_BLOOM = ITEMS.register("iron_bloom",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FIBER = ITEMS.register("fiber",() -> new FuelItem(new Item.Properties(), 50));
    public static final RegistryObject<Item> TWINE = ITEMS.register("twine",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BONE_SHARD = ITEMS.register("bone_shard",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CROOK = ITEMS.register("crook",() -> new FuelShovelItem(Tiers.WOOD,-0.5f,-1f,new Item.Properties(),200));


    public static final RegistryObject<Item> FLINT_KNIFE = ITEMS.register("flint_knife", () -> new SwordItem(Tiers.WOOD,1,-1.5f,new Item.Properties()));
    public static final RegistryObject<Item> FLINT_HATCHET = ITEMS.register("flint_hatchet",() -> new AxeItem(Tiers.WOOD,2,-3f,new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
