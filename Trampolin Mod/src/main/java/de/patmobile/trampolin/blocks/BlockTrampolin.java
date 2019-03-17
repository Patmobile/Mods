package de.patmobile.trampolin.blocks;

import de.patmobile.trampolin.TrampolinMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockTrampolin extends UBlock {
	
	public static final BooleanProperty BACK = BooleanProperty.create("back");
	public static final BooleanProperty FORWARD = BooleanProperty.create("forward");
	public static final BooleanProperty LEFT = BooleanProperty.create("left");
	public static final BooleanProperty RIGHT = BooleanProperty.create("right");
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 13 * 0.0625, 1.0);
	
	   protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D);
	
	
	public BlockTrampolin(String name) {
		super(name, TrampolinMod.TrampolinTab, Properties.create(Material.ROCK).hardnessAndResistance(2F).sound(SoundType.METAL));
		this.setDefaultState(this.stateContainer.getBaseState().with(BACK, false).with(FORWARD, false).with(LEFT, false).with(RIGHT, false));
	}
	
	
	 public boolean isBlockNormalCube(IBlockState state) {
	        return false;
	}
	 

	


	
	/* @Override
	 public boolean isOpaqueCube(IBlockState state) {
		 return false;
		 }*/
	 


	@Override
	public boolean isFullCube(final IBlockState state) {
		return false;
}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, World source, BlockPos pos) 
	{
		return BOUNDING_BOX;
	}
	
	  public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
	      return SHAPE;
	   }
	  
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
	      return EnumBlockRenderType.MODEL;
	   }
	
	
	
	/*@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_) 
	{
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}*/
	
	@Override
	public void onLanded(IBlockReader worldIn, Entity entityIn) {
		
		
	}
	
	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) 
	{
		if(entityIn instanceof EntityLivingBase)
		{
			float height = entityIn.fallDistance;
			if(height > 0 && !entityIn.isSneaking()) 
			{
				if(height > 9) height = 9;
				entityIn.motionY = 0;
				entityIn.addVelocity(0, getRequiredVelocity(height + 1), 0);
				worldIn.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.BLOCK_ANVIL_FALL, SoundCategory.BLOCKS, 0.75F, 1.0F, false);
				if(worldIn.isRemote)
				{
					for(int i = 0; i < 5; i++)
					{
						double offsetX = -0.1 + 0.2 * RANDOM.nextDouble();
						double offsetZ = -0.1 + 0.2 * RANDOM.nextDouble();
						//worldIn.spawnParticle(, entityIn.posX, entityIn.posY, entityIn.posZ, 1, 1, 1, 0);
					}
				}
			}
			entityIn.fallDistance = 0;
		}
	}
	
	public double getRequiredVelocity(float height)
	{
		return Math.sqrt(0.22 * height);
	}
	
	@Override
	public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
	{
		boolean forward = worldIn.getBlockState(currentPos.north()).getBlock() == this;
		boolean back = worldIn.getBlockState(currentPos.south()).getBlock() == this;
		boolean left = worldIn.getBlockState(currentPos.west()).getBlock() == this;
		boolean right = worldIn.getBlockState(currentPos.east()).getBlock() == this;
		return stateIn.with(BACK, back).with(FORWARD, forward).with(LEFT, left).with(RIGHT, right);
	}
	
	/*@Override
	public int getMetaFromState(IBlockState state)
	{
		return 0;
	}*/
	
	 public IBlockState getStateForPlacement(BlockItemUseContext context) {
	        return this.getDefaultState();
	    }
	
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(BACK, FORWARD, LEFT, RIGHT);
      }
     
    @Override
    @OnlyIn(Dist.CLIENT)
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.CUTOUT;
    }
}