package de.patmobile.moreitems.items;

import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

import java.util.Set;

import de.patmobile.moreitems.ModConfig;
import de.patmobile.moreitems.Init.ItemInit;

public class MoreItemsTool extends ItemTool {

    protected MoreItemsTool(String Name, IItemTier tier, Set<Block> effectiveBlocksIn, Item.Properties properties) {
        super(tier.getAttackDamage(),1,tier,effectiveBlocksIn,properties);
        setRegistryName(ModConfig.MODID,Name);
    }

    public Item addToRegistryList(){
        ItemInit.itemsToRegister.add(this);
        return this;
    }
}