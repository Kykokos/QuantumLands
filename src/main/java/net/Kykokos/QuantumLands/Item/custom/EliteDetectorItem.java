package net.Kykokos.QuantumLands.Item.custom;

import net.Kykokos.QuantumLands.Item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;


public class EliteDetectorItem extends Item{




    public EliteDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack detector = player.getItemInHand(hand);

        if (!world.isClientSide && player.isShiftKeyDown()) {
            ItemStack tablet = player.getOffhandItem(); // Tablet musí být v offhandu

            if (tablet.getItem() == ModItems.DETECTOR_DATA_TABLET.get() && tablet.hasTag()) {
                CompoundTag tabletTag = tablet.getTag();

                detector.setTag(tabletTag.copy());

                tablet.setTag(null);

                detector.getOrCreateTag().putBoolean("HasData", true);

                player.displayClientMessage(Component.translatable("item.quantum_lands.elite_detector.data_transfer_success"), true);
                return InteractionResultHolder.success(detector);
            } else {
                player.displayClientMessage(Component.translatable("item.quantum_lands.elite_detector.no_offhand"), true);
            }

            if (tablet.hasTag() && tablet.getTag().contains("StoredBlocks")) {
                detector.getTag().put("DetectedBlocks", tablet.getTag().get("StoredBlocks"));
            }
        }


        return InteractionResultHolder.pass(detector);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        ItemStack detector = context.getItemInHand();

        if (world.isClientSide || player == null) {
            return InteractionResult.SUCCESS;
        }


        if (!detector.hasTag() || !detector.getTag().contains("values")) {
            if (player != null) {
                player.displayClientMessage(Component.translatable("item.quantum_lands.elite_detector.no_data"), true);
            }
            return InteractionResult.FAIL;
        }


        ListTag valuesList = detector.getTag().getList("values", Tag.TAG_STRING);
        Set<String> savedBlocks = new HashSet<>();
        for (int i = 0; i < valuesList.size(); i++) {
            savedBlocks.add(valuesList.getString(i));
        }


        for (int i = 0; i < 64; i++) {
            BlockPos checkPos = pos.below(i);
            BlockState state = world.getBlockState(checkPos);
            ResourceLocation blockID = ForgeRegistries.BLOCKS.getKey(state.getBlock());

            if (blockID != null && savedBlocks.contains(blockID.toString())) {
                Component foundMessage = Component.literal("§aBlock Found: ")
                        .append(state.getBlock().getName().copy().withStyle(ChatFormatting.YELLOW))
                        .append(" at ")
                        .append(Component.literal("(" + checkPos.getX() + ", " + checkPos.getY() + ", " + checkPos.getZ() + ")")
                                .withStyle(ChatFormatting.GOLD));
                player.sendSystemMessage(foundMessage);
                return InteractionResult.SUCCESS;
            }
        }

        if (player != null) {
            player.displayClientMessage(Component.translatable("item.quantum_lands.elite_detector.no_blocks"), true);
        }

        return InteractionResult.FAIL;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.hasTag() && stack.getTag().getBoolean("HasData");
    }

}