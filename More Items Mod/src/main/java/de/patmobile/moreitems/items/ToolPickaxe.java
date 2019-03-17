package de.patmobile.moreitems.items;

import de.patmobile.moreitems.api.IToolMaterial;
import de.patmobile.moreitems.api.IToolMaterial.Tools;
import de.patmobile.moreitems.api.IUItem;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;

public class ToolPickaxe extends ItemPickaxe implements IUItem {
	
	protected final String name;
	
	public ToolPickaxe(String name, Properties properties, IToolMaterial material) {
		this(name, null, properties, material);
	}
	
	public ToolPickaxe(String name, ItemGroup group, Properties properties, IToolMaterial material) {
		super(material, (int) material.getAdditionalDamage(Tools.PICKAXE), material.getAttackSpeed(Tools.PICKAXE), applyToolType(group == null ? properties : properties.group(group), material));
		this.name = name;
	}
	
	@Override
	public String getEntryName() {
		return name;
	}
	
	private static Properties applyToolType(Properties properties, IToolMaterial material) {
		return properties.addToolType(ToolType.PICKAXE, material.getHarvestLevel());
	}
}