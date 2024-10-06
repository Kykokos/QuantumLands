package net.Kykokos.QuantumLands.datagen.loot;

import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider
{
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.BUNKER_BLOCK.get());
        this.dropSelf(ModBlocks.CRACKED_BUNKER_BLOCK.get());
        this.dropSelf(ModBlocks.BUNKER_STAIRS.get());
        this.dropSelf(ModBlocks.EMERGENCY_BUTTON.get());
        this.dropSelf(ModBlocks.BUNKER_PRESSURE_PLATE.get());

        this.add(ModBlocks.SNIFFERITE_ORE.get(), block -> createOreDrop(ModBlocks.SNIFFERITE_ORE.get(), ModItems.SNIFFERITE.get()));
        this.add(ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get(), ModItems.SNIFFERITE.get()));

        this.add(ModBlocks.BUNKER_SLAB.get(), block -> createSlabItemTable(ModBlocks.BUNKER_SLAB.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
