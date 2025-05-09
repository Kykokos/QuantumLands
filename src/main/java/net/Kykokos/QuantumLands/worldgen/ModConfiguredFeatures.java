package net.Kykokos.QuantumLands.worldgen;

import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_KEY = registerKey("blue");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SNIFFERITE_ORE_KEY = registerKey("snifferite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_FLOWER_KEY = registerKey("dark_flower");



    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldSnifferiteOres = List.of(OreConfiguration.target(stoneReplaceabeles, ModBlocks.SNIFFERITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_SNIFFERITE_ORE.get().defaultBlockState()));

        register(context, BLUE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BLUE_LOG.get()),
                new StraightTrunkPlacer(4, 3, 2),
                BlockStateProvider.simple(ModBlocks.BLUE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, OVERWORLD_SNIFFERITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSnifferiteOres, 2));//vein size

        register(context, DARK_FLOWER_KEY, Feature.FLOWER, new RandomPatchConfiguration(32, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DARK_FLOWER.get())))));
    }



    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(QuantumLands.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
