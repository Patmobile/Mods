package de.patmobile.trampolin;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import de.patmobile.trampolin.proxy.IModProxy;
import de.patmobile.trampolin.blocks.BlockTrampolin;
import de.patmobile.trampolin.init.BlockInit;
import de.patmobile.trampolin.init.ItemInit;
import de.patmobile.trampolin.proxy.ClientProxy;
import de.patmobile.trampolin.proxy.CommonProxy;

@Mod(ModConfig.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TrampolinMod
{
public static final Logger logger = LogManager.getLogger();
	
    public static TrampolinMod instance;

	public static ItemGroup TrampolinTab = new ItemGroup("trampolintab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.SchwarzesTrampolin);
        }
    };
    
    public static final IModProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public TrampolinMod() 
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
				ItemInit.WeissesTrampolin = new ItemBlock(BlockInit.WeissesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.WeissesTrampolin.getRegistryName()),
				ItemInit.OrangenesTrampolin = new ItemBlock(BlockInit.OrangenesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.OrangenesTrampolin.getRegistryName()),
				ItemInit.MagentaTrampolin = new ItemBlock(BlockInit.MagentaTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.MagentaTrampolin.getRegistryName()),
				ItemInit.HellblauesTrampolin = new ItemBlock(BlockInit.HellblauesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.HellblauesTrampolin.getRegistryName()),
				ItemInit.GelbesTrampolin = new ItemBlock(BlockInit.GelbesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.GelbesTrampolin.getRegistryName()),
				ItemInit.HellgruenesTrampolin = new ItemBlock(BlockInit.HellgruenesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.HellgruenesTrampolin.getRegistryName()),
				ItemInit.RosanesTrampolin = new ItemBlock(BlockInit.RosanesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.RosanesTrampolin.getRegistryName()),
				ItemInit.GrauesTrampolin = new ItemBlock(BlockInit.GrauesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.GrauesTrampolin.getRegistryName()),
				ItemInit.HellgrauesTrampolin = new ItemBlock(BlockInit.HellgrauesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.HellgrauesTrampolin.getRegistryName()),
				ItemInit.TuerkisesTrampolin = new ItemBlock(BlockInit.TuerkisesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.TuerkisesTrampolin.getRegistryName()),
				ItemInit.ViolettesTrampolin = new ItemBlock(BlockInit.ViolettesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.ViolettesTrampolin.getRegistryName()),
				ItemInit.BlauesTrampolin = new ItemBlock(BlockInit.BlauesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.BlauesTrampolin.getRegistryName()),
				ItemInit.BraunesTrampolin = new ItemBlock(BlockInit.BraunesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.BraunesTrampolin.getRegistryName()),
				ItemInit.GruenesTrampolin = new ItemBlock(BlockInit.GruenesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.GruenesTrampolin.getRegistryName()),
				ItemInit.RotesTrampolin = new ItemBlock(BlockInit.RotesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.RotesTrampolin.getRegistryName()),
				ItemInit.SchwarzesTrampolin = new ItemBlock(BlockInit.SchwarzesTrampolin, new Item.Properties().group(TrampolinTab)).setRegistryName(BlockInit.SchwarzesTrampolin.getRegistryName())
			);
			
			logger.info("Items registered.");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
				BlockInit.WeissesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("weissestrampolin")),
				BlockInit.OrangenesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("orangenestrampolin")),
				BlockInit.MagentaTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("magentatrampolin")),
				BlockInit.HellblauesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("hellblauestrampolin")),
				BlockInit.GelbesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("gelbestrampolin")),
				BlockInit.HellgruenesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("hellgruenestrampolin")),
				BlockInit.RosanesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("rosanestrampolin")),
				BlockInit.GrauesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("grauestrampolin")),
				BlockInit.HellgrauesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("hellgrauestrampolin")),
				BlockInit.TuerkisesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("tuerkisestrampolin")),
				BlockInit.ViolettesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("violettestrampolin")),
				BlockInit.BlauesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("blauestrampolin")),
				BlockInit.BraunesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("braunestrampolin")),
				BlockInit.GruenesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("gruenestrampolin")),
				BlockInit.RotesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("rotestrampolin")),
				BlockInit.SchwarzesTrampolin = new BlockTrampolin(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).setRegistryName(location("schwarzestrampolin"))
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
