package de.patmobile.moreitems.items;

import de.patmobile.moreitems.registry.IItemRegistryType;
import net.minecraft.item.Item;

public class ToolSet implements IItemRegistryType {
	
	private final ToolAxe axe;
	private final ToolHoe hoe;
	private final ToolPickaxe pickaxe;
	private final ToolSpade spade;
	private final ToolSword sword;
	
	public ToolSet(ToolAxe axe, ToolHoe hoe, ToolPickaxe pickaxe, ToolSpade spade, ToolSword sword) {
		this.axe = axe;
		this.hoe = hoe;
		this.pickaxe = pickaxe;
		this.spade = spade;
		this.sword = sword;
	}
	
	@Override
	public Item[] getItemArray() {
		return new Item[] { axe, hoe, pickaxe, spade, sword };
	}
	
	public ToolAxe getAxe() {
		return axe;
	}
	
	public ToolHoe getHoe() {
		return hoe;
	}
	
	public ToolPickaxe getPickaxe() {
		return pickaxe;
	}
	
	public ToolSpade getSpade() {
		return spade;
	}
	
	public ToolSword getSword() {
		return sword;
	}
	
}