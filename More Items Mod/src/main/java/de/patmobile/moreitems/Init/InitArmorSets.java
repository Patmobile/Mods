package de.patmobile.moreitems.Init;

import de.patmobile.moreitems.ModConfig;
import de.patmobile.moreitems.MoreItemsMod;
import de.patmobile.moreitems.items.ArmorMaterialVanilla;
import de.patmobile.moreitems.items.ArmorSet;
import de.patmobile.moreitems.items.ArmorSetCreator;
import de.patmobile.moreitems.registry.ArmorSetRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;


public class InitArmorSets {
	
	public static final IArmorMaterial steina = new ArmorMaterialVanilla(7, new int[] { 1, 2, 2, 1 }, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, () -> Ingredient.fromItems(Blocks.STONE));
	public static final IArmorMaterial smaragda = new ArmorMaterialVanilla(24, new int[] { 3, 5, 7, 2 }, 17, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1, () -> Ingredient.fromItems(Items.EMERALD));
	public static final IArmorMaterial obsidiana = new ArmorMaterialVanilla(30, new int[] { 3, 6, 8, 3 }, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1, () -> Ingredient.fromItems(Blocks.OBSIDIAN));
	public static final IArmorMaterial verstaerktediamanta = new ArmorMaterialVanilla(50, new int[] { 3, 6, 8, 3 }, 40, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3, () -> Ingredient.fromItems(ItemInit.VerstaerkterDiamant));

	public static final ArmorSet steinarmor = ArmorSetCreator.create("steinarmor", MoreItemsMod.MoreItemsTab, new Properties(), steina);
	public static final ArmorSet smaragdarmor = ArmorSetCreator.create("smaragdarmor", MoreItemsMod.MoreItemsTab, new Properties(), smaragda);
	public static final ArmorSet obsidianarmor = ArmorSetCreator.create("obsidianarmor", MoreItemsMod.MoreItemsTab, new Properties(), obsidiana);
	public static final ArmorSet verstaerktediamantarmor = ArmorSetCreator.create("verstaerktediamantarmor", MoreItemsMod.MoreItemsTab, new Properties(), verstaerktediamanta);
	public static void construct() {
		ArmorSetRegistry.register(ModConfig.MODID, InitArmorSets.class);
	}
}