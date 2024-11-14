package com.soliid.ab_ignis.event;

import java.util.*;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.block.ModBlocks;
import com.soliid.ab_ignis.item.ModItems;
import com.soliid.ab_ignis.item.custom.SieveItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    private static final Map<UUID, CountdownData> playerCountdowns = new HashMap<>();

    private static class CountdownData {
        int ticksRemaining;
        ArrayList<ItemStack> itemStack;

        public CountdownData(int ticks, ArrayList<ItemStack> itemStack) {
            this.ticksRemaining = ticks;
            this.itemStack = itemStack;
        }
    }

    public static void startItemCountdown(Player player, ArrayList<ItemStack> item, int delay)
    {
        playerCountdowns.put(player.getUUID(), new CountdownData(delay, item));
    }

    @SubscribeEvent
    public static void onSieveAnimation(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (playerCountdowns.containsKey(player.getUUID())) {
            CountdownData countdownData = playerCountdowns.get(player.getUUID());
            countdownData.ticksRemaining--;
            Level level = player.level();
            if (countdownData.ticksRemaining % 7 == 0)
            {
                if (player.getOffhandItem().is(Items.SAND) || player.getOffhandItem().is(Items.RED_SAND))
                    level.playSound(null,new BlockPos(new Vec3i(player.getBlockX(),player.getBlockY(),player.getBlockZ())), SoundEvents.BRUSH_SAND, SoundSource.BLOCKS,0.5f,1f);
                if (player.getOffhandItem().is(Items.GRAVEL))
                    level.playSound(null,new BlockPos(new Vec3i(player.getBlockX(),player.getBlockY(),player.getBlockZ())), SoundEvents.GRAVEL_STEP, SoundSource.BLOCKS,0.35f,1f);
                if (player.getOffhandItem().is(Items.DIRT))
                    level.playSound(null,new BlockPos(new Vec3i(player.getBlockX(),player.getBlockY(),player.getBlockZ())), SoundEvents.ROOTED_DIRT_PLACE, SoundSource.BLOCKS,0.5f,1f);
                if (player.getOffhandItem().is(Items.MUD))
                    level.playSound(null,new BlockPos(new Vec3i(player.getBlockX(),player.getBlockY(),player.getBlockZ())), SoundEvents.MUD_PLACE, SoundSource.BLOCKS,0.5f,1f);
                if (player.getOffhandItem().is(Items.SOUL_SAND))
                    level.playSound(null,new BlockPos(new Vec3i(player.getBlockX(),player.getBlockY(),player.getBlockZ())), SoundEvents.SOUL_SOIL_STEP, SoundSource.BLOCKS,0.5f,1f);
            }
            if (countdownData.ticksRemaining <= 0) {
                for (ItemStack entry : countdownData.itemStack)
                {
                    ItemEntity item = new ItemEntity(level,0,0,0,entry);
                    item.moveTo(player.getX(),player.getY(),player.getZ());
                    level.addFreshEntity(item);
                }
                if (player.getMainHandItem().getItem() instanceof SieveItem sieveItem) {
                    sieveItem.isAnimating = false;
                    if (!player.isCreative())
                        player.getMainHandItem().setDamageValue(player.getMainHandItem().getDamageValue()+1);
                }
                else
                {
                    for (ItemStack stack : player.getInventory().items) {
                        if (stack.getItem() instanceof SieveItem sieveItem) {
                            sieveItem.isAnimating = false;
                            if (!player.isCreative())
                                sieveItem.setDamage(stack,stack.getDamageValue()+1);
                        }
                    }
                }
            }
            if (countdownData.ticksRemaining <=-1)
                playerCountdowns.remove(player.getUUID());
        }
    }
/*
    @SubscribeEvent
    public static void onDropItem(ItemTossEvent event)
    {
        Player player = event.getPlayer();
        if (player != null && player.getMainHandItem().getItem() instanceof SieveItem item)
        {
            if (item.getAnimationState())
                item.setAnimationState(false);
        }
    }
 */
}
