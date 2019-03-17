package de.patmobile.moreitems.util;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.google.common.collect.Maps;

import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.*;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ItemProperties extends Properties {
	
	public ItemProperties() {
	}
	
	public ItemProperties(Properties properties) {
		maxStackSize = properties.maxStackSize;
		maxDamage = properties.maxDamage;
		containerItem = properties.containerItem;
		group = properties.group;
		rarity = properties.rarity;
		setValueCanRepair(getValueCanRepair(properties));
		setValueToolClasses(Maps.newHashMap(getValueToolClasses(properties)));
		setValueTeisr(getValueTeisr(properties));
	}
	
	private boolean getValueCanRepair(Properties properties) {
		return ObfuscationReflectionHelper.getPrivateValue(Properties.class, properties, "canRepair");
	}
	
	private void setValueCanRepair(boolean value) {
		ObfuscationReflectionHelper.setPrivateValue(Properties.class, this, value, "canRepair");
	}
	
	private Map<ToolType, Integer> getValueToolClasses(Properties properties) {
		return ObfuscationReflectionHelper.getPrivateValue(Properties.class, properties, "toolClasses");
	}
	
	private void setValueToolClasses(Map<ToolType, Integer> value) {
		ObfuscationReflectionHelper.setPrivateValue(Properties.class, this, value, "toolClasses");
	}
	
	private Supplier<Callable<TileEntityItemStackRenderer>> getValueTeisr(Properties properties) {
		return ObfuscationReflectionHelper.getPrivateValue(Properties.class, properties, "teisr");
	}
	
	private void setValueTeisr(Supplier<Callable<TileEntityItemStackRenderer>> value) {
		ObfuscationReflectionHelper.setPrivateValue(Properties.class, this, value, "teisr");
	}
	
	public int getMaxStackSize() {
		return maxStackSize;
	}
	
	public int getMaxDamage() {
		return maxDamage;
	}
	
	public Item getContainerItem() {
		return containerItem;
	}
	
	public ItemGroup getGroup() {
		return group;
	}
	
	public EnumRarity getRarity() {
		return rarity;
	}
	
	public boolean isCanRepair() {
		return getValueCanRepair(this);
	}
	
	public Map<ToolType, Integer> getToolClasses() {
		return getValueToolClasses(this);
	}
	
	public Supplier<Callable<TileEntityItemStackRenderer>> getTeisr() {
		return getValueTeisr(this);
	}
}