package de.patmobile.moreitems.util;

import java.util.*;
import java.util.stream.Collectors;

import de.patmobile.moreitems.MoreItemsMod;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegistryUtil {
	
	public static <T extends IForgeRegistryEntry<T>> List<T> getRegistryEntries(Class<T> clazz, Class<?> init) {
		return getClassEntries(clazz, init);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> getClassEntries(Class<T> clazz, Class<?> init) {
		return Arrays.asList(init.getDeclaredFields()).stream().filter(field -> clazz.isAssignableFrom(field.getType())).map(field -> {
			try {
				return (T) field.get(null);
			} catch (Exception ex) {
				MoreItemsMod.logger.error("Failed fetching field entries for class {}", init, ex);
			}
			return null;
		}).collect(Collectors.toList());
	}
}