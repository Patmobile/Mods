package de.patmobile.backpack.items;

import de.patmobile.backpack.ModConfig;
import de.patmobile.backpack.container.InteractionObjectRucksack;
import de.patmobile.backpack.enums.EnumRucksack;
import de.patmobile.backpack.init.ItemInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ItemRucksack extends Item {

    protected String name;
    private final EnumRucksack type;
    protected boolean modded_Has_Effect=false;
    
    
    public ItemRucksack(String name, ItemGroup group, EnumRucksack type) {
        super(new Item.Properties().group(group));
        this.name = name;
        this.type = type;
        setRegistryName(new ResourceLocation(ModConfig.MODID,name));
    }

  

    public ItemRucksack setHasEffect(boolean hasORnot){
        modded_Has_Effect=hasORnot;
        return this;
    }

    public ItemRucksack addToRegistryList(){
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

	public EnumRucksack getType() {
		return type;
   }

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (!world.isRemote && player instanceof EntityPlayerMP) {
			EntityPlayerMP playermp = (EntityPlayerMP) player;
			NetworkHooks.openGui(playermp, new InteractionObjectRucksack(stack, type), buffer -> buffer.writeEnumValue(hand));
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return !ItemStack.areItemsEqual(oldStack, newStack);
     }
}