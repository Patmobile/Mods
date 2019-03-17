package de.patmobile.moreitems.api;

import net.minecraft.item.IItemTier;

public interface IToolMaterial extends IItemTier {
	
	float getAdditionalDamage(Tools tools);
	
	float getAttackSpeed(Tools tools);
	
	public static enum Tools {
		AXE(0),
		HOE(1),
		PICKAXE(2),
		SPADE(3),
		SWORD(4);
		
		private final int index;
		
		private Tools(int index) {
			this.index = index;
		}
		
		public int getIndex() {
			return index;
		}
	}
	
}