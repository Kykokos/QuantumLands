package net.Kykokos.QuantumLands.event;

import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.fluid.ModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = QuantumLands.MOD_ID)
public class FluidExplosionHandler {

    @SubscribeEvent
    public static void onFluidPlaced(BlockEvent.EntityPlaceEvent event) {
        Level world = (Level) event.getLevel();
        BlockPos pos = event.getPos();

        FluidState placedFluid = world.getFluidState(pos);

        if (placedFluid.getType() == ModFluids.FLOWING_NITROGLYCERIN.get()) {
            if (isNearOtherFluid(world, pos)) {
                world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 2.0F, Level.ExplosionInteraction.MOB);
            }
        }
    }

    private static boolean isNearOtherFluid(Level world, BlockPos pos) {
        return isTargetFluid(world, pos.above()) ||
                isTargetFluid(world, pos.below()) ||
                isTargetFluid(world, pos.north()) ||
                isTargetFluid(world, pos.south()) ||
                isTargetFluid(world, pos.east()) ||
                isTargetFluid(world, pos.west());
    }

    private static boolean isTargetFluid(Level world, BlockPos pos) {
        FluidState fluid = world.getFluidState(pos);
        return fluid.getType() == Fluids.LAVA;
    }
}
