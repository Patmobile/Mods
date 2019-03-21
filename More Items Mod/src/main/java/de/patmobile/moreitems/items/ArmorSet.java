package de.patmobile.moreitems.items;

import de.patmobile.moreitems.Init.ItemInit;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemGroup;


public class ArmorSet extends ItemArmor {
    public ArmorSet(String Name, IArmorMaterial materialIn, EntityEquipmentSlot slots, ItemGroup group) {
        super(materialIn,slots,new Item.Properties().group(group));
        setRegistryName(Name);
    }

    public ArmorSet addToRegistryList(){
        ItemInit.itemsToRegister.add(this);
        return this;
    }
}