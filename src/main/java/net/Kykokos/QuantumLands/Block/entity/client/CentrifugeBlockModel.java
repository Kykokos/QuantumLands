package net.Kykokos.QuantumLands.Block.entity.client;

import net.Kykokos.QuantumLands.Block.entity.CentrifugeBlockEntity;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CentrifugeBlockModel extends GeoModel<CentrifugeBlockEntity> {
    @Override
    public ResourceLocation getModelResource(CentrifugeBlockEntity centrifugeBlockEntity) {
        return new ResourceLocation(QuantumLands.MOD_ID, "geo/centrifuge.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CentrifugeBlockEntity centrifugeBlockEntity) {
        return new ResourceLocation(QuantumLands.MOD_ID, "textures/block/centrifuge.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CentrifugeBlockEntity centrifugeBlockEntity) {
        return new ResourceLocation(QuantumLands.MOD_ID, "animations/centrifuge.animation.json");
    }
}
