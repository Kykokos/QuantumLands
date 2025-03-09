package net.Kykokos.QuantumLands.enchantment;

import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, QuantumLands.MOD_ID);

    public static final RegistryObject<Enchantment> NITRATED_WARRIOR =
            ENCHANTMENTS.register("nitrated_warrior",
                    () -> new NitratedWarriorEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON,
                            EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus)
    {
        ENCHANTMENTS.register(eventBus);
    }
}
