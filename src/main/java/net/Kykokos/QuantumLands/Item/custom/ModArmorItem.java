package net.Kykokos.QuantumLands.Item.custom;

import com.google.common.collect.ImmutableMap;
import net.Kykokos.QuantumLands.Item.ModArmorMaterials;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.QUANTALYTH, List.of(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 1),
                            new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 1)))
                    .build();

    public ModArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide()) {

            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }

            if (hasChestplateOn(player) && getMaterial() == ModArmorMaterials.HEISENBERG) {
                removeNegativeEffects(player);
            }

        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if (getMaterial() == ModArmorMaterials.HEISENBERG)
        {
            if(Screen.hasShiftDown())
            {
                pTooltipComponents.add(Component.translatable("tooltip.quantum_lands.heisenberg_shirt.tooltip.shift"));
            } else
            {
                pTooltipComponents.add(Component.translatable("tooltip.quantum_lands.heisenberg_shirt.tooltip"));
            }
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void removeNegativeEffects(Player player) {
        List<MobEffectInstance> negativeEffects = player.getActiveEffects().stream()
                .filter(effect -> isNegativeEffect(effect.getEffect()))
                .toList();

        for (MobEffectInstance effect : negativeEffects) {
            player.removeEffect(effect.getEffect());
        }
    }

    private boolean isNegativeEffect(MobEffect effect) {
        return effect == MobEffects.POISON ||
                effect  == MobEffects.WEAKNESS ||
                effect == MobEffects.BLINDNESS ||
                effect == MobEffects.WITHER ||
                effect == MobEffects.MOVEMENT_SLOWDOWN ||
                effect == MobEffects.HUNGER ||
                effect == MobEffects.UNLUCK;
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<ArmorMaterial, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn(mapArmorMaterial, player)) {
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(ArmorMaterial mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }

    private boolean hasChestplateOn(Player player) {
        ItemStack chestplate = player.getInventory().getArmor(2);

        return !chestplate.isEmpty();
    }
}
