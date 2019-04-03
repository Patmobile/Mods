package de.patmobile.backpack.init;

import java.util.ArrayList;

import de.patmobile.backpack.BackpackMod;
import de.patmobile.backpack.enums.EnumRucksack;
import de.patmobile.backpack.items.ItemRucksack;
import net.minecraft.item.Item;

@net.minecraftforge.registries.ObjectHolder("backpack:items")
public class ItemInit 
{
	
	public static ArrayList<Item> itemsToRegister = new ArrayList<>();
	
	//Kleiner Rucksack
	public static Item KleinerWeisserRucksack, KleinerOrangenerRucksack, KleinerMagentaRucksack, KleinerHellblauerRucksack, 
	KleinerGelberRucksack, KleinerHellgruenerRucksack, KleinerRosanerRucksack, KleinerGrauerRucksack, KleinerHellgrauerRucksack, 
	KleinerTuerkiserRucksack, KleinerVioletterRucksack, KleinerBlauerRucksack, KleinerBraunerRucksack, KleinerGruenerRucksack, 
	KleinerRoterRucksack, KleinerSchwarzerRucksack;
	//Grosser Rucksack
	public static Item GrosserWeisserRucksack, GrosserOrangenerRucksack, GrosserMagentaRucksack, GrosserHellblauerRucksack,
	GrosserGelberRucksack, GrosserHellgruenerRucksack, GrosserRosanerRucksack, GrosserGrauerRucksack, GrosserHellgrauerRucksack,
	GrosserTuerkiserRucksack, GrosserVioletterRucksack, GrosserBlauerRucksack, GrosserBraunerRucksack, GrosserGruenerRucksack,
	GrosserRoterRucksack, GrosserSchwarzerRucksack;
	
	public static void initItems() {
	//Kleiner Rucksack
		KleinerWeisserRucksack = new ItemRucksack("kleinerweisserrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerOrangenerRucksack = new ItemRucksack("kleinerorangenerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerMagentaRucksack = new ItemRucksack("kleinermagentarucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerHellblauerRucksack = new ItemRucksack("kleinerhellblauerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerGelberRucksack = new ItemRucksack("kleinergelberrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerHellgruenerRucksack = new ItemRucksack("kleinerhellgruenerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerRosanerRucksack = new ItemRucksack("kleinerrosanerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerGrauerRucksack = new ItemRucksack("kleinergrauerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerHellgrauerRucksack = new ItemRucksack("kleinerhellgrauerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerTuerkiserRucksack = new ItemRucksack("kleinertuerkiserrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerVioletterRucksack = new ItemRucksack("kleinervioletterrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerBlauerRucksack = new ItemRucksack("kleinerblauerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerBraunerRucksack = new ItemRucksack("kleinerbraunerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerGruenerRucksack = new ItemRucksack("kleinergruenerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerRoterRucksack = new ItemRucksack("kleinerroterrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
		KleinerSchwarzerRucksack = new ItemRucksack("kleinerschwarzerrucksack", BackpackMod.BackpackTab, EnumRucksack.KLEIN).addToRegistryList();
	
	//Grosser Rucksack
		GrosserWeisserRucksack = new ItemRucksack("grosserweisserrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserOrangenerRucksack = new ItemRucksack("grosserorangenerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserMagentaRucksack = new ItemRucksack("grossermagentarucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserHellblauerRucksack = new ItemRucksack("grosserhellblauerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserGelberRucksack = new ItemRucksack("grossergelberrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserHellgruenerRucksack = new ItemRucksack("grosserhellgruenerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserRosanerRucksack = new ItemRucksack("grosserrosanerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserGrauerRucksack = new ItemRucksack("grossergrauerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserHellgrauerRucksack = new ItemRucksack("grosserhellgrauerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserTuerkiserRucksack = new ItemRucksack("grossertuerkiserrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserVioletterRucksack = new ItemRucksack("grosservioletterrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserBlauerRucksack = new ItemRucksack("grosserblauerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserBraunerRucksack = new ItemRucksack("grosserbraunerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserGruenerRucksack = new ItemRucksack("grossergruenerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserRoterRucksack = new ItemRucksack("grosserroterrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
		GrosserSchwarzerRucksack = new ItemRucksack("grosserschwarzerrucksack", BackpackMod.BackpackTab, EnumRucksack.GROSS).addToRegistryList();
	
	}

}