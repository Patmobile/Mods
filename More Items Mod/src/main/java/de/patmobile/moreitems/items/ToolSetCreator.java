package de.patmobile.moreitems.items;


import de.patmobile.moreitems.api.IToolMaterial;
import de.patmobile.moreitems.util.ItemProperties;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;

public class ToolSetCreator {
	
	public static ToolSet create(String name, Properties properties, IToolMaterial material) {
		return create(name, null, properties, material);
	}
	
	public static ToolSet create(String name, ItemGroup group, Properties properties, IToolMaterial material) {
		return new ToolSet(new ToolAxe(name + "_axe", group, new ItemProperties(properties), material), new ToolHoe(name + "_hoe", group, new ItemProperties(properties), material), new ToolPickaxe(name + "_pickaxe", group, new ItemProperties(properties), material), new ToolSpade(name + "_shovel", group, new ItemProperties(properties), material), new ToolSword(name + "_sword", group, new ItemProperties(properties), material));
	}
	
}