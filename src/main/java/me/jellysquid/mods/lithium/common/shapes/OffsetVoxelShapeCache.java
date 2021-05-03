package me.jellysquid.mods.lithium.common.shapes;

import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

public interface OffsetVoxelShapeCache {
    VoxelShape getOffsetSimplifiedShape(float offset, Direction direction);

    void setShape(float offset, Direction direction, VoxelShape offsetShape);
}
