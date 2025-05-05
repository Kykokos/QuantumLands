package net.Kykokos.QuantumLands.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class CentrifugeRecipe implements Recipe<SimpleContainer> {

    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output1;
    private final ItemStack output2;
    private final ResourceLocation id;

    public CentrifugeRecipe(ItemStack output1, ItemStack output2, ResourceLocation id, NonNullList<Ingredient> inputItems) {
        this.inputItems = inputItems;
        this.output1 = output1;
        this.output2 = output2;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level level) {
        if (level.isClientSide())
        {
            return false;
        }

        return inputItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer simpleContainer, RegistryAccess registryAccess) {
        return output1.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output1.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public ItemStack getOutput1() {
        return output1;
    }

    public ItemStack getOutput2() {
        return output2;
    }

    public static class Type implements RecipeType<CentrifugeRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "centrifuging";
    }

    public static class Serializer implements RecipeSerializer<CentrifugeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(QuantumLands.MOD_ID,"centrifuging");

        @Override
        public CentrifugeRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output1 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output1"));
            ItemStack output2 = ItemStack.EMPTY;

            if (json.has("output2")) {
                output2 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output2"));
            }

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CentrifugeRecipe(output1, output2, id, inputs);
        }

        @Override
        public CentrifugeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output1 = buf.readItem();
            ItemStack output2 = buf.readItem();

            return new CentrifugeRecipe(output1, output2.isEmpty() ? ItemStack.EMPTY : output2, id, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CentrifugeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(null), false);

            if (!recipe.output2.isEmpty()) {
                buf.writeItemStack(recipe.output2, false);
            } else {
                buf.writeItemStack(ItemStack.EMPTY, false);
            }
        }
    }
}

