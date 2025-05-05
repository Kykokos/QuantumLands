package net.Kykokos.QuantumLands.util;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class InventoryDirectionWrapper {
    public Map<Direction, LazyOptional<WrappedHandler>> directionsMap;

    /*public InventoryDirectionWrapper(IItemHandlerModifiable handler, InventoryDirectionEntry... entries) {
        directionsMap = new HashMap<>();
        for (var x : entries) {
            directionsMap.put(x.direction,
                    LazyOptional.of(() -> new WrappedHandler(handler, (i) -> Objects.equals(i, x.slotIndex), (i, s) -> x.canInsert)));
        }
    }*/

    public InventoryDirectionWrapper(IItemHandlerModifiable handler, InventoryDirectionEntry... entries) {
        directionsMap = new HashMap<>();

        Map<Direction, List<InventoryDirectionEntry>> grouped = new HashMap<>();
        for (InventoryDirectionEntry entry : entries) {
            grouped.computeIfAbsent(entry.direction, d -> new ArrayList<>()).add(entry);
        }

        for (var entry : grouped.entrySet()) {
            Direction dir = entry.getKey();
            List<InventoryDirectionEntry> dirEntries = entry.getValue();

            Predicate<Integer> extractPredicate = (slot) ->
                    dirEntries.stream().anyMatch(e -> e.slotIndex == slot && !e.canInsert);

            BiPredicate<Integer, ItemStack> insertPredicate = (slot, stack) ->
                    dirEntries.stream().anyMatch(e -> e.slotIndex == slot && e.canInsert);

            directionsMap.put(dir, LazyOptional.of(() -> new WrappedHandler(handler, extractPredicate, insertPredicate)));
        }
    }
}
