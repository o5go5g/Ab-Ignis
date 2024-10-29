package com.soliid.ab_ignis.event;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.block.ModBlocks;
import com.soliid.ab_ignis.item.ModItems;
import com.soliid.ab_ignis.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AbIgnis.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class ModEvents
{
    @SubscribeEvent
    public static void onRightClickWithBone(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = player.level();
        ItemStack itemStack = event.getItemStack();

        if (itemStack.is(Items.BONE) && !level.isClientSide()) {
            BlockPos targetPos = event.getHitVec().getBlockPos().relative(event.getFace());

            if (level instanceof ServerLevel && level.isEmptyBlock(targetPos)) {
                level.setBlockAndUpdate(targetPos, ModBlocks.BONE.get().defaultBlockState());
                if (!player.isCreative()) { itemStack.shrink(1); }
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        Player player = Minecraft.getInstance().player;

        if (player != null && player.isHolding(ModItems.SIEVE.get())) {
            if (event.getHand() == InteractionHand.OFF_HAND) {
                event.setCanceled(true);
            }
        }
    }

}
