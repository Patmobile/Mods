package de.patmobile.paralleldimension.items;

import de.patmobile.paralleldimension.ModConfig;
import de.patmobile.paralleldimension.init.ItemInit;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ResourceLocation;


public class ItemStandard extends Item {

    protected String name;
    protected boolean modded_Has_Effect=false;
    
    
    public ItemStandard(String name, ItemGroup group) {
        super(new Item.Properties().group(group));
        this.name = name;
        setRegistryName(new ResourceLocation(ModConfig.MODID,name));
    }

    public ItemStandard(String Name,Item.Properties properties){
        super(properties);
        this.name=Name;
        setRegistryName(new ResourceLocation(ModConfig.MODID,Name));
    }

    public ItemStandard(String name, ItemGroup group,EnumRarity rarity) {
        super(new Item.Properties().group(group).rarity(rarity));
        this.name = name;
        setRegistryName(new ResourceLocation(ModConfig.MODID,name));
    }
    
    public ItemStandard(String name, ItemGroup group, int maxdamage) {
        super(new Item.Properties().group(group).defaultMaxDamage(maxdamage));
        this.name = name;
        setRegistryName(new ResourceLocation(ModConfig.MODID,name));
    }


    public ItemStandard setHasEffect(boolean hasORnot){
        modded_Has_Effect=hasORnot;
        return this;
    }

    public ItemStandard addToRegistryList(){
        ItemInit.itemsToRegister.add(this);
        return this;
    }

    //this function is not available anymore
    //TODO add items from this method as fuel
    public int getItemBurnTime(ItemStack fuel) {
        /*if (fuel.getItem() == Kathairis.CrystalBlend){
            return 600;
        }else {
            return 0;
        }*/
        return 0;
    }


    @Override
    public EnumActionResult onItemUse(ItemUseContext p_195939_1_)
    {
        return EnumActionResult.PASS;
        /*if(this==Kathairis.MysticGem){
            if(!worldIn.isRemote) {
                if(Kathairis.MysticPortal.trySpawnPortal(worldIn, pos.up())) {
                    ItemStack itemstack = player.getHeldItem(hand);
                    itemstack.shrink(1);
                }
            }
            return EnumActionResult.SUCCESS;
        }
        else if(this==Kathairis.PotWithLivingFlower){
            if(!worldIn.isRemote) {
                EntityLivingFlower elv = new EntityLivingFlower(worldIn);
                elv.setPosition(pos.getX()+0.5, pos.getY()+1, pos.getZ()+0.5);
                elv.deallowDespawning();
                worldIn.spawnEntity(elv);
                ItemStack itemstack = player.getHeldItem(hand);
                itemstack.shrink(1);
                player.addItemStackToInventory(new ItemStack(Items.FLOWER_POT,1));
            }
            return EnumActionResult.SUCCESS;
        }else
            return EnumActionResult.PASS;*/
}
}