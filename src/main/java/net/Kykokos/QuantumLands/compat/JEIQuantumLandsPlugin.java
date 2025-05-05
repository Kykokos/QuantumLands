package net.Kykokos.QuantumLands.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.recipe.CentrifugeRecipe;
import net.Kykokos.QuantumLands.screen.CentrifugeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIQuantumLandsPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(QuantumLands.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CentrifugeRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<CentrifugeRecipe> centrifugingRecipes = recipeManager.getAllRecipesFor(CentrifugeRecipe.Type.INSTANCE);
        registration.addRecipes(CentrifugeRecipeCategory.CENTRIFUGING_TYPE, centrifugingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CentrifugeScreen.class, 166, 1, 8, 9, CentrifugeRecipeCategory.CENTRIFUGING_TYPE);
    }
}
