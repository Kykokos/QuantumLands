package net.Kykokos.QuantumLands;

import com.mojang.logging.LogUtils;
import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.Block.entity.ModBlockEntities;
import net.Kykokos.QuantumLands.Block.entity.client.CentrifugeBlockRenderer;
import net.Kykokos.QuantumLands.Item.ModCreativeModeTabs;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.enchantment.ModEnchantments;
import net.Kykokos.QuantumLands.event.ExplosionProtectionHandler;
import net.Kykokos.QuantumLands.fluid.ModFluidTypes;
import net.Kykokos.QuantumLands.fluid.ModFluids;
import net.Kykokos.QuantumLands.loot.ModLootModifiers;
import net.Kykokos.QuantumLands.painting.ModPaintings;
import net.Kykokos.QuantumLands.particle.ModParticles;
import net.Kykokos.QuantumLands.screen.ModMenuTypes;
import net.Kykokos.QuantumLands.sound.ModSounds;
import net.Kykokos.QuantumLands.villager.ModVillagers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(QuantumLands.MOD_ID)
public class QuantumLands
{
    public static final String MOD_ID = "quantum_lands";

    public static final Logger LOGGER = LogUtils.getLogger();

    public QuantumLands() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        ModCreativeModeTabs.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEnchantments.register(modEventBus);
        ModSounds.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModPaintings.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModParticles.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        GeckoLib.initialize();

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);


        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(ExplosionProtectionHandler.class);
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.DARK_FLOWER_BLOOM.get(), 0.7f);
            ComposterBlock.COMPOSTABLES.put(ModItems.DARK_FLOWER_SEEDS.get(), 0.6f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.DARK_FLOWER.getId(), ModBlocks.POTTED_DARK_FLOWER);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.PEAT_BRICK);
            event.accept(ModItems.POTASSIUM_NITRATE);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(ModBlocks.BUNKER_BLOCK);
            event.accept(ModBlocks.CRACKED_BUNKER_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            event.accept(ModBlocks.SNIFFERITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_SNIFFERITE_ORE);
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS)
        {
            event.accept(ModBlocks.EMERGENCY_BUTTON);
            event.accept(ModItems.CENTRIFUGE_ITEM);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_NITRIC_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_NITRIC_ACID.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_NITRATION_BATH.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_NITRATION_BATH.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_NITROGLYCERIN.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_NITROGLYCERIN.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_GLYCERIN.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_GLYCERIN.get(), RenderType.translucent());

            BlockEntityRenderers.register(ModBlockEntities.CENTRIFUGE_ENTITY.get(), CentrifugeBlockRenderer::new);

        }
    }
}
