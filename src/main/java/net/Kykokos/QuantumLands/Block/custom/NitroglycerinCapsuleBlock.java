package net.Kykokos.QuantumLands.Block.custom;

import net.Kykokos.QuantumLands.particle.ModParticles;
import net.Kykokos.QuantumLands.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class NitroglycerinCapsuleBlock extends Block {
    public static final DirectionProperty HORIZONTAL_FACING = HorizontalDirectionalBlock.FACING;

    public NitroglycerinCapsuleBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(HORIZONTAL_FACING, Direction.NORTH));
    }

    private static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 4, 15, 8, 12);
    private static final VoxelShape SHAPE_SOUTH = Block.box(1, 0, 4, 16, 8, 12);
    private static final VoxelShape SHAPE_EAST = Block.box(4, 0, 1, 12, 8, 16);
    private static final VoxelShape SHAPE_WEST = Block.box(4, 0, 0, 12, 8, 15);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(HORIZONTAL_FACING)) {
            case SOUTH:
                return SHAPE_SOUTH;
            case EAST:
                return SHAPE_EAST;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 20.0f, true, Level.ExplosionInteraction.TNT);
        level.playSound(null,pos.getX(), pos.getY(), pos.getZ(), ModSounds.NITROGLYCERIN_EXPLOSION.get(), SoundSource.BLOCKS, 10F,1F);

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    private void explodeBlock(Level level, BlockPos pos) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 20.0f, true, Level.ExplosionInteraction.TNT);
        level.playSound(null,pos.getX(), pos.getY(), pos.getZ(), ModSounds.NITROGLYCERIN_EXPLOSION.get(), SoundSource.BLOCKS, 10F,1F);

    }

    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult result, Projectile projectile) {
        explodeBlock(level, result.getBlockPos());
    }

    @Override
    public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 20.0f, true, Level.ExplosionInteraction.TNT);
        level.playSound(null,pos.getX(), pos.getY(), pos.getZ(), ModSounds.NITROGLYCERIN_EXPLOSION.get(), SoundSource.BLOCKS, 10F,1F);
        super.onCaughtFire(state, level, pos, direction, igniter);
    }
}