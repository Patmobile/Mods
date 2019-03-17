package de.patmobile.paralleldimension.biome;

import de.patmobile.paralleldimension.dimension.ParallelDimensionGenSettings;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.storage.WorldInfo;

public class ParallelDimensionBiomeProviderSettings extends OverworldBiomeProviderSettings {
	
    private WorldInfo worldInfo;
    private ParallelDimensionGenSettings generatorSettings;

    public ParallelDimensionBiomeProviderSettings() {
    }

    public ParallelDimensionBiomeProviderSettings setWorldInfo(WorldInfo p_205439_1_) {
        this.worldInfo = p_205439_1_;
        return this;
    }

    public ParallelDimensionBiomeProviderSettings setGeneratorSettings(ParallelDimensionGenSettings p_205441_1_) {
        this.generatorSettings = p_205441_1_;
        return this;
    }

    public WorldInfo getWorldInfo() {
        return this.worldInfo;
    }

    public ParallelDimensionGenSettings getGeneratorSettings() {
        return this.generatorSettings;
    }
}