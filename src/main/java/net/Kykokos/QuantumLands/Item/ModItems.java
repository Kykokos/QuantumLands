package net.Kykokos.QuantumLands.Item;

import net.Kykokos.QuantumLands.Item.custom.BunkerDetectorItem;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, QuantumLands.MOD_ID);


    public static final RegistryObject<Item> SNIFFERITE = ITEMS.register("snifferite",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SNIFFERITE_DUST = ITEMS.register("snifferite_dust",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> BUKER_DETECTOR = ITEMS.register("bunker_detector",
            () -> new BunkerDetectorItem(new Item.Properties().fireResistant().durability(100).rarity(Rarity.EPIC)));


        public static void register(IEventBus eventBus)
        {
            ITEMS.register(eventBus);
        }
}
