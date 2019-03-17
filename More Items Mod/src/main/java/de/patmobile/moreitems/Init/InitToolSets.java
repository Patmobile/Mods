package de.patmobile.moreitems.Init;

import de.patmobile.moreitems.ModConfig;
import de.patmobile.moreitems.MoreItemsMod;
import de.patmobile.moreitems.api.IToolMaterial;
import de.patmobile.moreitems.items.SmaragdToolMaterial;
import de.patmobile.moreitems.items.ToolSet;
import de.patmobile.moreitems.items.ToolSetCreator;
import de.patmobile.moreitems.registry.ToolSetRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;

public class InitToolSets {
	
	public static final IToolMaterial smaragd = new SmaragdToolMaterial(new float[] { 5, 0, 1, 1, 3 }, new float[] { -3.05F, -1F, -2.8F, -3F, -2.4F }, 2, 1000, 10F, 2.5F, 15, () -> Ingredient.fromItems(Items.EMERALD));
	public static final IToolMaterial obsidian = new SmaragdToolMaterial(new float[] { 5.5F, 0, 1.0F, 1.5F, 3.0F }, new float[] { -3.0F, -1F, -2.8F, -3F, -2.4F }, 3, 1250, 7F, 2.5F, 15, () -> Ingredient.fromItems(Blocks.OBSIDIAN));
	public static final IToolMaterial verstaerkterdiamant = new SmaragdToolMaterial(new float[] { 5.5F, -1.0F, 1.0F, 1.5F, 3.0F }, new float[] { -2.9F, -1F, -2.8F, -3F, -2.4F }, 4, 2000, 16F, 4F, 35, () -> Ingredient.fromItems(ItemInit.VerstaerkterDiamant));
	
	public static final ToolSet smaragdtool = ToolSetCreator.create("smaragdtool", MoreItemsMod.MoreItemsTab, new Properties(), smaragd);
	public static final ToolSet obsidiantool = ToolSetCreator.create("obsidiantool", MoreItemsMod.MoreItemsTab, new Properties(), obsidian);
	public static final ToolSet verstaerktesdiamanttool = ToolSetCreator.create("verstaerktesdiamanttool", MoreItemsMod.MoreItemsTab, new Properties(), verstaerkterdiamant);
	public static void construct() {
		ToolSetRegistry.register(ModConfig.MODID, InitToolSets.class);
	}
	
}