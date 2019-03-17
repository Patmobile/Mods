package de.patmobile.paralleldimension;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.patmobile.paralleldimension.proxy.IModProxy;
import de.patmobile.paralleldimension.proxy.ClientProxy;
import de.patmobile.paralleldimension.proxy.CommonProxy;
import de.patmobile.paralleldimension.ModConfig;
import de.patmobile.paralleldimension.biome.BiomeKirschwald;
import de.patmobile.paralleldimension.biome.ParallelDimensionBiomeProvider;
import de.patmobile.paralleldimension.biome.ParallelDimensionBiomeProviderSettings;
import de.patmobile.paralleldimension.dimension.DimensionParallelDimension;
import de.patmobile.paralleldimension.dimension.ModDimensionParallelDimension;
import de.patmobile.paralleldimension.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppedEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModConfig.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ParallelDimensionMod 
{
	public static final Logger logger = LogManager.getLogger();
    public static final int ParallelDimensionID = 3;
    public static final ModDimension ParallelDimension = new ModDimensionParallelDimension();
    public static DimensionType ParallelDimensionTyp = new DimensionType(ParallelDimensionID , ModConfig.MODID, ModConfig.MODID, DimensionParallelDimension::new).setRegistryName(ModConfig.MODID,"paralleldimension");
    public static final BiomeProviderType<ParallelDimensionBiomeProviderSettings, ParallelDimensionBiomeProvider> ParallelDimensionBiomeProviderType = BiomeProviderType.func_212581_a("paralleldimensionbiomeprovidertype", ParallelDimensionBiomeProvider::new, ParallelDimensionBiomeProviderSettings::new);

	public static ItemGroup ParallelDimensionTab = new ItemGroup("paralleldimensiontab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.HoellenFeuerzeug);
        }
    };
    
    public static final IModProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public ParallelDimensionMod() 
	{
		initBiomes();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		 FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		proxy.construct();
	}
	
	@SubscribeEvent
	public void setup(FMLCommonSetupEvent event) {
		proxy.setup();
    	DimensionManager.registerDimension(new ResourceLocation(ModConfig.MODID), ParallelDimension,ParallelDimensionTyp.getData());
    }
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
	}
	
	   @SubscribeEvent
	    public static void serverStarted(FMLServerStartedEvent event) {
	   
	    }

	    @SubscribeEvent
	    public static void serverStopped(FMLServerStoppedEvent event) {
	
	}	
	    
	    private void doClientStuff(final FMLClientSetupEvent event) {
	        OBJLoader.INSTANCE.addDomain(ModConfig.MODID);
	        //EntityRenderingRegistry.registerRenders();
	}
	    
	    
	 public static Biome BiomeKirschwald;
	 
	 private static void initBiomes() {
		 
		 BiomeKirschwald = new BiomeKirschwald().setRegistryName(ModConfig.MODID,"paralleldimension_kirschwald");
	 }
	
}