package net.Kykokos.QuantumLands.datagen;

import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider
{


    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, QuantumLands.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Add Item Tags here
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.QUANTALYTH_HELMET.get())
                .add(ModItems.QUANTALYTH_CHESTPLATE.get())
                .add(ModItems.QUANTALYTH_LEGGINGS.get())
                .add(ModItems.QUANTALYTH_BOOTS.get());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.CHEMISTRY_THEME_RECORD.get());


        /*TagKey<Item> ALL_ITEMS_TAG = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "essence_crafting"));
        Set<Item> excludedItems = Set.of(Items.AIR,
                ModItems.BLACKOUT_POWDER.get(),
                ModBlocks.BLUE_PLANKS.get().asItem(),
                ModBlocks.BLUE_FENCE.get().asItem(),
                ModBlocks.BLUE_FENCE_GATE.get().asItem(),
                ModBlocks.WET_IRON_BLOCK.get().asItem(),
                ModBlocks.BLUE_WOOD.get().asItem(),
                ModBlocks.BLUE_LOG.get().asItem(),
                ModBlocks.STRIPPED_BLUE_WOOD.get().asItem(),
                ModBlocks.STRIPPED_BLUE_LOG.get().asItem(),
                ModBlocks.BLUE_SAPLING.get().asItem(),
                ModBlocks.BLUE_LEAVES.get().asItem(),
                Items.WET_SPONGE);
        for (Item item : BuiltInRegistries.ITEM) {
            if (!excludedItems.contains(item)) {
                this.tag(ALL_ITEMS_TAG).add(item);
            }
        }*/

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BLUE_LOG.get().asItem())
                .add(ModBlocks.BLUE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BLUE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BLUE_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.BLUE_PLANKS.get().asItem());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
