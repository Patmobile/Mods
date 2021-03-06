package de.patmobile.moreitems.Init;

import java.util.ArrayList;

import de.patmobile.moreitems.MoreItemsMod;
import de.patmobile.moreitems.items.ArmorSet;
import de.patmobile.moreitems.items.ItemStandard;
import de.patmobile.moreitems.items.ToolAxe;
import de.patmobile.moreitems.items.ToolHoe;
import de.patmobile.moreitems.items.ToolPickaxe;
import de.patmobile.moreitems.items.ToolShovel;
import de.patmobile.moreitems.items.ToolSword;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

@net.minecraftforge.registries.ObjectHolder("moreitems:items")
public class ItemInitMI 
{
	
	public static ArrayList<Item> itemsToRegister = new ArrayList<>();
	
	//Items
	public static Item VerstaerkterDiamant;
	public static Item Eisenfeder;
	public static Item Trampolingitter;
	
	//Tool
	public static Item SmaragdSpitzhacke, SmaragdAxt, SmaragdSchaufel, SmaragdHacke, SmaragdSchwert;
	public static Item ObsidianSpitzhacke, ObsidianAxt, ObsidianSchaufel, ObsidianHacke, ObsidianSchwert;
	public static Item VerstaerkteDiamantSpitzhacke, VerstaerkteDiamantAxt, VerstaerkteDiamantSchaufel, VerstaerkteDiamantHacke, VerstaerktesDiamantSchwert;
	public static Item SaphirSpitzhacke, SaphirAxt, SaphirSchaufel, SaphirHacke, SaphirSchwert;
	public static Item RubinSpitzhacke, RubinAxt, RubinSchaufel, RubinHacke, RubinSchwert;
	
	//Armor
	public static Item SteinHelm, SteinBrustplatte, SteinHose, SteinSchuhe;
	public static Item SmaragdHelm, SmaragdBrustplatte, SmaragdHose, SmaragdSchuhe;
	public static Item ObsidianHelm, ObsidianBrustplatte, ObsidianHose, ObsidianSchuhe;
	public static Item VerstaerkterDiamantHelm, VerstaerkteDiamantBrustplatte, VerstaerkteDiamantHose, VerstaerkteDiamantSchuhe;
	public static Item SaphirHelm, SaphirBrustpanzer, SaphirHose, SaphirSchuhe;
	public static Item RubinHelm, RubinBrustpanzer, RubinHose, RubinSchuhe;
	
