package net.Kykokos.QuantumLands.fluid;

import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, QuantumLands.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_QUANTALYTH = FLUIDS.register("molten_quantalyth_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_QUANTALYTH_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_QUANTALYTH = FLUIDS.register("flowing_molten_quantalyth_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_QUANTALYTH_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MOLTEN_QUANTALYTH_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MOLTEN_QUANTALYTH_FLUID_TYPE, SOURCE_MOLTEN_QUANTALYTH, FLOWING_MOLTEN_QUANTALYTH)
            .slopeFindDistance(2).levelDecreasePerBlock(3).block(ModBlocks.MOLTEN_QUANTALYTH_BLOCK).bucket(ModItems.MOLTEN_QUANTALYTH_BUCKET);

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}
