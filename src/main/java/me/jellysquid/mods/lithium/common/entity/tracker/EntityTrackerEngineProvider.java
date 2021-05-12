package me.jellysquid.mods.lithium.common.entity.tracker;

public interface EntityTrackerEngineProvider {
    EntityTrackerEngine lithium$getEntityTracker();

    static EntityTrackerEngine lithium$getEntityTracker(Object world) {
        return world instanceof EntityTrackerEngineProvider ? ((EntityTrackerEngineProvider) world).lithium$getEntityTracker() : null;
    }
}
