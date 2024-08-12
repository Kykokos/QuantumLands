package net.Kykokos.QuantumLands.Item.custom;

import com.mojang.authlib.minecraft.TelemetrySession;
import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Interaction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BunkerDetectorItem extends Item
{

    public BunkerDetectorItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext)
    {
        if(!pContext.getLevel().isClientSide())
        {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++)
            {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isBunkerBlock(blockState))
                {
                    outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    break;
                }
            }


            if(!foundBlock)
            {
                outputNoValuableFound(player);
            }


        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if(Screen.hasShiftDown())
        {
            pTooltipComponents.add(Component.translatable("tooltip.quantum_lands.bunker_detector.tooltip.shift"));
        } else
        {
            pTooltipComponents.add(Component.translatable("tooltip.quantum_lands.bunker_detector.tooltip"));
        }


        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputNoValuableFound(Player player)
    {
        player.sendSystemMessage(Component.translatable("item.quantum_lands.bunker_detector.no_bunkers"));

    }


    private void outputValuableCoordinates(BlockPos below, Player player, Block block)
    {
        player.sendSystemMessage(Component.literal("Bunker Found: " + I18n.get(block.getDescriptionId())
                + " at (" + below.getX() + ", " + below.getY() + ", " + below.getZ() + ")"));
    }

    private boolean isBunkerBlock(BlockState blockState)
    {
        return  blockState.is(Blocks.CHEST) || blockState.is(Blocks.BARREL) || blockState.is(Blocks.SHULKER_BOX) || blockState.is(ModBlocks.BUNKER_BLOCK.get())
                || blockState.is(Blocks.GRAY_CONCRETE) || blockState.is(Blocks.BRICKS) || blockState.is(Blocks.PACKED_MUD) || blockState.is(Blocks.SMOOTH_STONE)
                || blockState.is(Blocks.MUD_BRICKS) || blockState.is(Blocks.CYAN_CONCRETE) || blockState.is(Blocks.BLACK_CONCRETE) || blockState.is(Blocks.BLUE_CONCRETE)
                || blockState.is(Blocks.BROWN_CONCRETE) || blockState.is(Blocks.GREEN_CONCRETE) || blockState.is(Blocks.LIGHT_BLUE_CONCRETE) || blockState.is(Blocks.LIGHT_GRAY_CONCRETE)
                || blockState.is(Blocks.LIME_CONCRETE) || blockState.is(Blocks.MAGENTA_CONCRETE) || blockState.is(Blocks.PINK_CONCRETE) || blockState.is(Blocks.RED_CONCRETE)
                || blockState.is(Blocks.ORANGE_CONCRETE) || blockState.is(Blocks.PURPLE_CONCRETE) || blockState.is(Blocks.WHITE_CONCRETE) || blockState.is(Blocks.YELLOW_CONCRETE)
                || blockState.is(Blocks.SMOOTH_STONE_SLAB) || blockState.is(Blocks.QUARTZ_BLOCK) || blockState.is(Blocks.SMOOTH_QUARTZ) || blockState.is(Blocks.STONE_BRICKS)
                || blockState.is(Blocks.STONE_BRICK_SLAB)|| blockState.is(Blocks.CRACKED_STONE_BRICKS) || blockState.is(Blocks.STONE_BRICKS) || blockState.is(Blocks.DEEPSLATE_BRICKS)
                || blockState.is(Blocks.DEEPSLATE_BRICK_SLAB) || blockState.is(Blocks.REDSTONE_BLOCK) || blockState.is(Blocks.COMPARATOR) || blockState.is(Blocks.REPEATER)
                || blockState.is(Blocks.PISTON) || blockState.is(Blocks.STICKY_PISTON) || blockState.is(Blocks.SLIME_BLOCK) || blockState.is(Blocks.HONEY_BLOCK)
                || blockState.is(Blocks.OBSERVER) || blockState.is(Blocks.IRON_BLOCK) || blockState.is(Blocks.REDSTONE_LAMP) || blockState.is(Blocks.FURNACE) || blockState.is(Blocks.BLAST_FURNACE)
                || blockState.is(Blocks.SMOKER) || blockState.is(Blocks.CRAFTING_TABLE) || blockState.is(Blocks.OAK_PLANKS) || blockState.is(Blocks.OAK_SLAB)
                || blockState.is(Blocks.DARK_OAK_PLANKS) || blockState.is(Blocks.DARK_OAK_SLAB) || blockState.is(Blocks.ACACIA_PLANKS) || blockState.is(Blocks.ACACIA_SLAB)
                || blockState.is(Blocks.JUNGLE_PLANKS) || blockState.is(Blocks.JUNGLE_SLAB) || blockState.is(Blocks.BIRCH_PLANKS) || blockState.is(Blocks.BIRCH_SLAB)
                || blockState.is(Blocks.SPRUCE_PLANKS) || blockState.is(Blocks.SPRUCE_SLAB) || blockState.is(Blocks.BAMBOO_PLANKS) || blockState.is(Blocks.BAMBOO_SLAB)
                || blockState.is(Blocks.MANGROVE_PLANKS) || blockState.is(Blocks.MANGROVE_SLAB) || blockState.is(Blocks.CHERRY_PLANKS) || blockState.is(Blocks.CHERRY_SLAB)
                || blockState.is(Blocks.WARPED_PLANKS) || blockState.is(Blocks.WARPED_SLAB) || blockState.is(Blocks.CRIMSON_PLANKS) || blockState.is(Blocks.CRIMSON_SLAB)
                || blockState.is(Blocks.BAMBOO_MOSAIC_SLAB) || blockState.is(Blocks.BAMBOO_MOSAIC) || blockState.is(Blocks.OBSIDIAN);
    }
}
