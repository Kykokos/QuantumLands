package net.Kykokos.QuantumLands.Block.entity;

import net.Kykokos.QuantumLands.Block.ModBlocks;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, QuantumLands.MOD_ID);

    public static final RegistryObject<BlockEntityType<CentrifugeBlockEntity>> CENTRIFUGE_ENTITY =
            BLOCK_ENTITIES.register("centrifuge_entity", () ->
                    BlockEntityType.Builder.of(CentrifugeBlockEntity::new,
                            ModBlocks.CENTRIFUGE.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }

}
