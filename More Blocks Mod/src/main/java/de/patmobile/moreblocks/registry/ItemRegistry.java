package de.patmobile.moreblocks.registry;

import java.util.*;

import de.patmobile.moreblocks.ModConfig;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = ModConfig.MODID, bus = Bus.MOD)
public class ItemRegistry {
	
	static List<Item> items = new ArrayList<>();
	
	public static void register(String modid, Item item) {
		BaseRegistry.register(modid, item, items);
	}
	
	public static void register(String modid, Collection<Item> list) {
		list.forEach(item -> register(modid, item));
	}
	
	public static void register(String modid, Class<?> clazz) {
		register(modid, RegistryUtil.getRegistryEntries(Item.class, clazz));
	}
	
	@SubscribeEvent
	public static void event(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		items.forEach(registry::register);
	}
}