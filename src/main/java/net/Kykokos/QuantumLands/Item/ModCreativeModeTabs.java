package net.Kykokos.QuantumLands.Item;

import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QuantumLands.MOD_ID);


    public static final RegistryObject<CreativeModeTab> SNIFFS_AND_LABS_TAB = CREATIVE_MODE_TABS.register("sniffs_and_labs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SNIFFERITE_DUST.get()))
                    .title(Component.translatable("creativetab.sniffs_and_labs_tab")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SNIFFERITE.get());
                        output.accept(ModItems.SNIFFERITE_DUST.get());
                        output.accept(ModItems.DARK_FLOWER_SEEDS.get());
                        output.accept(ModItems.DARK_FLOWER_BLOOM.get());
                        output.accept(ModItems.BLACKOUT_POWDER.get());
                        output.accept(ModItems.DARKNESS_SHARD.get());
                        output.accept(ModItems.DARK_MATTER.get());
                        output.accept(ModItems.RUST_DUST.get());
                        output.accept(ModBlocks.WET_IRON_BLOCK.get());
                        output.accept(ModBlocks.LITTLE_RUSTED_IRON_BLOCK.get());
                        output.accept(ModBlocks.RUSTED_IRON_BLOCK.get());
                        output.accept(ModBlocks.FULLY_RUSTED_IRON_BLOCK.get());
                        output.accept(ModItems.POTASSIUM_NITRATE.get());
                        output.accept(ModItems.NITRIC_ACID_BUCKET.get());
                        output.accept(ModItems.GLYCERIN_BUCKET.get());
                        output.accept(ModItems.NITRATION_BATH_BUCKET.get());
                        output.accept(ModItems.NITROGLYCERIN_BUCKET.get());
                        output.accept(ModItems.NITROGLYCERIN_CAPSULE.get());
                        output.accept(ModBlocks.NITRATED_WOOL.get());
                        output.accept(ModItems.HEISENBERG_SHIRT.get());
                        output.accept(ModItems.CHEMISTRY_THEME_RECORD.get());
                        output.accept(ModItems.BLUE_SUBSTANCE.get());
                        output.accept(ModItems.EMPTY_CAPSULE.get());
                        output.accept(ModItems.BUNKER_DETECTOR.get());
                        output.accept(ModItems.ELITE_DETECTOR.get());
                        output.accept(ModItems.DETECTOR_DATA_TABLET.get());
                        output.accept(ModItems.PEAT_BRICK.get());
                        output.accept(ModItems.ESSENCE_TIER_1.get());
                        output.accept(ModItems.ESSENCE_TIER_2.get());
                        output.accept(ModItems.ESSENCE_TIER_3.get());
                        output.accept(ModItems.ESSENCE_TIER_4.get());
                        output.accept(ModItems.ESSENCE_TIER_5.get());
                        output.accept(ModItems.ESSENCE_TIER_6.get());
                        output.accept(ModItems.ESSENCE_TIER_7.get());
                        output.accept(ModItems.ESSENCE_TIER_8.get());
                        output.accept(ModItems.SUPER_SINGULARITY.get());
                        output.accept(ModItems.INCOMPLETE_CREATIVE_BLAZE_CAKE.get());
                        output.accept(ModItems.CENTRIFUGE_ITEM.get());
                        output.accept(ModItems.SIMPLE_BATTERY.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> QUANTUM_BUILDING_TAB = CREATIVE_MODE_TABS.register("quantum_building_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRACKED_BUNKER_BLOCK.get()))
                    .title(Component.translatable("creativetab.quantum_building_tab")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BUNKER_BLOCK.get());
                        output.accept(ModBlocks.CRACKED_BUNKER_BLOCK.get());
                        output.accept(ModBlocks.BUNKER_STAIRS.get());
                        output.accept(ModBlocks.BUNKER_SLAB.get());
                        output.accept(ModBlocks.BUNKER_WALL.get());
                        output.accept(ModBlocks.BUNKER_DOOR.get());
                        output.accept(ModBlocks.BUNKER_TRAPDOOR.get());
                        output.accept(ModBlocks.BUNKER_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.EMERGENCY_BUTTON.get());
                        output.accept(ModBlocks.UV_LAMP.get());
                        output.accept(ModBlocks.BLUE_SAPLING.get());
                        output.accept(ModBlocks.BLUE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_BLUE_LOG.get());
                        output.accept(ModBlocks.BLUE_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_BLUE_WOOD.get());
                        output.accept(ModBlocks.BLUE_PLANKS.get());
                        output.accept(ModBlocks.BLUE_FENCE.get());
                        output.accept(ModBlocks.BLUE_FENCE_GATE.get());
                        output.accept(ModBlocks.BLUE_LEAVES.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> QUANTALYTH_TAB = CREATIVE_MODE_TABS.register("quantalyth_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.QUANTALYTH_INGOT.get()))
                    .title(Component.translatable("creativetab.quantalyth_tab")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.INCOMPLETE_RAW_QUANTALYTH_CHUNK.get());
                        output.accept(ModItems.RAW_QUANTALYTH_CHUNK.get());
                        output.accept(ModItems.RAW_QUANTALYTH.get());
                        output.accept(ModItems.MOLTEN_QUANTALYTH_BUCKET.get());
                        output.accept(ModItems.QUANTALYTH_CAPSULE.get());
                        output.accept(ModBlocks.RAW_QUANTALYTH_BLOCK.get());
                        output.accept(ModItems.QUANTALYTH_INGOT.get());
                        output.accept(ModBlocks.QUANTALYTH_BLOCK.get());
                        output.accept(ModBlocks.COMPRESSED_QUANTALYTH_BLOCK.get());
                        output.accept(ModItems.QUANTALYTH_PICKAXE.get());
                        output.accept(ModItems.QUANTALYTH_AXE.get());
                        output.accept(ModItems.QUANTALYTH_SHOVEL.get());
                        output.accept(ModItems.QUANTALYTH_HOE.get());
                        output.accept(ModItems.QUANTALYTH_SWORD.get());
                        output.accept(ModItems.QUANTALYTH_PAXEL.get());
                        output.accept(ModItems.QUANTALYTH_HAMMER.get());
                        output.accept(ModItems.QUANTALYTH_HELMET.get());
                        output.accept(ModItems.QUANTALYTH_CHESTPLATE.get());
                        output.accept(ModItems.QUANTALYTH_LEGGINGS.get());
                        output.accept(ModItems.QUANTALYTH_BOOTS.get());


                    }).build());



    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
