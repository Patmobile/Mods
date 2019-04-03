package de.patmobile.moreitems.items;


import de.patmobile.moreitems.ModConfig;
import de.patmobile.moreitems.Init.ItemInitMI;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword {
	
    public ToolSword(String Name, IItemTier tier, ItemGroup group) {
        super(tier, 3+(int)tier.getAttackDamage(),1,new Item.Properties().group(group).maxStackSize(1));
        setRegistryName(ModConfig.MODID,Name);
    }

    public ToolSword addToRegistryList(){
    	ItemInitMI.itemsToRegister.add(this);
        return this;
    }
}