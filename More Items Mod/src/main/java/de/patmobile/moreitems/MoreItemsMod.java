package de.patmobile.moreitems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import de.patmobile.moreitems.Init.ItemInitMI;
import de.patmobile.moreitems.proxy.IModProxy;
import de.patmobile.moreitems.proxy.ClientProxy;
import de.patmobile.moreitems.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
public class MoreItemsMod 
{
	public static final Logger logger = LogManager.getLogger();
	
	
	public static ItemGroup MoreItemsTab = new ItemGroup("moreitemstab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInitMI.VerstaerkterDiamant);
        }
    };
    
    public static final IModProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public MoreItemsMod() 
	{
		ItemInitMI.initItems();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		proxy.construct();
	}
	
	@SubscribeEvent
	public void setup(FMLCommonSetupEvent event) {
		proxy.setup();
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
	
}