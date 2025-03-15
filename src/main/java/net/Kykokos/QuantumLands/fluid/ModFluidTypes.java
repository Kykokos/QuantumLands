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

    public static final ResourceLocation NITRIC_ACID_STILL_RL = new ResourceLocation("quantum_lands:block/nitric_acid_still");
    public static final ResourceLocation NITRIC_ACID_FLOW_RL = new ResourceLocation("quantum_lands:block/nitric_acid_flow");
    public static final ResourceLocation NITRIC_ACID_OVERLAY_RL = new ResourceLocation("quantum_lands:block/nitric_acid_overlay");

    public static final ResourceLocation NITRATION_BATH_STILL_RL = new ResourceLocation("quantum_lands:block/nitration_bath_still");
    public static final ResourceLocation NITRATION_BATH_FLOW_RL = new ResourceLocation("quantum_lands:block/nitration_bath_flow");
    public static final ResourceLocation NITRATION_BATH_OVERLAY_RL = new ResourceLocation("quantum_lands:block/nitration_bath_overlay");

    public static final ResourceLocation NITROGLYCERIN_STILL_RL = new ResourceLocation("quantum_lands:block/nitroglycerin_still");
    public static final ResourceLocation NITROGLYCERIN_FLOW_RL = new ResourceLocation("quantum_lands:block/nitroglycerin_flow");
    public static final ResourceLocation NITROGLYCERIN_OVERLAY_RL = new ResourceLocation("quantum_lands:block/nitroglycerin_overlay");

    public static final ResourceLocation GLYCERIN_STILL_RL = new ResourceLocation("quantum_lands:block/glycerin_still");
    public static final ResourceLocation GLYCERIN_FLOW_RL = new ResourceLocation("quantum_lands:block/glycerin_flow");
    public static final ResourceLocation GLYCERIN_OVERLAY_RL = new ResourceLocation("quantum_lands:block/glycerin_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, QuantumLands.MOD_ID);

    public static final RegistryObject<FluidType> MOLTEN_QUANTALYTH_FLUID_TYPE = registerFluidType("molten_quantalyth_fluid",
            new BaseFluidType(MOLTEN_QUANTALYTH_STILL_RL, MOLTEN_QUANTALYTH_FLOW_RL, MOLTEN_QUANTALYTH_OVERLAY_RL, 0xA17E08FC,
                    new Vector3f(70f / 255f, 0f / 255f, 247f / 255f),
                    FluidType.Properties.create().lightLevel(15).viscosity(5).canSwim(false).canDrown(true).temperature(5000).density(100)));

    public static final RegistryObject<FluidType> NITRIC_ACID_FLUID_TYPE = registerFluidType("nitric_acid_fluid",
            new BaseFluidType(NITRIC_ACID_STILL_RL, NITRIC_ACID_FLOW_RL, NITRIC_ACID_OVERLAY_RL, 0xA1FFF1C9,
                    new Vector3f(1f, 241f / 255f, 201f / 255f),
                    FluidType.Properties.create().viscosity(1).canSwim(false).canDrown(true).temperature(30).density(1).canExtinguish(true).fallDistanceModifier(10)));

    public static final RegistryObject<FluidType> NITRATION_BATH_FLUID_TYPE = registerFluidType("nitration_bath_fluid",
            new BaseFluidType(NITRATION_BATH_STILL_RL, NITRATION_BATH_FLOW_RL, NITRATION_BATH_OVERLAY_RL, 0xA1C2FAFF,
                    new Vector3f(194f / 255f, 250f / 255f, 1f),
                    FluidType.Properties.create().viscosity(1).canSwim(false).canDrown(true).temperature(30).density(1).canExtinguish(true).fallDistanceModifier(10)));

    public static final RegistryObject<FluidType> NITROGLYCERIN_FLUID_TYPE = registerFluidType("nitroglycerin_fluid",
            new BaseFluidType(NITROGLYCERIN_STILL_RL,NITROGLYCERIN_FLOW_RL, NITROGLYCERIN_OVERLAY_RL, 0xA1FFFFFF,
                    new Vector3f(1f, 1f, 1f),
                    FluidType.Properties.create().viscosity(1).canSwim(false).canDrown(true).temperature(30).density(1).canExtinguish(true).fallDistanceModifier(10)));

    public static final RegistryObject<FluidType> GLYCERIN_FLUID_TYPE = registerFluidType("glycerin_fluid",
            new BaseFluidType(GLYCERIN_STILL_RL,GLYCERIN_FLOW_RL, GLYCERIN_OVERLAY_RL, 0xA1FFFFFF,
                    new Vector3f(1f, 1f, 1f),
                    FluidType.Properties.create().viscosity(1).canSwim(true).canDrown(true).temperature(30).density(1).canExtinguish(true).fallDistanceModifier(10)));

    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType){
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
