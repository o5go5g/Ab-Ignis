package com.soliid.ab_ignis.item.custom;

import com.soliid.ab_ignis.event.ModEvents;
import com.soliid.ab_ignis.geo.SieveItemRenderer;

import com.soliid.ab_ignis.item.ModItems;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtils;

import java.util.function.Consumer;

public class SieveItem extends Item implements GeoItem
{
    private static final RawAnimation SAND_SIEVE_ANIM = RawAnimation.begin().thenPlay("model.sand");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public boolean isPerspectiveAware() {
        return false;
    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
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
        controllers.add(new AnimationController<>(this, "Sand", 0, state -> PlayState.CONTINUE)
                .triggerableAnim("sand", SAND_SIEVE_ANIM));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level instanceof ServerLevel serverLevel) {
            if (player.getOffhandItem().is(Items.SAND))
            {
                triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Sand", "sand");
                ItemStack offhandItem = player.getOffhandItem();
                if (!player.isCreative())
                    offhandItem.shrink(1);
                ModEvents.startItemCountdown(player,ModItems.LIMESALT.get(),120);
            }
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
