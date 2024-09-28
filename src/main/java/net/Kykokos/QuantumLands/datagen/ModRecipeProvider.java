package net.Kykokos.QuantumLands.datagen;

import com.simibubi.create.*;
import com.simibubi.create.content.kinetics.mixer.MixingRecipe;
import com.simibubi.create.content.logistics.filter.ItemAttribute;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.content.schematics.requirement.ItemRequirement;
import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import com.simibubi.create.foundation.data.recipe.ItemApplicationRecipeGen;
import com.simibubi.create.foundation.data.recipe.MixingRecipeGen;
import com.simibubi.create.foundation.render.CreateContexts;
import com.simibubi.create.infrastructure.gametest.CreateGameTests;
import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static java.lang.ref.Cleaner.create;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{

    public ModRecipeProvider(PackOutput pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SNIFFERITE.get())
                .pattern("   ")
                .pattern(" AA")
                .pattern(" AA")
                .define('A', ModItems.SNIFFERITE_DUST.get())
                .unlockedBy("has_snifferite", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.SNIFFERITE.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SNIFFERITE_DUST.get(), 4)
                .requires(ModItems.SNIFFERITE.get())
                .unlockedBy("has_snifferite", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.SNIFFERITE.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BUKER_DETECTOR.get())
                .pattern("BRB")
                .pattern("BRB")
                .pattern("BOB")
                .define('B', ModBlocks.BUNKER_BLOCK.get())
                .define('R', Blocks.REDSTONE_BLOCK)
                .define('O', AllBlocks.SMART_OBSERVER)
                .unlockedBy("has_bunker_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BUNKER_BLOCK.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PEAT_BRICK.get())
                .pattern("   ")
                .pattern(" MK")
                .pattern("   ")
                .define('M', Items.DRIED_KELP)
                .define('K', Blocks.MUD)
                .unlockedBy("has_mud", inventoryTrigger(ItemPredicate.Builder.item().of(Blocks.MUD).build()))
                .unlockedBy("has_kelp", inventoryTrigger(ItemPredicate.Builder.item().of(Items.DRIED_KELP).build()))
                .save(pWriter);
    }
}
