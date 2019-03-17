package de.patmobile.moreitems.items;

import de.patmobile.moreitems.api.IToolMaterial;
import de.patmobile.moreitems.api.IToolMaterial.Tools;
import de.patmobile.moreitems.api.IUItem;
import net.minecraft.item.*;

public class ToolHoe extends ItemHoe implements IUItem {
	
	protected final String name;
	
	public ToolHoe(String name, Properties properties, IToolMaterial material) {
		this(name, null, properties, material);
	}
	
	public ToolHoe(String name, ItemGroup group, Properties properties, IToolMaterial material) {
		super(material, material.getAttackSpeed(Tools.HOE), group == null ? properties : properties.group(group));
		this.name = name;
	}
	
	@Override
	public String getEntryName() {
		return name;
	}
	
}