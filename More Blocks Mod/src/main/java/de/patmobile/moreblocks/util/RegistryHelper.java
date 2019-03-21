package de.patmobile.moreblocks.util;

import com.google.common.base.Preconditions;

import de.patmobile.moreblocks.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
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
    public static void registerItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();
        for(ItemBlock itemBlock:BlockInit.itemBlocksRegistryList){
            final Block block = itemBlock.getBlock();
            final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
            ItemBlock itemBlock1 = (ItemBlock) new ItemBlock(block,new Item.Properties().group(itemBlock.getGroup())).setRegistryName(registryName);
            registry.register(itemBlock1);
        }
  
}


    

}