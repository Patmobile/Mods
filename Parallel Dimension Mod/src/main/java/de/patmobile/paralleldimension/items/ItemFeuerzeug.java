package de.patmobile.paralleldimension.items;

import de.patmobile.paralleldimension.ParallelDimensionMod;
import de.patmobile.paralleldimension.blocks.BlockParallelDimensionPortal;
import de.patmobile.paralleldimension.init.BlockInit;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;


public class ItemFeuerzeug extends UItemFeuerzeug {
	
	public ItemFeuerzeug(String name) {
		super(name, ParallelDimensionMod.ParallelDimensionTab, new Properties().defaultMaxDamage(128));
	}

	
	
	/* public EnumActionResult onItemUse(ItemUseContext p_195939_1_) {
	      EntityPlayer entityplayer = p_195939_1_.getPlayer();
	      IWorld iworld = p_195939_1_.getWorld();
	      BlockPos blockpos = p_195939_1_.getPos().offset(p_195939_1_.getFace());
	      if (canIgnite(iworld, blockpos)) {
	         iworld.playSound(entityplayer, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
	         IBlockState iblockstate = ((BlockFeuer)BlockInit.HoellenFeuer).getStateForPlacement(iworld, blockpos);
	         iworld.setBlockState(blockpos, iblockstate, 11);
	         ItemStack itemstack = p_195939_1_.getItem();
	         if (entityplayer instanceof EntityPlayerMP) {
	            CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)entityplayer, blockpos, itemstack);
	         }

	         if (entityplayer != null) {
	            itemstack.damageItem(1, entityplayer);
	         }

	         return EnumActionResult.SUCCESS;
	      } else {
	         return EnumActionResult.FAIL;
	      }
	   }*/
	 
    @Override
    public EnumActionResult onItemUse(ItemUseContext context)
    {
    	EntityPlayer entityplayer = context.getPlayer();
    	
        if(!context.getWorld().isRemote) {
            if(((BlockParallelDimensionPortal)BlockInit.ParallelDimensionPortal).trySpawnPortal(context.getWorld(), context.getPos().up()))  {
                ItemStack itemstack = context.getItem();
                if (entityplayer != null) {
    	            itemstack.damageItem(1, entityplayer);
    	         }
            }
        }
        return EnumActionResult.SUCCESS;
}
	}
	 
	 
	/* public static boolean canIgnite(IWorld p_201825_0_, BlockPos p_201825_1_) {
	      IBlockState iblockstate = ((BlockFeuer)BlockInit.HoellenFeuer).getStateForPlacement(p_201825_0_, p_201825_1_);
	      boolean flag = false;

	      for(EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
	         if (p_201825_0_.getBlockState(p_201825_1_.offset(enumfacing)).getBlock() == Blocks.OBSIDIAN && ((BlockParallelDimensionPortal)BlockInit.ParallelDimensionPortal).isPortal(p_201825_0_, p_201825_1_) != null) {
	            flag = true;
	         }
	      }

	      return p_201825_0_.isAirBlock(p_201825_1_) && (iblockstate.isValidPosition(p_201825_0_, p_201825_1_) || flag);
	   }*/
	 

