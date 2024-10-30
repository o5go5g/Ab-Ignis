package com.soliid.ab_ignis.sound;

import com.soliid.ab_ignis.AbIgnis;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
            AbIgnis.MOD_ID);

    public static RegistryObject<SoundEvent> SAND_SIEVE = SOUNDS.register("sand_sieve",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AbIgnis.MOD_ID, "sand_sieve")));
}
