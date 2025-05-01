package net.Kykokos.QuantumLands.datagen;

import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, QuantumLands.MOD_ID);
    }

    @Override
    protected void start() {
       /* add("blackout_powder_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build() }, ModItems.BLACKOUT_POWDER.get()));*/

        add("dark_flower_seeds_from_ancient_cities", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city_ice_box")).build() }, ModItems.DARK_FLOWER_SEEDS.get()));

        add("dark_flower_seeds_from_ancient_cities", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city_ice_box")).build() }, ModItems.DARK_FLOWER_SEEDS.get()));

        //entities are the same as chests
    }
}
