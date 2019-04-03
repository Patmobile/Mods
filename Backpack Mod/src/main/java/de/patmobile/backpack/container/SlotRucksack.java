package de.patmobile.backpack.container;

import de.patmobile.backpack.items.ItemRucksack;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class SlotRucksack extends Slot {
	
	public SlotRucksack(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		
		if (!stack.isEmpty()) {
			if (stack.getItem() instanceof ItemRucksack) {
			return false;
			}
			
			else {
				return true;
			}
		}
		
		return false;
	}
	
}