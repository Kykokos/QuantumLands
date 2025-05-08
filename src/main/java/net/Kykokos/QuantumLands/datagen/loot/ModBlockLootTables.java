package net.Kykokos.QuantumLands.datagen.loot;

import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.Block.custom.DarkFlowerCropBlock;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
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
        this.dropSelf(ModBlocks.BUNKER_WALL.get());
        this.dropSelf(ModBlocks.BUNKER_TRAPDOOR.get());
        this.dropSelf(ModBlocks.RAW_QUANTALYTH_BLOCK.get());
        this.dropSelf(ModBlocks.QUANTALYTH_BLOCK.get());
        this.dropSelf(ModBlocks.COMPRESSED_QUANTALYTH_BLOCK.get());
        this.dropSelf(ModBlocks.UV_LAMP.get());

        this.dropSelf(ModBlocks.WET_IRON_BLOCK.get());
        this.dropSelf(ModBlocks.LITTLE_RUSTED_IRON_BLOCK.get());
        this.dropSelf(ModBlocks.RUSTED_IRON_BLOCK.get());
        this.dropSelf(ModBlocks.FULLY_RUSTED_IRON_BLOCK.get());

        this.dropSelf(ModBlocks.BLUE_LOG.get());
        this.dropSelf(ModBlocks.BLUE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_BLUE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_BLUE_WOOD.get());
        this.dropSelf(ModBlocks.BLUE_PLANKS.get());
        this.dropSelf(ModBlocks.BLUE_FENCE.get());
        this.dropSelf(ModBlocks.BLUE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.BLUE_SAPLING.get());

        this.add(ModBlocks.BLUE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.BLUE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.SNIFFERITE_ORE.get(), block -> createOreDrop(ModBlocks.SNIFFERITE_ORE.get(), ModItems.SNIFFERITE.get()));
        this.add(ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get(), ModItems.SNIFFERITE.get()));

        this.add(ModBlocks.BUNKER_SLAB.get(), block -> createSlabItemTable(ModBlocks.BUNKER_SLAB.get()));

        this.add(ModBlocks.BUNKER_DOOR.get(), block -> createDoorTable(ModBlocks.BUNKER_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.DARK_FLOWER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DarkFlowerCropBlock.AGE, 6));
        this.add(ModBlocks.DARK_FLOWER_CROP.get(), this.createCropDrops(ModBlocks.DARK_FLOWER_CROP.get(),
                ModItems.DARK_FLOWER_BLOOM.get(), ModItems.DARK_FLOWER_SEEDS.get(), lootitemcondition$builder1));

        this.add(ModBlocks.DARK_FLOWER.get(), createOreDrop(ModBlocks.DARK_FLOWER.get(),ModItems.DARK_FLOWER_BLOOM.get()));
        this.add(ModBlocks.CENTRIFUGE.get(), createOreDrop(ModBlocks.CENTRIFUGE.get(),ModItems.CENTRIFUGE_ITEM.get()));
        this.add(ModBlocks.POTTED_DARK_FLOWER.get(), createPotFlowerItemTable(ModBlocks.POTTED_DARK_FLOWER.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
