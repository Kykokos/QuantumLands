package net.Kykokos.QuantumLands.Item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class DetectorDataTabletItem extends Item {

    public DetectorDataTabletItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide()) {
            ItemStack stack = context.getItemInHand();
            BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
            ResourceLocation blockID = ForgeRegistries.BLOCKS.getKey(blockState.getBlock());

            if (blockID != null) {
                CompoundTag tag = stack.getOrCreateTag();

                ListTag valuesList = tag.getList("values", Tag.TAG_STRING);

                String blockName = blockID.toString();
                if (!valuesList.contains(StringTag.valueOf(blockName))) {
                    valuesList.add(StringTag.valueOf(blockName));
                }

                tag.put("values", valuesList);
                stack.setTag(tag);

                context.getPlayer().sendSystemMessage(Component.literal("Block added: " + blockName));
            } else {
                context.getPlayer().displayClientMessage(Component.translatable("item.quantum_lands.detector_data_tablet.error"), true);
            }
        }
        return InteractionResult.SUCCESS;
    }


    @Override
    public boolean isFoil(ItemStack stack) {
        if (stack.hasTag() && stack.getTag().contains("values")) {
            ListTag valuesList = stack.getTag().getList("values", Tag.TAG_STRING);
            return !valuesList.isEmpty();
        }
        return false;
    }
}
