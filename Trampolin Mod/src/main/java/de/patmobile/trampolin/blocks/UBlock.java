package de.patmobile.trampolin.blocks;


import de.patmobile.trampolin.registry.IUBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.*;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class UBlock extends Block implements IUBlock {
	
	protected final String name;
	
	protected final ItemBlock itemblock;
	
	public UBlock(String name, Properties properties) {
		this(name, null, properties);
	}
	
	public UBlock(String name, ItemGroup group, Properties properties) {
		this(name, group, properties, null);
	}
	
	public UBlock(String name, Properties properties, Item.Properties itemblockproperties) {
		this(name, null, properties, itemblockproperties);
	}
	
	public UBlock(String name, ItemGroup group, Properties properties, Item.Properties itemblockproperties) {
		super(properties);
		this.name = name;
		itemblock = createItemBlock(itemblockproperties == null ? new Item.Properties().group(group) : group == null ? itemblockproperties : itemblockproperties.group(group));
	}
	
	protected ItemBlock createItemBlock(Item.Properties itemblockproperties) {
		return new ItemBlock(this, itemblockproperties);
	}
	
	@Override
	public String getEntryName() {
		return name;
	}
	
	@Override
	public ItemBlock getItemBlock() {
		return itemblock;
	}
  
	@Override
	public boolean isFullCube(final IBlockState state) {
		return false;
    }
	
	@Override
	 public boolean isBlockNormalCube(IBlockState state) {
	        return false;
	}
	 
	 
	 @Override
		public boolean propagatesSkylightDown(IBlockState state, IBlockReader reader, BlockPos pos) {
		      return true;
		   }
	 
       @Override
	   @OnlyIn(Dist.CLIENT)
		public BlockRenderLayer getRenderLayer()
		{
			return BlockRenderLayer.CUTOUT;
	    }
       
       
       @Override
       public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
   	{
   		return stateIn;
   	}
	
}