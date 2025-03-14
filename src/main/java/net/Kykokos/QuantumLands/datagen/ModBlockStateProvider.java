package net.Kykokos.QuantumLands.datagen;

import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.Block.custom.UVLampBlock;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
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
        blockWithItem(ModBlocks.BLUE_PLANKS);
        blockWithItem(ModBlocks.RAW_QUANTALYTH_BLOCK);
        blockWithItem(ModBlocks.QUANTALYTH_BLOCK);
        blockWithItem(ModBlocks.QUANTALYTH_MEGA_BLOCK);

        stairsBlock((StairBlock) ModBlocks.BUNKER_STAIRS.get(), blockTexture(ModBlocks.BUNKER_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.BUNKER_SLAB.get(), blockTexture(ModBlocks.BUNKER_BLOCK.get()), blockTexture(ModBlocks.BUNKER_BLOCK.get()));


        pressurePlateBlock((PressurePlateBlock) ModBlocks.BUNKER_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BUNKER_BLOCK.get()));
        buttonBlock((ButtonBlock) ModBlocks.EMERGENCY_BUTTON.get(), blockTexture(Blocks.REDSTONE_BLOCK));

        fenceBlock((FenceBlock) ModBlocks.BLUE_FENCE.get(), blockTexture(ModBlocks.BLUE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.BLUE_FENCE_GATE.get(), blockTexture(ModBlocks.BLUE_PLANKS.get()));
        wallBlock((WallBlock) ModBlocks.BUNKER_WALL.get(), blockTexture(ModBlocks.BUNKER_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.BUNKER_DOOR.get(), modLoc("block/bunker_door_bottom"), modLoc("block/bunker_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.BUNKER_TRAPDOOR.get(), modLoc("block/bunker_trapdoor"), true, "cutout");


        blockItem(ModBlocks.BUNKER_STAIRS);
        blockItem(ModBlocks.BUNKER_SLAB);
        blockItem(ModBlocks.BUNKER_PRESSURE_PLATE);
        blockItem(ModBlocks.BLUE_FENCE_GATE);
        blockItem(ModBlocks.BUNKER_TRAPDOOR, "_bottom");

        customLamp();
    }

    /*private void customLamp() {
        getVariantBuilder(ModBlocks.UV_LAMP.get()).forAllStates(state -> {
            if(state.getValue(UVLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(
                        new ModelFile.UncheckedModelFile(modLoc("block/uv_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(
                        new ModelFile.UncheckedModelFile(modLoc("block/uv_lamp_off")))};
            }
        });
        directionalBlock(ModBlocks.UV_LAMP.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/uv_lamp_on")));
    } */

    private void customLamp() {
        getVariantBuilder(ModBlocks.UV_LAMP.get()).forAllStates(state -> {
            String modelName = state.getValue(UVLampBlock.CLICKED) ? "uv_lamp_on" : "uv_lamp_off";

            Direction face = state.getValue(UVLampBlock.ATTACHED_FACE);
            Direction front = state.getValue(UVLampBlock.HORIZONTAL_FACING);

            int rotationX = 0;
            int rotationY = 0;

            if (face == Direction.UP) {
                rotationX = 0;
                rotationY = switch (front) {
                    case NORTH -> 0;
                    case EAST -> 90;
                    case SOUTH -> 180;
                    case WEST -> 270;
                    default -> 0;
                };
            } else if (face == Direction.DOWN) {
                rotationX = 180;
                rotationY = switch (front) {
                    case NORTH -> 0;
                    case EAST -> 90;
                    case SOUTH -> 180;
                    case WEST -> 270;
                    default -> 0;
                };
            } else {
                rotationX = 90;
                rotationY = switch (face) {
                    case NORTH -> 0;
                    case SOUTH -> 180;
                    case EAST -> 90;
                    case WEST -> 270;
                    default -> 0;
                };
            }

            return ConfiguredModel.builder()
                    .modelFile(new ModelFile.UncheckedModelFile(modLoc("block/" + modelName)))
                    .rotationX(rotationX)
                    .rotationY(rotationY)
                    .build();
        });

        simpleBlockItem(ModBlocks.UV_LAMP.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/uv_lamp_on")));
    }



    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix)
    {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("quantum_lands:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
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


