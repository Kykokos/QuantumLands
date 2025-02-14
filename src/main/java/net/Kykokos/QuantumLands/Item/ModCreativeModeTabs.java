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
                        output.accept(ModItems.BLACKOUT_POWDER.get());
                        output.accept(ModItems.BLUE_SUBSTANCE.get());
                        output.accept(ModItems.RAW_QUANTALYTH.get());
                        output.accept(ModItems.MOLTEN_QUANTALYTH_BUCKET.get());
                        output.accept(ModItems.EMPTY_CAPSULE.get());
                        output.accept(ModItems.QUANTALYTH_CAPSULE.get());
                        output.accept(ModBlocks.RAW_QUANTALYTH_BLOCK.get());
                        output.accept(ModItems.QUANTALYTH_INGOT.get());
                        output.accept(ModBlocks.QUANTALYTH_BLOCK.get());
                        output.accept(ModItems.BUKER_DETECTOR.get());
                        output.accept(ModItems.PEAT_BRICK.get());
                        output.accept(ModItems.ESSENCE_TIER_1.get());
                        output.accept(ModItems.ESSENCE_TIER_2.get());
                        output.accept(ModItems.ESSENCE_TIER_3.get());
                        output.accept(ModItems.ESSENCE_TIER_4.get());
                        output.accept(ModItems.ESSENCE_TIER_5.get());
                        output.accept(ModItems.ESSENCE_TIER_6.get());
                        output.accept(ModItems.ESSENCE_TIER_7.get());
                        output.accept(ModItems.ESSENCE_TIER_8.get());

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
                        output.accept(ModBlocks.EMERGENCY_BUTTON.get());
                        output.accept(ModBlocks.BUNKER_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.SNIFFERITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get());
                        output.accept(ModBlocks.BLUE_PLANKS.get());
                        output.accept(ModBlocks.BLUE_FENCE.get());
                        output.accept(ModBlocks.BLUE_FENCE_GATE.get());
                    }).build());



    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
