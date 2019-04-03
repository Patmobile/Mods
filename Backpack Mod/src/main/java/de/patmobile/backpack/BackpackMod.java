package de.patmobile.backpack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.patmobile.backpack.init.ItemInit;
import de.patmobile.backpack.proxy.ClientProxy;
import de.patmobile.backpack.proxy.CommonProxy;
import de.patmobile.backpack.proxy.IModProxy;
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
public class BackpackMod 
{
	public static final Logger logger = LogManager.getLogger();
	
	
	public static ItemGroup BackpackTab = new ItemGroup("backpacktab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemInit.KleinerOrangenerRucksack);
        }
    };
    
    public static final IModProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public BackpackMod() 
	{
		ItemInit.initItems();
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