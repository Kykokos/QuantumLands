package net.Kykokos.QuantumLands.Block;

import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.antlr.v4.parse.BlockSetTransformer;

import java.util.function.Supplier;

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

    public static final RegistryObject<Block> EMERGENCY_BUTTON= registerBlock("emergency_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)
                    .strength(0.5F, 1650.0F).sound(SoundType.METAL), BlockSetType.IRON, 2, false));

    public static final RegistryObject<Block> BUNKER_PRESSURE_PLATE = registerBlock("bunker_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                    .strength(8.5F, 1650.0F).sound(SoundType.METAL), BlockSetType.IRON));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

}
