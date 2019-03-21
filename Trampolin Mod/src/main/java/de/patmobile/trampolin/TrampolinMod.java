package de.patmobile.trampolin;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
import de.patmobile.trampolin.init.BlockInit;
import de.patmobile.trampolin.proxy.ClientProxy;
import de.patmobile.trampolin.proxy.CommonProxy;

@Mod(ModConfig.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TrampolinMod
{
public static final Logger logger = LogManager.getLogger();
	

    
	public static ItemGroup TrampolinTab = new ItemGroup("trampolintab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.SchwarzesTrampolin);
        }
    };
    
    public static final IModProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public TrampolinMod() 
	{
		BlockInit.initBlocks();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		proxy.construct();
	}
	
	@SubscribeEvent
	public void setup(FMLCommonSetupEvent event) {
		proxy.setup();
    }
	

	
	   @SubscribeEvent
	    public static void serverStarted(FMLServerStartedEvent event) {
	   
	    }

	    @SubscribeEvent
	    public static void serverStopped(FMLServerStoppedEvent event) {
	
	}	
	    

	    
}
