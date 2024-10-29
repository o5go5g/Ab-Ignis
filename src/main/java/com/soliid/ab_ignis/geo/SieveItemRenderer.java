package com.soliid.ab_ignis.geo;

import com.soliid.ab_ignis.AbIgnis;
import com.soliid.ab_ignis.item.custom.SieveItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SieveItemRenderer extends GeoItemRenderer<SieveItem>
{
    public SieveItemRenderer()
    {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(AbIgnis.MOD_ID,"sieve")));
    }
}
