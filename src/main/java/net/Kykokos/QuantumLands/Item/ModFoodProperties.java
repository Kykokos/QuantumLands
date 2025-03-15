package net.Kykokos.QuantumLands.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties
{
    public  static final FoodProperties BLACKOUT_POWDER = new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DARKNESS, 200, 50), 0.8f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200, 50), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 750, 3), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 320, 5), 0.1f).build();

    public  static final FoodProperties SNIFFERITE_DUST = new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 1000, 1000), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 750, 5), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 320,10), 1f).build();

}
