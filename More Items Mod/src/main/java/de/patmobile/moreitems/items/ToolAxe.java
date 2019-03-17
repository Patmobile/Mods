package de.patmobile.moreitems.items;


import de.patmobile.moreitems.api.IToolMaterial;
import de.patmobile.moreitems.api.IToolMaterial.Tools;
import de.patmobile.moreitems.api.IUItem;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;

public class ToolAxe extends ItemAxe implements IUItem {
	
	protected final String name;
	
	public ToolAxe(String name, Properties properties, IToolMaterial material) {
		this(name, null, properties, material);
	}
	
	public ToolAxe(String name, ItemGroup group, Properties properties, IToolMaterial material) {
		super(material, material.getAdditionalDamage(Tools.AXE), material.getAttackSpeed(Tools.AXE), applyToolType(group == null ? properties : properties.group(group), material));
		this.name = name;
	}
	
	@Override
	public String getEntryName() {
		return name;
	}
	
	private static Properties applyToolType(Properties properties, IToolMaterial material) {
		return properties.addToolType(ToolType.AXE, material.getHarvestLevel());
	}
}