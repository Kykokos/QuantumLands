package net.Kykokos.QuantumLands.fluid;

import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.LavaFluid;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {

    public static final ResourceLocation MOLTEN_QUANTALYTH_STILL_RL = new ResourceLocation("quantum_lands:block/molten_quantalyth_still");
    public static final ResourceLocation MOLTEN_QUANTALYTH_FLOW_RL = new ResourceLocation("quantum_lands:block/molten_quantalyth_flow");
    public static final ResourceLocation MOLTEN_QUANTALYTH_OVERLAY_RL = new ResourceLocation("quantum_lands:block/molten_quantalyth_flow");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, QuantumLands.MOD_ID);

    public static final RegistryObject<FluidType> MOLTEN_QUANTALYTH_FLUID_TYPE = registerFluidType("molten_quantalyth_fluid",
            new BaseFluidType(MOLTEN_QUANTALYTH_STILL_RL, MOLTEN_QUANTALYTH_FLOW_RL, MOLTEN_QUANTALYTH_OVERLAY_RL, 0xA17E08FC,
                    new Vector3f(70f / 255f, 0f / 255f, 247f / 255f),
                    FluidType.Properties.create().lightLevel(15).viscosity(5).canSwim(false).canDrown(true).temperature(5000).density(100)));


    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType){
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
