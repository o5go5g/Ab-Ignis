package com.soliid.ab_ignis.item.custom;

import com.soliid.ab_ignis.event.ModEvents;
import com.soliid.ab_ignis.geo.SieveItemRenderer;

import com.soliid.ab_ignis.item.ModItems;
import com.soliid.ab_ignis.sound.ModSounds;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

public class SieveItem extends Item implements GeoItem
{
    private int burnTime = 40;
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }

    public boolean isAnimating = false;

    private static final RawAnimation SAND_SIEVE_ANIM = RawAnimation.begin().thenPlay("model.sand");
    private static final RawAnimation GRAVEL_SIEVE_ANIM = RawAnimation.begin().thenPlay("model.gravel");
    private static final RawAnimation DIRT_SIEVE_ANIM = RawAnimation.begin().thenPlay("model.dirt");
    private static final RawAnimation MUD_SIEVE_ANIM = RawAnimation.begin().thenPlay("model.mud");
    private static final RawAnimation RED_SAND_SIEVE_ANIM = RawAnimation.begin().thenPlay("model.red_sand");
    private static final RawAnimation SOUL_SAND_SIEVE_ANIM = RawAnimation.begin().thenPlay("model.soul_sand");
    private static final RawAnimation SOUL_SOIL_SIEVE_ANIM = RawAnimation.begin().thenPlay("model.soul_soil");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public boolean isPerspectiveAware() {
        return true;
    }

    private PlayState predicate(AnimationState<SieveItem> animationState) {
        ItemDisplayContext context = animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);

        if (context != ItemDisplayContext.FIRST_PERSON_RIGHT_HAND) {
                animationState.getController().setAnimation(RawAnimation.begin().then("model.idle", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
        }


        return PlayState.STOP;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private SieveItemRenderer renderer;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null)
                {
                    this.renderer = new SieveItemRenderer();
                }

                return this.renderer;
            }
        });
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Sand", 0, this::predicate)
                .triggerableAnim("sand", SAND_SIEVE_ANIM));
        controllers.add(new AnimationController<>(this, "Gravel", 0, this::predicate)
                .triggerableAnim("gravel", GRAVEL_SIEVE_ANIM));
        controllers.add(new AnimationController<>(this, "Dirt", 0, this::predicate)
                .triggerableAnim("dirt", DIRT_SIEVE_ANIM));
        controllers.add(new AnimationController<>(this, "Mud", 0, this::predicate)
                .triggerableAnim("mud", MUD_SIEVE_ANIM));
        controllers.add(new AnimationController<>(this, "Red Sand", 0, this::predicate)
                .triggerableAnim("red_sand",RED_SAND_SIEVE_ANIM));
        controllers.add(new AnimationController<>(this, "Soul Sand", 0, this::predicate)
                .triggerableAnim("soul_sand", SOUL_SAND_SIEVE_ANIM));
        controllers.add(new AnimationController<>(this, "Soul Soil", 0, this::predicate)
                .triggerableAnim("soul_soil", SOUL_SOIL_SIEVE_ANIM));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level instanceof ServerLevel serverLevel) {
            if (isAnimating) {
                return InteractionResultHolder.pass(player.getItemInHand(hand));
            }
            if (player.getOffhandItem().is(Items.SAND))
            {
                isAnimating = true;
                triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Sand", "sand");
                ItemStack offhandItem = player.getOffhandItem();
                ModEvents.startItemCountdown(player,SieveTables.getSandDrops(),160);
                if (!player.isCreative())
                    offhandItem.shrink(1);
            }
            if (player.getOffhandItem().is(Items.GRAVEL))
            {
                isAnimating = true;
                triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Gravel", "gravel");
                ItemStack offhandItem = player.getOffhandItem();
                if (!player.isCreative())
                    offhandItem.shrink(1);
                ModEvents.startItemCountdown(player,SieveTables.getGravelDrops(),160);
            }
            if (player.getOffhandItem().is(Items.DIRT))
            {
                isAnimating = true;
                triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Dirt", "dirt");
                ItemStack offhandItem = player.getOffhandItem();
                if (!player.isCreative())
                    offhandItem.shrink(1);
                ModEvents.startItemCountdown(player,SieveTables.getDirtDrops(),160);
            }
            if (player.getOffhandItem().is(Items.MUD))
            {
                isAnimating = true;
                triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Mud", "mud");
                ItemStack offhandItem = player.getOffhandItem();
                if (!player.isCreative())
                    offhandItem.shrink(1);
                ModEvents.startItemCountdown(player,SieveTables.getMudDrops(),160);
            }
            if (player.getOffhandItem().is(Items.RED_SAND))
            {
                isAnimating = true;
                triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Red Sand", "red_sand");
                ItemStack offhandItem = player.getOffhandItem();
                if (!player.isCreative())
                    offhandItem.shrink(1);
                ModEvents.startItemCountdown(player,SieveTables.getRedSandDrops(),160);
            }
            if (player.getOffhandItem().is(Items.SOUL_SAND))
            {
                isAnimating = true;
                triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Soul Sand", "soul_sand");
                ItemStack offhandItem = player.getOffhandItem();
                if (!player.isCreative())
                    offhandItem.shrink(1);
                ModEvents.startItemCountdown(player,SieveTables.getSoulDrops(),160);
            }
            /*
            if (player.getOffhandItem().is(Items.SOUL_SOIL))
            {

                isAnimating = true;
                triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Soul Soil", "soul_soil");
                ItemStack offhandItem = player.getOffhandItem();
                if (!player.isCreative())
                    offhandItem.shrink(1);
                ModEvents.startItemCountdown(player,SieveTables.getSoulDrops(),160);;
            }
            */
        }
        return super.use(level, player, hand);
    }


    public SieveItem(Properties properties)
    {
        super(properties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
