package net.Kykokos.QuantumLands.event;

import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.particle.GlassParticles;
import net.Kykokos.QuantumLands.particle.ModParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = QuantumLands.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event){
        event.registerSpriteSet(ModParticles.GLASS_PARTICLES.get(), GlassParticles.Provider::new);
    }
}
