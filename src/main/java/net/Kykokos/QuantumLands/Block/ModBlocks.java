package net.Kykokos.QuantumLands.Block;

import net.Kykokos.QuantumLands.Block.custom.SoundBlock;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(3.0F, 50.0F)
                    .sound(SoundType.WOOD).requiresCorrectToolForDrops()));



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
