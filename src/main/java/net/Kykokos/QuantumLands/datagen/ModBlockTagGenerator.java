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
                .add(ModBlocks.BLUE_PLANKS.get(),
                        ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get(),
                        ModBlocks.BUNKER_BLOCK.get(),
                        ModBlocks.CRACKED_BUNKER_BLOCK.get(),
                        ModBlocks.BUNKER_STAIRS.get(),
                        ModBlocks.BUNKER_SLAB.get(),
                        ModBlocks.RAW_QUANTALYTH_BLOCK.get(),
                        ModBlocks.QUANTALYTH_BLOCK.get(),
                        ModBlocks.WET_IRON_BLOCK.get(),
                        ModBlocks.LITTLE_RUSTED_IRON_BLOCK.get(),
                        ModBlocks.RUSTED_IRON_BLOCK.get(),
                        ModBlocks.FULLY_RUSTED_IRON_BLOCK.get(),
                        ModBlocks.COMPRESSED_QUANTALYTH_BLOCK.get(),
                        ModBlocks.UV_LAMP.get(),
                        ModBlocks.CENTRIFUGE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.BLUE_PLANKS.get(),
                        ModBlocks.BLUE_FENCE.get(),
                        ModBlocks.BLUE_FENCE_GATE.get(),
                        ModBlocks.BLUE_WOOD.get(),
                        ModBlocks.STRIPPED_BLUE_WOOD.get(),
                        ModBlocks.STRIPPED_BLUE_LOG.get(),
                        ModBlocks.BLUE_LOG.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BUNKER_BLOCK.get(),
                        ModBlocks.CRACKED_BUNKER_BLOCK.get(),
                        ModBlocks.BUNKER_STAIRS.get(),
                        ModBlocks.BUNKER_SLAB.get(),
                        ModBlocks.WET_IRON_BLOCK.get(),
                        ModBlocks.LITTLE_RUSTED_IRON_BLOCK.get(),
                        ModBlocks.RUSTED_IRON_BLOCK.get(),
                        ModBlocks.FULLY_RUSTED_IRON_BLOCK.get(),
                        ModBlocks.BUNKER_WALL.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SNIFFERITE_ORE.get(),
                    ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get(),
                    ModBlocks.RAW_QUANTALYTH_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_QUANTALYTH_TOOL)
                .add(ModBlocks.QUANTALYTH_BLOCK.get(),
                        ModBlocks.COMPRESSED_QUANTALYTH_BLOCK.get());

        this.tag(ModTags.Blocks.PAXEL_MINABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_HOE);

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.BLUE_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.BLUE_FENCE_GATE.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.BUNKER_WALL.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLUE_LOG.get())
                .add(ModBlocks.BLUE_WOOD.get())
                .add(ModBlocks.STRIPPED_BLUE_LOG.get())
                .add(ModBlocks.STRIPPED_BLUE_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.BLUE_PLANKS.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
