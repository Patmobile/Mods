package de.patmobile.moreitems.items;


import de.patmobile.moreitems.api.IToolMaterial;
import de.patmobile.moreitems.api.IToolMaterial.Tools;
import de.patmobile.moreitems.api.IUItem;
import net.minecraft.item.*;

public class ToolSword extends ItemSword implements IUItem {
	
	protected final String name;
	
	public ToolSword(String name, Properties properties, IToolMaterial material) {
		this(name, null, properties, material);
	}
	
	public ToolSword(String name, ItemGroup group, Properties properties, IToolMaterial material) {
		super(material, (int) material.getAdditionalDamage(Tools.SWORD), material.getAttackSpeed(Tools.SWORD), group == null ? properties : properties.group(group));
		this.name = name;
	}
	
	@Override
	public String getEntryName() {
		return name;
	}
	
}