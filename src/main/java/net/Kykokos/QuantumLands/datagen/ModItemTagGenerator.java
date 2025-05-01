package net.Kykokos.QuantumLands.datagen;

import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

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
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
