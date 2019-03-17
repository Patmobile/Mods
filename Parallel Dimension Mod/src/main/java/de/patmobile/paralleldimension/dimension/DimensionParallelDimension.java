package de.patmobile.paralleldimension.dimension;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.JsonOps;

import de.patmobile.paralleldimension.ParallelDimensionMod;
import de.patmobile.paralleldimension.biome.ParallelDimensionBiomeProvider;
import de.patmobile.paralleldimension.biome.ParallelDimensionBiomeProviderSettings;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.IRegistry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraft.world.gen.*;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

import javax.annotation.Nullable;

public class DimensionParallelDimension extends OverworldDimension {

    public DimensionParallelDimension() {
        super(DimensionManager.getRegistry().get(ParallelDimensionMod.ParallelDimensionID));
    }

    public IChunkGenerator<? extends IChunkGenSettings> createChunkGenerator() {
        WorldType worldtype = this.world.getWorldInfo().getTerrainType();
        BiomeProviderType<ParallelDimensionBiomeProviderSettings, ParallelDimensionBiomeProvider> biomeprovidertype1 = ParallelDimensionMod.ParallelDimensionBiomeProviderType;

        ParallelDimensionBiomeProviderSettings overworldbiomeprovidersettings1 = biomeprovidertype1.createSettings().setGeneratorSettings(new ParallelDimensionGenSettings()).setWorldInfo(this.world.getWorldInfo());
        BiomeProvider biomeprovider = biomeprovidertype1.create(overworldbiomeprovidersettings1);

        ChunkGeneratorType<OverworldGenSettings, ChunkGeneratorOverworld> chunkgeneratortype4 = ChunkGeneratorType.SURFACE;
        OverworldGenSettings overworldgensettings1 = chunkgeneratortype4.createSettings();
        overworldgensettings1.setDefautBlock(Blocks.STONE.getDefaultState());
        overworldgensettings1.setDefaultFluid(Blocks.WATER.getDefaultState());
        return chunkgeneratortype4.create(this.world, biomeprovider, overworldgensettings1);
    }

    @Override
    public DimensionType getType() {
        return DimensionManager.getRegistry().get(ParallelDimensionMod.ParallelDimensionID);
    }

    @Override
    public float getCloudHeight() {
        return -1000;
    }

    @Nullable
    @Override
    public IRenderHandler getCloudRenderer() {
        return null;
    }
}