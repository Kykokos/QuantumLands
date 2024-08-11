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
                    }).build());

    public static final RegistryObject<CreativeModeTab> QUANTUM_BUILDING_TAB = CREATIVE_MODE_TABS.register("quantum_building_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRACKED_BUNKER_BLOCK.get()))
                    .title(Component.translatable("creativetab.quantum_building_tab")).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BUNKER_BLOCK.get());
                        output.accept(ModBlocks.CRACKED_BUNKER_BLOCK.get());
                    }).build());



    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
