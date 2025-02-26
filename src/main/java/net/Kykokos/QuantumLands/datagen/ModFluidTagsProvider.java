package net.Kykokos.QuantumLands.datagen;

import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, QuantumLands.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(FluidTags.LAVA)
                .add(ModFluids.SOURCE_MOLTEN_QUANTALYTH.get())
                .add(ModFluids.FLOWING_MOLTEN_QUANTALYTH.get());

        tag(FluidTags.WATER)
                .add(ModFluids.SOURCE_NITRIC_ACID.get())
                .add(ModFluids.FLOWING_NITRIC_ACID.get());
    }
}
