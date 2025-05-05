package net.Kykokos.QuantumLands.sound;

import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, QuantumLands.MOD_ID);

    public static final RegistryObject<SoundEvent> DISTANT_EXPLOSION = registerSoundEvents("distant_explosion");
    public static final RegistryObject<SoundEvent> NITROGLYCERIN_EXPLOSION = registerSoundEvents("nitroglycerin_explosion");
    public static final RegistryObject<SoundEvent> CENTRIFUGE_WORKING = registerSoundEvents("centrifuge_working");
    public static final RegistryObject<SoundEvent> BREAKING_BAD_THEME = registerSoundEvents("breaking_bad_theme");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        ResourceLocation id = new ResourceLocation(QuantumLands.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }
}
