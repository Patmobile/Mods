package de.patmobile.moreblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.patmobile.moreblocks.proxy.IModProxy;
import de.patmobile.moreblocks.blocks.BlockBasic;
import de.patmobile.moreblocks.blocks.BlockTreppe;
import de.patmobile.moreblocks.init.BlockInit;
import de.patmobile.moreblocks.init.ItemInit;
import de.patmobile.moreblocks.proxy.ClientProxy;
import de.patmobile.moreblocks.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppedEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModConfig.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class MoreBlocksMod 
{
	public static final Logger logger = LogManager.getLogger();
	public static MoreBlocksMod instance;
	
	public static ItemGroup MoreBlocksTab = new ItemGroup("moreblockstab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.EisziegelTreppe);
        }
    };
    
    public static final IModProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public MoreBlocksMod() 
	{
          instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		proxy.construct();
	}
	
	@SubscribeEvent
	public void setup(FMLCommonSetupEvent event) {
		proxy.setup();
    }
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(				
				ItemInit.Eisziegel = new ItemBlock(BlockInit.Eisziegel, new Item.Properties().group(MoreBlocksTab)).setRegistryName(BlockInit.Eisziegel.getRegistryName()),
				ItemInit.Schneeziegel = new ItemBlock(BlockInit.Schneeziegel, new Item.Properties().group(MoreBlocksTab)).setRegistryName(BlockInit.Schneeziegel.getRegistryName()),
				ItemInit.VerstaerkterDiamantblock = new ItemBlock(BlockInit.VerstaerkterDiamantblock, new Item.Properties().group(MoreBlocksTab)).setRegistryName(BlockInit.VerstaerkterDiamantblock.getRegistryName()),
				ItemInit.EisziegelTreppe = new ItemBlock(BlockInit.EisziegelTreppe, new Item.Properties().group(MoreBlocksTab)).setRegistryName(BlockInit.EisziegelTreppe.getRegistryName()),
				ItemInit.SchneeziegelTreppe = new ItemBlock(BlockInit.SchneeziegelTreppe, new Item.Properties().group(MoreBlocksTab)).setRegistryName(BlockInit.SchneeziegelTreppe.getRegistryName()),
				ItemInit.VerstaerkteDiamantTreppe = new ItemBlock(BlockInit.VerstaerkteDiamantTreppe, new Item.Properties().group(MoreBlocksTab)).setRegistryName(BlockInit.VerstaerkteDiamantTreppe.getRegistryName())
			);
			
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockInit.Eisziegel = new BlockBasic(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5f, 2.5f).sound(SoundType.STONE)).setRegistryName(location("eisziegel")),
				BlockInit.Schneeziegel = new BlockBasic(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5f, 2.5f).sound(SoundType.STONE)).setRegistryName(location("schneeziegel")),
				BlockInit.VerstaerkterDiamantblock = new BlockBasic(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5f, 2.5f).sound(SoundType.STONE)).setRegistryName(location("verstaerkterdiamantblock")),
				BlockInit.EisziegelTreppe = new BlockTreppe(BlockInit.Eisziegel.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5f, 2.5f).sound(SoundType.STONE)).setRegistryName(location("eisziegeltreppe")),
				BlockInit.SchneeziegelTreppe = new BlockTreppe(BlockInit.Schneeziegel.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5f, 2.5f).sound(SoundType.STONE)).setRegistryName(location("schneeziegeltreppe")),
				BlockInit.VerstaerkteDiamantTreppe = new BlockTreppe(BlockInit.VerstaerkterDiamantblock.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5f, 2.5f).sound(SoundType.STONE)).setRegistryName(location("verstaerktediamanttreppe"))
				
			
			);
			
			logger.info("Blocks registered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(ModConfig.MODID, name);
		}
} 
	

	
	   @SubscribeEvent
	    public static void serverStarted(FMLServerStartedEvent event) {
	   
	    }

	    @SubscribeEvent
	    public static void serverStopped(FMLServerStoppedEvent event) {
	
	}	
	
}