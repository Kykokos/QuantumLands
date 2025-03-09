package net.Kykokos.QuantumLands.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;

public class NitratedWarriorEnchantment extends Enchantment {

    protected NitratedWarriorEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        super.doPostAttack(pAttacker, pTarget, pLevel);

        if (!pAttacker.level().isClientSide) {
            ServerLevel level = ((ServerLevel) pAttacker.level());
            BlockPos position = pTarget.blockPosition();

            if (pLevel == 1)
            {
                level.explode(pAttacker, pTarget.getX(), pTarget.getY(), pTarget.getZ(), 1.0F, Level.ExplosionInteraction.NONE);
            }

            if (pLevel == 2)
            {
                level.explode(pAttacker, pTarget.getX(), pTarget.getY(), pTarget.getZ(), 2.0F, Level.ExplosionInteraction.NONE);
            }

            if (pLevel == 3)
            {
                level.explode(pAttacker, pTarget.getX(), pTarget.getY(), pTarget.getZ(), 3.0F, Level.ExplosionInteraction.NONE);
            }

            if (pLevel == 4)
            {
                level.explode(pAttacker, pTarget.getX(), pTarget.getY(), pTarget.getZ(), 2.0F, Level.ExplosionInteraction.BLOCK);
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player)null, position, MobSpawnType.TRIGGERED, true, true);
            }

            if (pLevel == 5)
            {
                level.explode(pAttacker, pTarget.getX(), pTarget.getY(), pTarget.getZ(), 3.0F, Level.ExplosionInteraction.BLOCK);
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player)null, position, MobSpawnType.TRIGGERED, true, true);
            }

        }

    }

    @Override
    public int getMaxLevel()
    {
        return 5;
    }
}
