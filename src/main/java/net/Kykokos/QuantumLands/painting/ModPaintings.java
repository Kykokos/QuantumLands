package net.Kykokos.QuantumLands.painting;

import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, QuantumLands.MOD_ID);


    public static final RegistryObject<PaintingVariant> BLUE_SKY = PAINTING_VARIANTS.register("blue_sky",
            () -> new PaintingVariant(64, 32));


    public static void register(IEventBus eventBus){
        PAINTING_VARIANTS.register(eventBus);
    }
}
