package net.Kykokos.QuantumLands.Block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;


public class UVLampBlock extends DirectionalBlock {
    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");
    public static final DirectionProperty ATTACHED_FACE = DirectionProperty.create("attached_face", Direction.values());
    public static final DirectionProperty HORIZONTAL_FACING = DirectionProperty.create("horizontal_facing", Direction.Plane.HORIZONTAL);

    public UVLampBlock(Properties pProperties) {
        super(pProperties.lightLevel(state -> state.getValue(CLICKED) ? 15 : 0));
        this.registerDefaultState(this.defaultBlockState()
                .setValue(CLICKED, false)
                .setValue(ATTACHED_FACE, Direction.UP)
                .setValue(HORIZONTAL_FACING, Direction.NORTH));

    }

    public static final VoxelShape SHAPE = Block.box(1, 0, 7, 15, 4, 9);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction face = state.getValue(ATTACHED_FACE);
        Direction horizontalFacing = state.getValue(HORIZONTAL_FACING);

        switch (face) {
            case UP:
                return getRotatedShape(1, 0, 7, 15, 4, 9, horizontalFacing);
            case DOWN:
                return getRotatedShape(1, 12, 7, 15, 16, 9, horizontalFacing);
            case NORTH:
                return Block.box(1, 7, 12, 15, 9, 16);
            case SOUTH:
                return Block.box(1, 7, 0, 15, 9, 4);
            case EAST:
                return Block.box(0, 7, 1, 4, 9, 15);
            case WEST:
                return Block.box(12, 7, 1, 16, 9, 15);
            default:
                return Block.box(1, 0, 7, 15, 4, 9);
        }
    }

    // Pomocná metoda pro ruční rotaci hitboxu
    private VoxelShape getRotatedShape(double x1, double y1, double z1, double x2, double y2, double z2, Direction direction) {
        switch (direction) {
            case EAST:
                return Block.box(16 - z2, y1, x1, 16 - z1, y2, x2);
            case SOUTH:
                return Block.box(16 - x2, y1, 16 - z2, 16 - x1, y2, 16 - z1);
            case WEST:
                return Block.box(z1, y1, 16 - x2, z2, y2, 16 - x1);
            default: // NORTH
                return Block.box(x1, y1, z1, x2, y2, z2);
        }
    }
    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();
        Direction playerFacing = context.getHorizontalDirection().getOpposite();

        return this.defaultBlockState()
                .setValue(ATTACHED_FACE, clickedFace)
                .setValue(HORIZONTAL_FACING, playerFacing)
                .setValue(CLICKED, false);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND)
        {
            boolean currentState = state.getValue(CLICKED);
            level.setBlock(pos, state.setValue(CLICKED, !currentState), 3);

        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(CLICKED);
        builder.add(ATTACHED_FACE);
        builder.add(HORIZONTAL_FACING);
    }

    public void onNeighborChange(BlockState state, Level level, BlockPos pos, BlockPos neighbor) {

        boolean isPowered = level.hasNeighborSignal(pos);

        level.setBlock(pos, state.setValue(CLICKED, isPowered), 3);
    }


    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);
        level.updateNeighborsAt(pos, this);
    }


    @Override
    public boolean isSignalSource(BlockState state) {
        return false;
    }
}

