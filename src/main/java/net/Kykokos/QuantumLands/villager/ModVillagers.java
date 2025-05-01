package net.Kykokos.QuantumLands.villager;

import com.google.common.collect.ImmutableSet;
import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.sound.ModSounds;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.C;


public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, QuantumLands.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, QuantumLands.MOD_ID);

    public static final RegistryObject<PoiType> CHEMIST_POI = POI_TYPES.register("chemist_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CENTRIFUGE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> CHEMIST =
            VILLAGER_PROFESSIONS.register("chemist", () -> new VillagerProfession("chemist",
                    x -> x.get() == CHEMIST_POI.get(), x -> x.get() == CHEMIST_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.NITROGLYCERIN_EXPLOSION.get()));



    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
