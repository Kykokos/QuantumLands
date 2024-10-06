package net.Kykokos.QuantumLands.datagen;

import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider
{

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, QuantumLands.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SNIFFERITE_ORE.get(),
                    ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get(),
                    ModBlocks.BUNKER_BLOCK.get(),
                    ModBlocks.CRACKED_BUNKER_BLOCK.get(),
                    ModBlocks.BUNKER_STAIRS.get(),
                    ModBlocks.BUNKER_SLAB.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SNIFFERITE_ORE.get(),
                    ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get(),
                    ModBlocks.BUNKER_BLOCK.get(),
                    ModBlocks.CRACKED_BUNKER_BLOCK.get(),
                    ModBlocks.BUNKER_STAIRS.get(),
                    ModBlocks.BUNKER_SLAB.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
