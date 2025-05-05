package net.Kykokos.QuantumLands.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.recipe.CentrifugeRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CentrifugeRecipeCategory implements IRecipeCategory<CentrifugeRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(QuantumLands.MOD_ID, "centrifuging");
    public static final ResourceLocation TEXTURE = new ResourceLocation(QuantumLands.MOD_ID, "textures/gui/jei/centrifuge_gui.png");

    public static final RecipeType<CentrifugeRecipe> CENTRIFUGING_TYPE =
            new RecipeType<>(UID, CentrifugeRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CentrifugeRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 96);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CENTRIFUGE.get()));
    }


    @Override
    public RecipeType<CentrifugeRecipe> getRecipeType() {
        return CENTRIFUGING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("jei.quantum_lands.centrifuge_title");
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CentrifugeRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 30, 33).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 20).addItemStack(recipe.getOutput1());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 46).addItemStack(recipe.getOutput2());
    }
}
