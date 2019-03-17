package de.patmobile.paralleldimension.items;

import de.patmobile.paralleldimension.ParallelDimensionMod;
import de.patmobile.paralleldimension.blocks.BlockParallelDimensionPortal;
import de.patmobile.paralleldimension.init.BlockInit;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;

public class ItemStandard extends UItem {
	
	public ItemStandard(String name) {
		super(name, ParallelDimensionMod.ParallelDimensionTab, new Properties().maxStackSize(64));
	}
	
	

    @Override
    public EnumActionResult onItemUse(ItemUseContext context)
    {
        if(!context.getWorld().isRemote) {
            if(((BlockParallelDimensionPortal)BlockInit.ParallelDimensionPortal).trySpawnPortal(context.getWorld(), context.getPos().up()))  {
                ItemStack itemstack = context.getItem();
                itemstack.shrink(1);
            }
        }
        return EnumActionResult.SUCCESS;
}
	

}