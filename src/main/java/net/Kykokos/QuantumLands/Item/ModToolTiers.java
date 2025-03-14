package net.Kykokos.QuantumLands.Item;

import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier QUANTALYTH = TierSortingRegistry.registerTier(
            new ForgeTier(10,-1,25f, 8f, 26,
                    ModTags.Blocks.NEEDS_QUANTALYTH_TOOL, () -> Ingredient.of(ModItems.QUANTALYTH_INGOT.get())),
            new ResourceLocation(QuantumLands.MOD_ID, "quantalyth"), List.of(Tiers.NETHERITE), List.of());

}