	public static void initItems() {
	//Items
	VerstaerkterDiamant = new ItemStandard("verstaerkterdiamant", MoreItemsMod.MoreItemsTab).addToRegistryList();
	Eisenfeder = new ItemStandard("eisenfeder", MoreItemsMod.MoreItemsTab).addToRegistryList();
	Trampolingitter = new ItemStandard("trampolingitter", MoreItemsMod.MoreItemsTab).addToRegistryList();
	
	//Tools
	SmaragdSpitzhacke = new ToolPickaxe("smaragdtool_pickaxe", InitToolSets.SMARAGD, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SmaragdAxt = new ToolAxe("smaragdtool_axe", InitToolSets.SMARAGD, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SmaragdSchaufel = new ToolShovel("smaragdtool_shovel", InitToolSets.SMARAGD, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SmaragdHacke = new ToolHoe("smaragdtool_hoe", InitToolSets.SMARAGD, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SmaragdSchwert = new ToolSword("smaragdtool_sword", InitToolSets.SMARAGD, MoreItemsMod.MoreItemsTab).addToRegistryList();
	ObsidianSpitzhacke = new ToolPickaxe("obsidiantool_pickaxe", InitToolSets.OBSIDIAN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	ObsidianAxt = new ToolAxe("obsidiantool_axe", InitToolSets.OBSIDIAN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	ObsidianSchaufel = new ToolShovel("obsidiantool_shovel", InitToolSets.OBSIDIAN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	ObsidianHacke = new ToolHoe("obsidiantool_hoe", InitToolSets.OBSIDIAN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	ObsidianSchwert = new ToolSword("obsidiantool_sword", InitToolSets.OBSIDIAN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	VerstaerkteDiamantSpitzhacke = new ToolPickaxe("verstaerktesdiamanttool_pickaxe", InitToolSets.VERSTAERKTERDIAMANT, MoreItemsMod.MoreItemsTab).addToRegistryList();
	VerstaerkteDiamantAxt = new ToolAxe("verstaerktesdiamanttool_axe", InitToolSets.VERSTAERKTERDIAMANT, MoreItemsMod.MoreItemsTab).addToRegistryList();
	VerstaerkteDiamantSchaufel = new ToolShovel("verstaerktesdiamanttool_shovel", InitToolSets.VERSTAERKTERDIAMANT, MoreItemsMod.MoreItemsTab).addToRegistryList();
	VerstaerkteDiamantHacke = new ToolHoe("verstaerktesdiamanttool_hoe", InitToolSets.VERSTAERKTERDIAMANT, MoreItemsMod.MoreItemsTab).addToRegistryList();
	VerstaerktesDiamantSchwert = new ToolSword("verstaerktesdiamanttool_sword", InitToolSets.VERSTAERKTERDIAMANT, MoreItemsMod.MoreItemsTab).addToRegistryList();
    SaphirSpitzhacke = new ToolPickaxe("saphirspitzhacke", InitToolSets.SAPHIR, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SaphirAxt = new ToolAxe("saphiraxt", InitToolSets.SAPHIR, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SaphirSchaufel = new ToolShovel("saphirschaufel", InitToolSets.SAPHIR, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SaphirHacke = new ToolHoe("saphirhacke", InitToolSets.SAPHIR, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SaphirSchwert = new ToolSword("saphirschwert", InitToolSets.SAPHIR, MoreItemsMod.MoreItemsTab).addToRegistryList();
	RubinSpitzhacke = new ToolPickaxe("rubinspitzhacke", InitToolSets.RUBIN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	RubinAxt = new ToolAxe("rubinaxt", InitToolSets.RUBIN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	RubinSchaufel = new ToolShovel("rubinschaufel", InitToolSets.RUBIN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	RubinHacke = new ToolHoe("rubinhacke", InitToolSets.RUBIN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	RubinSchwert = new ToolSword("rubinschwert", InitToolSets.RUBIN, MoreItemsMod.MoreItemsTab).addToRegistryList();
	
	//Armor
	SteinHelm = new ArmorSet("steinarmor_helmet", InitArmorSets.STEINARMOR, EntityEquipmentSlot.HEAD, MoreItemsMod.MoreItemsTab).addToRegistryList();
    SteinBrustplatte = new ArmorSet("steinarmor_chestplate", InitArmorSets.STEINARMOR, EntityEquipmentSlot.CHEST, MoreItemsMod.MoreItemsTab).addToRegistryList();
    SteinHose = new ArmorSet("steinarmor_leggings", InitArmorSets.STEINARMOR, EntityEquipmentSlot.LEGS, MoreItemsMod.MoreItemsTab).addToRegistryList();
    SteinSchuhe = new ArmorSet("steinarmor_boots", InitArmorSets.STEINARMOR, EntityEquipmentSlot.FEET, MoreItemsMod.MoreItemsTab).addToRegistryList();
    SmaragdHelm = new ArmorSet("smaragdarmor_helmet", InitArmorSets.SMARAGDARMOR, EntityEquipmentSlot.HEAD, MoreItemsMod.MoreItemsTab).addToRegistryList();
    SmaragdBrustplatte = new ArmorSet("smaragdarmor_chestplate", InitArmorSets.SMARAGDARMOR, EntityEquipmentSlot.CHEST, MoreItemsMod.MoreItemsTab).addToRegistryList();
    SmaragdHose = new ArmorSet("smaragdarmor_leggings", InitArmorSets.SMARAGDARMOR, EntityEquipmentSlot.LEGS, MoreItemsMod.MoreItemsTab).addToRegistryList();
    SmaragdSchuhe = new ArmorSet("smaragdarmor_boots", InitArmorSets.SMARAGDARMOR, EntityEquipmentSlot.FEET, MoreItemsMod.MoreItemsTab).addToRegistryList();
	ObsidianHelm = new ArmorSet("obsidianarmor_helmet", InitArmorSets.OBSIDIANARMOR, EntityEquipmentSlot.HEAD, MoreItemsMod.MoreItemsTab).addToRegistryList();
	ObsidianBrustplatte = new ArmorSet("obsidianarmor_chestplate", InitArmorSets.OBSIDIANARMOR, EntityEquipmentSlot.CHEST, MoreItemsMod.MoreItemsTab).addToRegistryList();
	ObsidianHose = new ArmorSet("obsidianarmor_leggings", InitArmorSets.OBSIDIANARMOR, EntityEquipmentSlot.LEGS, MoreItemsMod.MoreItemsTab).addToRegistryList();
	ObsidianSchuhe = new ArmorSet("obsidianarmor_boots", InitArmorSets.OBSIDIANARMOR, EntityEquipmentSlot.FEET, MoreItemsMod.MoreItemsTab).addToRegistryList();
	VerstaerkterDiamantHelm = new ArmorSet("verstaerktediamantarmor_helmet", InitArmorSets.VERSTAERKTEDIAMANTARMOR, EntityEquipmentSlot.HEAD, MoreItemsMod.MoreItemsTab).addToRegistryList();
	VerstaerkteDiamantBrustplatte = new ArmorSet("verstaerktediamantarmor_chestplate", InitArmorSets.VERSTAERKTEDIAMANTARMOR, EntityEquipmentSlot.CHEST, MoreItemsMod.MoreItemsTab).addToRegistryList();
	VerstaerkteDiamantHose = new ArmorSet("verstaerktediamantarmor_leggings", InitArmorSets.VERSTAERKTEDIAMANTARMOR, EntityEquipmentSlot.LEGS, MoreItemsMod.MoreItemsTab).addToRegistryList();
	VerstaerkteDiamantSchuhe = new ArmorSet("verstaerktediamantarmor_boots", InitArmorSets.VERSTAERKTEDIAMANTARMOR, EntityEquipmentSlot.FEET, MoreItemsMod.MoreItemsTab).addToRegistryList();
    SaphirHelm = new ArmorSet("saphirhelm", InitArmorSets.SAPHIRARMOR, EntityEquipmentSlot.HEAD, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SaphirBrustpanzer = new ArmorSet("saphirbrustpanzer", InitArmorSets.SAPHIRARMOR, EntityEquipmentSlot.CHEST, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SaphirHose = new ArmorSet("saphirhose", InitArmorSets.SAPHIRARMOR, EntityEquipmentSlot.LEGS, MoreItemsMod.MoreItemsTab).addToRegistryList();
	SaphirSchuhe = new ArmorSet("saphirschuhe", InitArmorSets.SAPHIRARMOR, EntityEquipmentSlot.FEET, MoreItemsMod.MoreItemsTab).addToRegistryList();
	RubinHelm = new ArmorSet("rubinhelm", InitArmorSets.RUBINARMOR, EntityEquipmentSlot.HEAD, MoreItemsMod.MoreItemsTab).addToRegistryList();	
    RubinBrustpanzer = new ArmorSet("rubinbrustpanzer", InitArmorSets.RUBINARMOR, EntityEquipmentSlot.CHEST, MoreItemsMod.MoreItemsTab).addToRegistryList();
	RubinHose = new ArmorSet("rubinhose", InitArmorSets.RUBINARMOR, EntityEquipmentSlot.LEGS, MoreItemsMod.MoreItemsTab).addToRegistryList();
	RubinSchuhe = new ArmorSet("rubinschuhe", InitArmorSets.RUBINARMOR, EntityEquipmentSlot.FEET, MoreItemsMod.MoreItemsTab).addToRegistryList();
	}

}