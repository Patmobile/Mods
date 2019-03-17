package de.patmobile.paralleldimension.util;

import de.patmobile.paralleldimension.ParallelDimensionMod;

import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHelper {

    @SubscribeEvent
    public static void registerSounds(final RegistryEvent.Register<SoundEvent> event){

    }



    @SubscribeEvent
    public static void registerDimensionTypes(final RegistryEvent.Register<DimensionType> event){
        final IForgeRegistry<DimensionType> registry = event.getRegistry();
        registry.register(ParallelDimensionMod.ParallelDimensionTyp);
    }

    @SubscribeEvent
    public static void registerDimensionMod(final RegistryEvent.Register<ModDimension> event){
        final IForgeRegistry<ModDimension> registry = event.getRegistry();
        registry.register(ParallelDimensionMod.ParallelDimension);
    }

    @SubscribeEvent
    public static void registerKatharianBiomes(final RegistryEvent.Register<Biome> event){
        final IForgeRegistry<Biome> registry = event.getRegistry();
        registry.register(ParallelDimensionMod.BiomeKirschwald);

    }

    

}