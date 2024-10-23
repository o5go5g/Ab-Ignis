package com.soliid.ab_ignis.item;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AbIgnis.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AB_IGNIS_TAB = CREATIVE_MODE_TABS.register("ab_ignis", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(Items.CAMPFIRE))
            .title(Component.translatable("creativetab.ab_ignis_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.IRON_BLOOM.get());
                pOutput.accept(ModItems.RAW_TIN.get());
                pOutput.accept(ModItems.TIN_INGOT.get());
                pOutput.accept(ModItems.FIBER.get());
                pOutput.accept(ModItems.TWINE.get());



                pOutput.accept(ModBlocks.TIN_BLOCK.get());
                pOutput.accept(ModBlocks.RAW_TIN_BLOCK.get());

            })
            .build());
    public static void register (IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
