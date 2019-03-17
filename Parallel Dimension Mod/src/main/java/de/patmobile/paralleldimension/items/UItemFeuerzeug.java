package de.patmobile.paralleldimension.items;


import de.patmobile.paralleldimension.api.IUItem;
import net.minecraft.item.*;

public class UItemFeuerzeug extends ItemFlintAndSteel implements IUItem {
	
	protected final String name;
	
	public UItemFeuerzeug(String name, Properties properties) {
		this(name, null, properties);
	}
	
	public UItemFeuerzeug(String name, ItemGroup group, Properties properties) {
		super(group == null ? properties : properties.group(group));
		this.name = name;
	}
	
	@Override
	public String getEntryName() {
		return name;
	}
}