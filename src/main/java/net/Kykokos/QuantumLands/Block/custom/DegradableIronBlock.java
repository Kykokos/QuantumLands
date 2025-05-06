package net.Kykokos.QuantumLands.Block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DegradableIronBlock extends Block implements IronDegradable {
    private IronDegradationLevel degradationLevel;

    public DegradableIronBlock(IronDegradationLevel degradationLevel, Properties pProperties) {
        super(pProperties);
        this.degradationLevel = degradationLevel;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        this.onRandomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return IronDegradable.getNext(pState.getBlock()).isPresent();
    }

    @Override
    public IronDegradationLevel getAge() {
        return degradationLevel;
    }
}
