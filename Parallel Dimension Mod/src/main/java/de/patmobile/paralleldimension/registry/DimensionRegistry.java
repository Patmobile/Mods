package de.patmobile.paralleldimension.registry;

import java.util.*;

import de.patmobile.paralleldimension.ModConfig;
import de.patmobile.paralleldimension.api.IURegistry;
import de.patmobile.paralleldimension.util.RegistryUtil;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = ModConfig.MODID, bus = Bus.MOD)
public class DimensionRegistry {
	
	static List<ModDimension> dimensions = new ArrayList<>();
	
	public static void register(String modid, ModDimension dimension) {
		if (dimension instanceof IURegistry) {
			IURegistry iudimension = (IURegistry) dimension;
			dimension.setRegistryName(modid, iudimension.getEntryName());
		}
		dimensions.add(dimension);
	}
	
	public static void register(String modid, Collection<ModDimension> list) {
		list.forEach(dimension -> register(modid, dimension));
	}
	
	public static void register(String modid, Class<?> clazz) {
		register(modid, RegistryUtil.getRegistryEntries(ModDimension.class, clazz));
	}
	
	@SubscribeEvent
	public static void event(RegistryEvent.Register<ModDimension> event) {
		IForgeRegistry<ModDimension> registry = event.getRegistry();
		dimensions.forEach(registry::register);
	}
}