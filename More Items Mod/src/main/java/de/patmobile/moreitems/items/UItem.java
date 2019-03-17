package de.patmobile.moreitems.items;


import de.patmobile.moreitems.api.IUItem;
import net.minecraft.item.*;

public class UItem extends Item implements IUItem {
	
	protected final String name;
	
	public UItem(String name, Properties properties) {
		this(name, null, properties);
	}
	
	public UItem(String name, ItemGroup group, Properties properties) {
		super(group == null ? properties : properties.group(group));
		this.name = name;
	}
	
	@Override
	public String getEntryName() {
		return name;
	}
}