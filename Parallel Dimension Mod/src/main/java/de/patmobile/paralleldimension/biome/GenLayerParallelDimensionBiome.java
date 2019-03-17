package de.patmobile.paralleldimension.biome;

import com.google.common.collect.ImmutableList;

import de.patmobile.paralleldimension.ParallelDimensionMod;
import net.minecraft.init.Biomes;
import net.minecraft.util.registry.IRegistry;
import net.minecraft.world.gen.IContext;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;

public class GenLayerParallelDimensionBiome implements IC0Transformer {

    public static ImmutableList<BiomeManager.BiomeEntry> getBiomesToGeneration(){
        ArrayList<BiomeManager.BiomeEntry> list = new ArrayList<>();
        list.add(new BiomeManager.BiomeEntry(ParallelDimensionMod.BiomeKirschwald,10));
       // list.add(new BiomeManager.BiomeEntry(Kathairis.BIOME_KATHARIAN_DESERT,10));
        //list.add(new BiomeManager.BiomeEntry(Kathairis.BIOME_KATHARIAN_PLAIN_FIELDS,10));

        return ImmutableList.copyOf(list);
    }


    @SuppressWarnings("unchecked")
    private java.util.List<net.minecraftforge.common.BiomeManager.BiomeEntry>[] biomes = new java.util.ArrayList[net.minecraftforge.common.BiomeManager.BiomeType.values().length];
    private final OverworldGenSettings settings;

    public GenLayerParallelDimensionBiome(OverworldGenSettings p_i48641_2_) {
        for (net.minecraftforge.common.BiomeManager.BiomeType type : net.minecraftforge.common.BiomeManager.BiomeType.values()) {
            com.google.common.collect.ImmutableList<net.minecraftforge.common.BiomeManager.BiomeEntry> biomesToAdd = getBiomesToGeneration();
            int idx = type.ordinal();

            if (biomes[idx] == null) biomes[idx] = new java.util.ArrayList<net.minecraftforge.common.BiomeManager.BiomeEntry>();
            if (biomesToAdd != null) biomes[idx].addAll(biomesToAdd);
        }

        //int desertIdx = net.minecraftforge.common.BiomeManager.BiomeType.DESERT.ordinal();

        //biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.DESERT, 30));
        //biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.SAVANNA, 20));
        //biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(Biomes.PLAINS, 10));

            this.settings = p_i48641_2_;

    }

    public int apply(IContext context, int value) {
        if (this.settings != null && this.settings.func_202199_l() >= 0) {
            return this.settings.func_202199_l();
        } else {
            return IRegistry.field_212624_m.getId(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.COOL, context).biome);
        }
    }

    protected net.minecraftforge.common.BiomeManager.BiomeEntry getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType type, IContext context) {
        java.util.List<net.minecraftforge.common.BiomeManager.BiomeEntry> biomeList = getBiomesToGeneration();
        int totalWeight = net.minecraft.util.WeightedRandom.getTotalWeight(biomeList);
        int weight = net.minecraftforge.common.BiomeManager.isTypeListModded(type)?context.random(totalWeight):context.random(totalWeight / 10) * 10;
        return (net.minecraftforge.common.BiomeManager.BiomeEntry)net.minecraft.util.WeightedRandom.getRandomItem(biomeList, weight);
    }
}