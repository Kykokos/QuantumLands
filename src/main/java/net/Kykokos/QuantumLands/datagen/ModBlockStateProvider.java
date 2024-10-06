package net.Kykokos.QuantumLands.datagen;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider
{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, QuantumLands.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        blockWithItem(ModBlocks.BUNKER_BLOCK);
        blockWithItem(ModBlocks.CRACKED_BUNKER_BLOCK);
        blockWithItem(ModBlocks.SNIFFERITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SNIFFERITE_ORE);

        stairsBlock((StairBlock) ModBlocks.BUNKER_STAIRS.get(), blockTexture(ModBlocks.BUNKER_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.BUNKER_SLAB.get(), blockTexture(ModBlocks.BUNKER_BLOCK.get()), blockTexture(ModBlocks.BUNKER_BLOCK.get()));


        pressurePlateBlock((PressurePlateBlock) ModBlocks.BUNKER_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BUNKER_BLOCK.get()));
        buttonBlock((ButtonBlock) ModBlocks.EMERGENCY_BUTTON.get(), blockTexture(Blocks.REDSTONE_BLOCK));




        blockItem(ModBlocks.BUNKER_STAIRS);
        blockItem(ModBlocks.BUNKER_SLAB);
        blockItem(ModBlocks.BUNKER_PRESSURE_PLATE);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("quantum_lands:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}


