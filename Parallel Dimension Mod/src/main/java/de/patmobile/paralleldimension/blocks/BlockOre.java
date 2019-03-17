package de.patmobile.paralleldimension.blocks;


import de.patmobile.paralleldimension.ParallelDimensionMod;
import de.patmobile.paralleldimension.helper.HarvestLevelHelper;
import de.patmobile.paralleldimension.init.BlockInit;
import de.patmobile.paralleldimension.init.ItemInit;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockOre extends UBlockOre {
	
	 public final HarvestLevelHelper resource;
	 
	public BlockOre(String name, HarvestLevelHelper resource) {
		super(name, ParallelDimensionMod.ParallelDimensionTab, Properties.create(Material.IRON).hardnessAndResistance(3F, 3F).sound(SoundType.STONE), new Item.Properties().rarity(EnumRarity.COMMON));
		
		

        this.resource = resource;
	}
	
	 public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
		 
		 
		 
		 IItemProvider item = Items.ARROW;
		 
		  if (this == BlockInit.Saphirerz) {
			  item = ItemInit.Saphir;
		         
		      } else if (this == BlockInit.Rubinerz) {
		    	  item = ItemInit.Rubin;
	        }
		return item;
	
	
	 }
	 
	    @Override
	    public ToolType getHarvestTool(IBlockState state) {
	        return ToolType.PICKAXE;
	    }

	    @Override
	    public int getHarvestLevel(IBlockState state) {
	        return resource.harvestLevel;
	}
	    
	
	 @Override
	   public int getExpDrop(IBlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune) {
	      World world = reader instanceof World ? (World)reader : null;
	      if (world == null || this.getItemDropped(state, world, pos, fortune) != this) {
	         int i = 0;
	         if (this == BlockInit.Rubinerz) {
	            i = MathHelper.nextInt(RANDOM, 3, 7);
	         } else if (this == BlockInit.Saphirerz) {
	            i = MathHelper.nextInt(RANDOM, 3, 6);
	         }
	         return i;
	      }
	      return 0;
	   }
	 



}