package net.Kykokos.QuantumLands.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.Item.custom.HammerItem;
import net.Kykokos.QuantumLands.QuantumLands;
import net.Kykokos.QuantumLands.enchantment.ModEnchantments;
import net.Kykokos.QuantumLands.villager.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Mod.EventBusSubscriber(modid = QuantumLands.MOD_ID)
public class ModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event)
    {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initalBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initalBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer)) {
                if (pos == initalBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // Have to add them to a Set otherwise, the same code right here will get called for each block!
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType() == ModVillagers.CHEMIST.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, Random) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32), new ItemStack(ModItems.HEISENBERG_SHIRT.get()), 1, 10, 0.02f
            ));
            trades.get(1).add((pTrader, Random) -> new MerchantOffer(
                    new ItemStack(ModItems.NITROGLYCERIN_BUCKET.get()), new ItemStack(Items.EMERALD, 10), 15, 3, 0.02f
            ));
            trades.get(1).add((pTrader, Random) -> new MerchantOffer(
                    new ItemStack(ModItems.NITRATION_BATH_BUCKET.get()), new ItemStack(Items.EMERALD, 6), 15, 2, 0.02f
            ));
            trades.get(1).add((pTrader, Random) -> new MerchantOffer(
                    new ItemStack(ModItems.SNIFFERITE.get()), new ItemStack(Items.EMERALD, 16), 10, 10, 0.02f
            ));
            trades.get(2).add((pTrader, Random) -> new MerchantOffer(
                    new ItemStack(ModItems.SIMPLE_BATTERY.get()), new ItemStack(Items.EMERALD, 1), 24, 2, 0.02f
            ));
            trades.get(2).add((pTrader, Random) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 16), new ItemStack(ModItems.CHEMISTRY_THEME_RECORD.get()), 2, 10, 0.03f
            ));
            trades.get(3).add((pTrader, Random) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 16), EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ModEnchantments.NITRATED_WARRIOR.get(), 1)), 6, 10, 0.03f
            ));
            trades.get(4).add((pTrader, Random) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 52), new ItemStack(ModItems.DARK_FLOWER_SEEDS.get()), 1, 15, 0.03f
            ));
            trades.get(4).add((pTrader, Random) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 64), new ItemStack(ModBlocks.BLUE_SAPLING.get()), 1, 20, 0.04f
            ));
        }
    }


    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event){

        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();

        rareTrades.add((pTrader, Random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 48), new ItemStack(ModItems.HEISENBERG_SHIRT.get()), 1, 10, 0.03f
        ));
        genericTrades.add((pTrader, Random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 32), new ItemStack(ModItems.DARK_FLOWER_SEEDS.get()), 4, 2, 0.02f
        ));
        genericTrades.add((pTrader, Random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 48), new ItemStack(ModBlocks.BLUE_SAPLING.get()), 1, 5, 0.03f
        ));

    }
}
