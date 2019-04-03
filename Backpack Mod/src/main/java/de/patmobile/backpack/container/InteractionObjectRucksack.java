package de.patmobile.backpack.container;

import de.patmobile.backpack.ModConfig;
import de.patmobile.backpack.enums.EnumRucksack;
import de.patmobile.backpack.inventory.InventoryRucksack;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class InteractionObjectRucksack implements IInteractionObject {
	
	private final ItemStack stack;
	private final EnumRucksack type;
	
	public InteractionObjectRucksack(ItemStack stack, EnumRucksack type) {
		this.stack = stack;
		this.type = type;
	}
	
	@Override
	public ITextComponent getName() {
		return null;
	}
	
	@Override
	public ITextComponent getCustomName() {
		return null;
	}
	
	@Override
	public boolean hasCustomName() {
		return false;
	}
	
	@Override
	public String getGuiID() {
		return ModConfig.MODID + ":rucksack";
	}
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer player) {
		return new ContainerRucksack(playerInventory, new InventoryRucksack(stack, type));
}
	
}