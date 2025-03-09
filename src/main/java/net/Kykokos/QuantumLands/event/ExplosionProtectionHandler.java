package net.Kykokos.QuantumLands.event;


import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = QuantumLands.MOD_ID)
public class ExplosionProtectionHandler {

    @SubscribeEvent
    public static void onExplosion(ExplosionEvent.Detonate event) {
        event.getAffectedEntities().removeIf(entity ->
                entity instanceof ItemEntity itemEntity && isExplosionImmune(itemEntity.getItem().getItem()));
    }

    private static boolean isExplosionImmune(Item item) {
        return item == ModItems.QUANTALYTH_INGOT.get();
    }

}
