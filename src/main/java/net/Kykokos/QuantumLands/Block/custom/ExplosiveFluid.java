package net.Kykokos.QuantumLands.Block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.level.BlockEvent;
import  net.Kykokos.QuantumLands.fluid.ModFluids; // Ujisti se, že tohle je správná cesta k tvým tekutinám
import net.minecraftforge.registries.RegistryObject;

public class ExplosiveFluid extends LiquidBlock {


    public ExplosiveFluid(RegistryObject<FlowingFluid> fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block neighborState, BlockPos neighborPos, boolean isMoving) {
        super.neighborChanged(state, world, pos, neighborState, neighborPos, isMoving);

        if (!world.isClientSide) {
            if (isNearOtherFluid(world, pos)) {
                explode((ServerLevel) world, pos);
            }
        }
    }

    private boolean isNearOtherFluid(Level world, BlockPos pos) {
        return isTargetFluid(world, pos.above()) ||
                isTargetFluid(world, pos.below()) ||
                isTargetFluid(world, pos.north()) ||
                isTargetFluid(world, pos.south()) ||
                isTargetFluid(world, pos.east()) ||
                isTargetFluid(world, pos.west());
    }

    private boolean isTargetFluid(Level world, BlockPos pos) {
        FluidState fluid = world.getFluidState(pos);
        return fluid.getType() == Fluids.LAVA; // Nahraď OTHER_FLUID tekutinou, která způsobí výbuch
    }

    private void explode(ServerLevel world, BlockPos pos) {
        world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 2.0F, Level.ExplosionInteraction.MOB);
        world.playSound(null, pos, SoundEvents.GENERIC_EXPLODE, net.minecraft.sounds.SoundSource.BLOCKS, 2.0F, 100.0F);
    }
}

