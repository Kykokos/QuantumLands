package net.Kykokos.QuantumLands.event;

import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.sound.ModSounds;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.server.level.ServerLevel;

@Mod.EventBusSubscriber(modid = QuantumLands.MOD_ID)
public class ExplosionSoundHandler {


    @SubscribeEvent
    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        if (event.getExplosion() != null && event.getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.playSound(
                    null, // kdo slyší (null = všichni hráči poblíž)
                    event.getExplosion().getPosition().x,
                    event.getExplosion().getPosition().y,
                    event.getExplosion().getPosition().z,
                    ModSounds.DISTANT_EXPLOSION.get(),
                    net.minecraft.sounds.SoundSource.BLOCKS,
                    10F, // x 16
                    1.0F  // pitch
            );
        }
    }

}
