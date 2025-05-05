package net.Kykokos.QuantumLands.Block.entity;

import net.Kykokos.QuantumLands.Block.custom.CentrifugeBlock;
import net.Kykokos.QuantumLands.Item.ModItems;
import net.Kykokos.QuantumLands.recipe.CentrifugeRecipe;
import net.Kykokos.QuantumLands.screen.CentrifugeMenu;
import net.Kykokos.QuantumLands.sound.ModSounds;
import net.Kykokos.QuantumLands.util.InventoryDirectionEntry;
import net.Kykokos.QuantumLands.util.InventoryDirectionWrapper;
import net.Kykokos.QuantumLands.util.WrappedHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtils;

import java.util.Map;
import java.util.Optional;

public class CentrifugeBlockEntity extends BlockEntity implements GeoBlockEntity, MenuProvider {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private final ItemStackHandler itemHandler = new ItemStackHandler(4){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot)
            {
                case 0 -> true;
                case 1 -> false;
                case 2 -> false;
                case 3 -> stack.getItem() == ModItems.SIMPLE_BATTERY.get();
                default -> super.isItemValid(slot, stack);
            };
        }
    };
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT1 = 1;
    private static final int OUTPUT_SLOT2 = 2;
    private static final int ENERGY_ITEM_SLOT = 3;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
            new InventoryDirectionWrapper(itemHandler,
                    new InventoryDirectionEntry(Direction.DOWN, OUTPUT_SLOT1, false),
                    new InventoryDirectionEntry(Direction.DOWN, OUTPUT_SLOT2, false),
                    new InventoryDirectionEntry(Direction.NORTH, INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.SOUTH, INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.EAST, INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.WEST, INPUT_SLOT, true),
                    new InventoryDirectionEntry(Direction.UP, INPUT_SLOT, true)).directionsMap;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 65;

    public CentrifugeBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CENTRIFUGE_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> CentrifugeBlockEntity.this.progress;
                    case 1 -> CentrifugeBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex)
                {
                    case 0 -> CentrifugeBlockEntity.this.progress = pValue;
                    case 1 -> CentrifugeBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

   @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {

        event.getController().setAnimation(RawAnimation.begin().then("spin", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object blockEntity) {
        return RenderUtils.getCurrentSystemTick();
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("gui_name.quantum_lands.centrifuge_block_gui_name");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CentrifugeMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER)
        {
            if(side == null)
            {
                return lazyItemHandler.cast();
            }

            if(directionWrappedHandlerMap.containsKey(side))
            {
                Direction localDir = this.getBlockState().getValue(CentrifugeBlock.FACING);

                if(side == Direction.DOWN || side == Direction.UP)
                {
                    return directionWrappedHandlerMap.get(side).cast();
                }

                return switch (localDir) {
                    default -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionWrappedHandlerMap.get(side).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++)
        {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {



        if(isOutputSlot1EmptyOrRecievable() && isOutputSlot2EmptyOrRecievable() && hasRecipe())
        {
            increaseCraftingProcess();
            setChanged(level, pPos, pState);
            this.level.playSound(null, pPos, ModSounds.CENTRIFUGE_WORKING.get(), SoundSource.BLOCKS, 1f, 1f);

            if (hasProgressFinished())
            {
                craftItem();
                resetProgress();
            }
        } else
        {
            resetProgress();
        }
    }

    private void craftItem() {
        Optional<CentrifugeRecipe> recipe = getCurrentRecipe();

        ItemStack output1 = recipe.get().getOutput1().copy();
        ItemStack output2 = recipe.get().getOutput2().copy();

        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
        this.itemHandler.setStackInSlot(OUTPUT_SLOT1, new ItemStack(output1.getItem(), this.itemHandler.getStackInSlot(OUTPUT_SLOT1).getCount() + output1.getCount()));
        this.itemHandler.setStackInSlot(OUTPUT_SLOT2, new ItemStack(output2.getItem(), this.itemHandler.getStackInSlot(OUTPUT_SLOT2).getCount() + output2.getCount()));
    }

    private void resetProgress() {
        this.progress = 0;

    }

    private boolean hasProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProcess() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Optional<CentrifugeRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) return false;
        ItemStack output1 = recipe.get().getOutput1().copy();
        ItemStack output2 = recipe.get().getOutput2().copy();

        return canInsertAmountIntoOutputSlot1(output1.getCount())
                && canInsertAmountIntoOutputSlot2(output2.getCount()) && canInsertItemIntoOutputSlot1(output1.getItem())
                && canInsertItemIntoOutputSlot2(output2.getItem());
    }

    private Optional<CentrifugeRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++)
        {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(CentrifugeRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot2(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT2).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT2).is(item);
    }

    private boolean canInsertItemIntoOutputSlot1(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT1).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT1).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot1(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT1).getMaxStackSize() >= this.itemHandler.getStackInSlot(OUTPUT_SLOT1).getCount() + count;
    }

    private boolean canInsertAmountIntoOutputSlot2(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT2).getMaxStackSize() >= this.itemHandler.getStackInSlot(OUTPUT_SLOT2).getCount() + count;
    }

    private boolean isOutputSlot1EmptyOrRecievable() {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT1).isEmpty() ||
                this.itemHandler.getStackInSlot(OUTPUT_SLOT1).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT1).getMaxStackSize();
    }
    private boolean isOutputSlot2EmptyOrRecievable() {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT2).isEmpty() ||
                this.itemHandler.getStackInSlot(OUTPUT_SLOT2).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT2).getMaxStackSize();

    }
}
