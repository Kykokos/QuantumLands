package net.Kykokos.QuantumLands.Item.client;

import net.Kykokos.QuantumLands.Block.entity.CentrifugeBlockEntity;
import net.Kykokos.QuantumLands.Item.custom.CentrifugeItem;
import net.Kykokos.QuantumLands.QuantumLands;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CentrifugeBlockItemModel extends GeoModel<CentrifugeItem> {

    @Override
    public ResourceLocation getModelResource(CentrifugeItem centrifugeItem) {
        return new ResourceLocation(QuantumLands.MOD_ID, "geo/centrifuge.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CentrifugeItem centrifugeItem) {
        return new ResourceLocation(QuantumLands.MOD_ID, "textures/block/centrifuge.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CentrifugeItem centrifugeItem) {
        return new ResourceLocation(QuantumLands.MOD_ID, "animations/centrifuge.animation.json");
    }
}
