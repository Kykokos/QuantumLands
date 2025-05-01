package net.Kykokos.QuantumLands.Item.client;

import net.Kykokos.QuantumLands.Item.custom.CentrifugeItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CentrifugeBlockItemRenderer extends GeoItemRenderer<CentrifugeItem> {
    public CentrifugeBlockItemRenderer() {
        super(new CentrifugeBlockItemModel());
    }
}
