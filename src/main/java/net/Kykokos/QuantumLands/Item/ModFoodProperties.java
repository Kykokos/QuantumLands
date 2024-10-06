package net.Kykokos.QuantumLands.Item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties
{
    public  static final FoodProperties BLACKOUT_POWDER = new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 150), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 750 ), 0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 320 ), 1f).build();

    public  static final FoodProperties SNIFFERITE_DUST = new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 750 ), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 320 ), 1f).build();

}
