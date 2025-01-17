package net.Kykokos.QuantumLands.fluid;

import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {

    public static final ResourceLocation MOLTEN_QUANTALYTH_STILL_RL = new ResourceLocation("block/molten_quantalyth_still");
    public static final ResourceLocation MOLTEN_QUANTALYTH_FLOW_RL = new ResourceLocation("block/molten_quantalyth_flow");
    public static final ResourceLocation MOLTEN_QUANTALYTH_OVERLAY_RL = new ResourceLocation("block/molten_quantalyth_still");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, QuantumLands.MOD_ID);

    public static final RegistryObject<FluidType> MOLTEN_QUANTALYTH_FLUID_TYPE = registerFluidType("molten_quantalyth_fluid",
            new BaseFluidType(MOLTEN_QUANTALYTH_STILL_RL, MOLTEN_QUANTALYTH_FLOW_RL, MOLTEN_QUANTALYTH_OVERLAY_RL, 0xA17E08FC,
                    new Vector3f(188f / 255f, 167f / 255f, 254f / 255f),
                    FluidType.Properties.create().lightLevel(2).viscosity(10).canSwim(false).canDrown(true).temperature(5000).density(15)));


    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType){
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
