package de.patmobile.moreitems.items;

import java.util.function.Supplier;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

public class ArmorMaterial implements IArmorMaterial {
	
	private final int[] durability;
	private final int[] armorpoints;
	private final int enchantability;
	private final SoundEvent soundevent;
	private final float toughness;
	private final LazyLoadBase<Ingredient> repair;
	
	public ArmorMaterial(int[] durability, int[] armorpoints, int enchantability, SoundEvent soundevent, float toughness, Supplier<Ingredient> ingredient) {
		this.durability = durability;
		this.armorpoints = armorpoints;
		this.enchantability = enchantability;
		this.soundevent = soundevent;
		this.toughness = toughness;
		this.repair = new LazyLoadBase<>(ingredient);
	}
	
	@Override
	public int getDurability(EntityEquipmentSlot slot) {
		return durability[slot.getIndex()];
	}
	
	@Override
	public int getDamageReductionAmount(EntityEquipmentSlot slot) {
		return armorpoints[slot.getIndex()];
	}
	
	@Override
	public int getEnchantability() {
		return enchantability;
	}
	
	@Override
	public SoundEvent getSoundEvent() {
		return soundevent;
	}
	
	@Override
	public Ingredient getRepairMaterial() {
		return repair.getValue();
	}
	
	@Override
	public float getToughness() {
		return this.toughness;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public String getName() {
		return "invalid";
	}
	
}