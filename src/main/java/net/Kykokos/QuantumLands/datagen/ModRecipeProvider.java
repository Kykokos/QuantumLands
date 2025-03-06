package net.Kykokos.QuantumLands.datagen;

import com.simibubi.create.*;
import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static java.lang.ref.Cleaner.create;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BUKER_DETECTOR.get())
                .pattern("BRB")
                .pattern("BRB")
                .pattern("BOB")
                .define('B', ModBlocks.BUNKER_BLOCK.get())
                .define('R', Blocks.REDSTONE_BLOCK)
                .define('O', AllBlocks.SMART_OBSERVER)
                .unlockedBy("has_bunker_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BUNKER_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUNKER_BLOCK.get())
                .pattern("GGG")
                .pattern("GIG")
                .pattern("GGG")
                .define('I', Items.IRON_BLOCK)
                .define('G', Items.GRAVEL)
                .unlockedBy("has_gravel", inventoryTrigger(ItemPredicate.Builder.item().of(Items.GRAVEL).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUNKER_STAIRS.get(), 4)
                .pattern("  B")
                .pattern(" BB")
                .pattern("BBB")
                .define('B', ModBlocks.BUNKER_BLOCK.get())
                .unlockedBy("has_bunker_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BUNKER_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUNKER_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("BBB")
                .define('B', ModBlocks.BUNKER_BLOCK.get())
                .unlockedBy("has_bunker_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BUNKER_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUNKER_WALL.get(), 6)
                .pattern("   ")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModBlocks.BUNKER_BLOCK.get())
                .unlockedBy("has_bunker_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BUNKER_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.EMERGENCY_BUTTON.get())
                .pattern("   ")
                .pattern(" BR")
                .pattern("   ")
                .define('B', ModBlocks.BUNKER_BLOCK.get())
                .define('R', Items.RED_DYE)
                .unlockedBy("has_bunker_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BUNKER_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.BUNKER_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern(" BB")
                .define('B', ModBlocks.BUNKER_BLOCK.get())
                .unlockedBy("has_bunker_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BUNKER_BLOCK.get()).build()))
                .save(pWriter);



        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.BUNKER_BLOCK.get()), RecipeCategory.MISC, ModBlocks.CRACKED_BUNKER_BLOCK.get())
                .unlockedBy("has_bunker_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BUNKER_BLOCK.get()).build()))
                .save(pWriter);

        //planks recipe here

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_FENCE.get())
                .pattern("   ")
                .pattern("BSB")
                .pattern("BSB")
                .define('B', ModBlocks.BLUE_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_blue_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BLUE_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_FENCE_GATE.get())
                .pattern("   ")
                .pattern("SBS")
                .pattern("SBS")
                .define('B', ModBlocks.BLUE_PLANKS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_blue_planks", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BLUE_PLANKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_QUANTALYTH_BLOCK.get())
                .pattern("QQQ")
                .pattern("QQQ")
                .pattern("QQQ")
                .define('Q', ModItems.QUANTALYTH_CAPSULE.get())
                .unlockedBy("has_quantalyth_capsule", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.QUANTALYTH_CAPSULE.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.QUANTALYTH_BLOCK.get())
                .pattern("QQQ")
                .pattern("QQQ")
                .pattern("QQQ")
                .define('Q', ModItems.QUANTALYTH_INGOT.get())
                .unlockedBy("has_quantalyth_ingot", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.QUANTALYTH_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.QUANTALYTH_MEGA_BLOCK.get())
                .pattern("QQQ")
                .pattern("QQQ")
                .pattern("QQQ")
                .define('Q', ModBlocks.QUANTALYTH_BLOCK.get())
                .unlockedBy("has_quantalyth_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.QUANTALYTH_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.INCOMPLETE_RAW_QUANTALYTH_CHUNK.get())
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .define('N', Items.NETHER_STAR)
                .define('D', Blocks.DIAMOND_BLOCK)
                .unlockedBy("has_nether_star", inventoryTrigger(ItemPredicate.Builder.item().of(Items.NETHER_STAR).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_QUANTALYTH.get())
                .pattern("QQQ")
                .pattern("QQQ")
                .pattern("QQQ")
                .define('Q', ModItems.RAW_QUANTALYTH_CHUNK.get())
                .unlockedBy("has_raw_quantalyth_chunk", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.RAW_QUANTALYTH_CHUNK.get()).build()))
                .save(pWriter);


    }
}
