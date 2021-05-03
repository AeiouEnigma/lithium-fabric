package me.jellysquid.mods.lithium.mixin.gen.fast_layer_sampling;

import me.jellysquid.mods.lithium.common.world.layer.CachingLayerContextExtended;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.ZoomLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ZoomLayer.class)
public abstract class ScaleLayerMixin {
    @Shadow
    public abstract int getOffsetX(int x);

    @Shadow
    public abstract int getOffsetZ(int y);

    @Shadow
    protected abstract int pickZoomed(IExtendedNoiseRandom<?> ctx, int tl, int tr, int bl, int br);

    /**
     * @reason Replace with faster implementation.
     * @author gegy1000
     */
    @Overwrite
    public int apply(IExtendedNoiseRandom<?> context, IArea area, int x, int z) {
        // [VanillaCopy] ScaleLayer#sample

        int i = area.getValue(this.getOffsetX(x), this.getOffsetZ(z));
        context.setPosition((long)(x >> 1 << 1), (long)(z >> 1 << 1));
        int j = x & 1;
        int k = z & 1;

        if (j == 0 && k == 0) {
            return i;
        }

        context.pickRandom(x & ~1, z & ~1);

        if (j == 0) {
            int bl = area.getValue(this.getOffsetX(x), this.getOffsetZ(z + 1));
            return context.pickRandom(i, bl);
        }

        // move `choose` into above if-statement: maintain rng parity
        ((CachingLayerContextExtended) context).skipInt();

        if (k == 0) {
            int tr = area.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z));
            return context.pickRandom(i, tr);
        }

        // move `choose` into above if-statement: maintain rng parity
        ((CachingLayerContextExtended) context).skipInt();

        int l = area.getValue(this.getOffsetX(x), this.getOffsetZ(z + 1));
        int j1 = area.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z));
        int l1 = area.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z + 1));

        return this.pickZoomed(context, i, j1, l, l1);
    }
}