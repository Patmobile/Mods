package de.patmobile.backpack.container;

import de.patmobile.backpack.enums.EnumRucksack;
import de.patmobile.backpack.inventory.InventoryRucksack;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class ContainerRucksack extends UContainer {
	
	private InventoryRucksack backpackInventory;
	private EnumRucksack type;
	
	public ContainerRucksack(InventoryPlayer playerInventory, InventoryRucksack backpackInventory) {
		
		this.backpackInventory = backpackInventory;
		type = backpackInventory.getType();
		
		int xBackpack = 0;
		int yBackpack = 0;
		
		int xPlayer = 0;
		int yPlayer = 0;
		
		
		switch (type) {
		case KLEIN:
			xBackpack = 8;
			yBackpack = 15;
			
			xPlayer = 8;
			yPlayer = 77;
			
			break;
		case GROSS:
			xBackpack = 8;
			yBackpack = 18;
			
			xPlayer = 8;
			yPlayer = 122;
			break;
		}
		
		appendBackPackInventory(backpackInventory, xBackpack, yBackpack);
		appendPlayerInventory(playerInventory, xPlayer, yPlayer);
	}
	
	public void appendBackPackInventory(InventoryRucksack inventory, int x_offset, int y_offset) {
		for (int height = 0; height < type.getSizeY(); height++) {
			for (int width = 0; width < type.getSizeX(); width++) {
				addSlot(new SlotRucksack(inventory, width + height * type.getSizeX(), width * 18 + x_offset, height * 18 + y_offset));
			}
		}
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		backpackInventory.writeItemStack();
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index < type.getCount()) {
				if (!this.mergeItemStack(itemstack1, type.getCount(), this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, type.getCount(), false)) {
				return ItemStack.EMPTY;
			}
			
			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
	

	
	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
		Slot tmpSlot;
		if (slotId >= 0 && slotId < inventorySlots.size()) {
			tmpSlot = (Slot) inventorySlots.get(slotId);
		} else {
			tmpSlot = null;
		}
		if (tmpSlot != null) {
			if (tmpSlot.isHere(player.inventory, player.inventory.currentItem)) {
				return tmpSlot.getStack();
			}
		}
		if (clickTypeIn == ClickType.SWAP) {
			ItemStack stack = player.inventory.getStackInSlot(dragType);
			if (stack == player.inventory.getCurrentItem()) {
				return ItemStack.EMPTY;
			}
		}
		return super.slotClick(slotId, dragType, clickTypeIn, player);
	}
	
}