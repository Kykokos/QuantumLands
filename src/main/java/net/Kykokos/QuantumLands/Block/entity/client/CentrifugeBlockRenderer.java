package net.Kykokos.QuantumLands.Block.entity.client;


import net.Kykokos.QuantumLands.Block.entity.CentrifugeBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CentrifugeBlockRenderer extends GeoBlockRenderer<CentrifugeBlockEntity> {

    public CentrifugeBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new CentrifugeBlockModel());
    }
}
