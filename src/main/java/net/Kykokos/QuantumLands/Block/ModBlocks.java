package net.Kykokos.QuantumLands.Block;

import net.Kykokos.QuantumLands.Block.custom.*;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.fluid.ModFluids;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;
import java.util.function.Supplier;

import static net.Kykokos.QuantumLands.Item.ModItems.ITEMS;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, QuantumLands.MOD_ID);


    public static final RegistryObject<Block> BUNKER_BLOCK = registerBlock("bunker_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                    .strength(9.0F, 1500.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> CRACKED_BUNKER_BLOCK = registerBlock("cracked_bunker_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(8.0F, 1400.0F)
                    .sound(SoundType.METAL).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SNIFFERITE_ORE = registerBlock("snifferite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).requiresCorrectToolForDrops()
                    .strength(5.0F, 20.0F).sound(SoundType.SMALL_AMETHYST_BUD), UniformInt.of(5, 8)));

    public static final RegistryObject<Block> DEEPSLATE_SNIFFERITE_ORE = registerBlock("deepslate_snifferite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).requiresCorrectToolForDrops()
                    .strength(5.0F, 25.0F).sound(SoundType.MEDIUM_AMETHYST_BUD), UniformInt.of(6, 9)));

    public static final RegistryObject<Block> BUNKER_STAIRS = registerBlock("bunker_stairs",
            () -> new StairBlock(() -> ModBlocks.BUNKER_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                    .strength(8.7F, 1600.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> BUNKER_SLAB = registerBlock("bunker_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                    .strength(8.5F, 1650.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> EMERGENCY_BUTTON = registerBlock("emergency_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)
                    .strength(0.5F, 1650.0F).sound(SoundType.METAL), BlockSetType.IRON, 2, false));

    public static final RegistryObject<Block> BUNKER_PRESSURE_PLATE = registerBlock("bunker_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                    .strength(8.5F, 1650.0F).sound(SoundType.METAL), BlockSetType.IRON));

    public static final RegistryObject<Block> BUNKER_WALL = registerBlock("bunker_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                    .strength(8.5F, 1650.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> BLUE_FENCE = registerBlock("blue_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .strength(1.0F, 15.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BLUE_FENCE_GATE = registerBlock("blue_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .strength(1.0F, 15.0F).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> BLUE_PLANKS = registerBlock("blue_planks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE)
                    .strength(1.0F, 15.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BUNKER_DOOR = registerBlock("bunker_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY)
                    .strength(15.0F, 1650.0F).sound(SoundType.METAL), BlockSetType.IRON));

    public static final RegistryObject<Block> BUNKER_TRAPDOOR = registerBlock("bunker_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .strength(15.0F, 1650.0F).sound(SoundType.METAL), BlockSetType.IRON));

    public static final RegistryObject<LiquidBlock> MOLTEN_QUANTALYTH_BLOCK = BLOCKS.register("molten_quantalyth_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MOLTEN_QUANTALYTH, BlockBehaviour.Properties.copy(Blocks.LAVA).noLootTable()));

    public static final RegistryObject<LiquidBlock> NITRIC_ACID_BLOCK = BLOCKS.register("nitric_acid_block",
            () -> new LiquidBlock(ModFluids.SOURCE_NITRIC_ACID, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<LiquidBlock> NITRATION_BATH_BLOCK = BLOCKS.register("nitration_bath_block",
            () -> new LiquidBlock(ModFluids.SOURCE_NITRATION_BATH, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<LiquidBlock> NITROGLYCERIN_BLOCK = BLOCKS.register("nitroglycerin_block",
            () -> new ExplosiveFluid(ModFluids.SOURCE_NITROGLYCERIN, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<LiquidBlock> GLYCERIN_BLOCK = BLOCKS.register("glycerin_block",
            () -> new ExplosiveFluid(ModFluids.SOURCE_GLYCERIN, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<Block> RAW_QUANTALYTH_BLOCK = registerBlock("raw_quantalyth_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops()
                    .strength(1.0F, 50000.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> QUANTALYTH_BLOCK = registerBlock("quantalyth_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).requiresCorrectToolForDrops()
                    .strength(40.0F, 100000000000.0F).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> COMPRESSED_QUANTALYTH_BLOCK = registerBlock("compressed_quantalyth_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).requiresCorrectToolForDrops()
                    .strength(50.0F, 100000000000000000000000.0F).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> UV_LAMP = registerBlock("uv_lamp",
            () -> new UVLampBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops()
                    .strength(50.0F, 15.0F).sound(SoundType.GLASS).noOcclusion()));

    public static final RegistryObject<Block> NITROGLYCERIN_CAPSULE_BLOCK = BLOCKS.register("nitroglycerin_capsule_block",
            () -> new NitroglycerinCapsuleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .strength(0.01F, 0F).sound(SoundType.GLASS).noOcclusion().noLootTable()));

    public static final RegistryObject<Block> DARK_FLOWER_CROP = BLOCKS.register("dark_flower_crop",
            () -> new DarkFlowerCropBlock(BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> DARK_FLOWER = registerBlock("dark_flower",
            () -> new FlowerBlock(() -> MobEffects.BLINDNESS, 20, BlockBehaviour.Properties.copy(Blocks.ALLIUM)));

    public static final RegistryObject<Block> POTTED_DARK_FLOWER = BLOCKS.register("potted_dark_flower",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), DARK_FLOWER, BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM)));

    

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
