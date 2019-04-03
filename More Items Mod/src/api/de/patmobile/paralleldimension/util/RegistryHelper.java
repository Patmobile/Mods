package de.patmobile.paralleldimension.util;

import com.google.common.base.Preconditions;

import de.patmobile.paralleldimension.ParallelDimensionMod;
import de.patmobile.paralleldimension.init.BlockInit;
import de.patmobile.paralleldimension.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
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
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        final IForgeRegistry<Block> registry = event.getRegistry();
        for(Block block: BlockInit.blockRegistryList){
            registry.register(block);
        }
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


    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();
        for(ItemBlock itemBlock:BlockInit.itemBlocksRegistryList){
            final Block block = itemBlock.getBlock();
            final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
            ItemBlock itemBlock1 = (ItemBlock) new ItemBlock(block,new Item.Properties().group(itemBlock.getGroup())).setRegistryName(registryName);
            registry.register(itemBlock1);
        }
        for(Item item: ItemInit.itemsToRegister){
            registry.register(item);
        }
        
}


    

}