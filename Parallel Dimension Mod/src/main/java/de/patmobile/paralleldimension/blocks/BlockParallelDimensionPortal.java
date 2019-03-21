package de.patmobile.paralleldimension.blocks;




import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.cache.LoadingCache;

import de.patmobile.paralleldimension.dimension.ParallelDimensionTeleportManager;
import de.patmobile.paralleldimension.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;



public class BlockParallelDimensionPortal extends BlockPortal {
	
	public static final EnumProperty<EnumFacing.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
	 

    private ItemGroup itemGroup;

	public BlockParallelDimensionPortal(String Name, ItemGroup group) {
		
		super(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().needsRandomTick().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).lightValue(11));
        this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, EnumFacing.Axis.X));
        this.setRegistryName(Name);
        itemGroup=group;
		
		
	}
	
	public BlockParallelDimensionPortal addToBlockAndItemBlockRegistryList(){
    	BlockInit.blockRegistryList.add(this);
    	BlockInit.itemBlocksRegistryList.add(new ItemBlock(this,new Item.Properties().group(getItemGroup())));
        return this;
    }

    public ItemGroup getItemGroup(){
        return itemGroup;
   }
	
	
    @Override
    public void tick(IBlockState state, World worldIn, BlockPos pos, Random rand)
    {
        super.tick(state,worldIn,pos,rand);

    

    }

   

    @Override
    public VoxelShape getCollisionShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        switch((EnumFacing.Axis)state.get(AXIS)) {
            case Z:
                return Z_AABB;
            case X:
            default:
                return X_AABB;
        }
    }

    @Nullable
    public BlockParallelDimensionPortal.Size isPortal1(IWorld p_201816_1_, BlockPos p_201816_2_) {
    	BlockParallelDimensionPortal.Size blockportal$size = new BlockParallelDimensionPortal.Size(p_201816_1_, p_201816_2_, EnumFacing.Axis.X);
        if (blockportal$size.isValid() && blockportal$size.portalBlockCount == 0) {
            return blockportal$size;
        } else {
        	BlockParallelDimensionPortal.Size blockportal$size1 = new BlockParallelDimensionPortal.Size(p_201816_1_, p_201816_2_, EnumFacing.Axis.Z);
            return blockportal$size1.isValid() && blockportal$size1.portalBlockCount == 0 ? blockportal$size1 : null;
        }
    }
    

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        EnumFacing.Axis enumfacing$axis = facing.getAxis();
        EnumFacing.Axis enumfacing$axis1 = stateIn.get(AXIS);
        boolean flag = enumfacing$axis1 != enumfacing$axis && enumfacing$axis.isHorizontal();
        return !flag && facingState.getBlock() != this && !(new BlockParallelDimensionPortal.Size(worldIn, currentPos, enumfacing$axis1)).func_208508_f() ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean trySpawnPortal(IWorld worldIn, BlockPos pos) {
    	BlockParallelDimensionPortal.Size blockportal$size = this.isPortal1(worldIn, pos);
        if (blockportal$size != null) {
            blockportal$size.placePortalBlocks();
            return true;
        } else {
            return false;
        }
    }
    


 

    @Override
    public int quantityDropped(IBlockState state, Random random) {
        return 0;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public void onEntityCollision(IBlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn!=null) {
            if(entityIn instanceof EntityPlayerMP){
                ParallelDimensionTeleportManager.tele((EntityPlayerMP)entityIn);
            }else{
            	ParallelDimensionTeleportManager.teleEntity(entityIn);
            }
        }
              
    }

    @Override
    public IBlockState rotate(IBlockState state, Rotation rot) {
        switch(rot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch((EnumFacing.Axis)state.get(AXIS)) {
                    case Z:
                        return state.with(AXIS, EnumFacing.Axis.X);
                    case X:
                        return state.with(AXIS, EnumFacing.Axis.Z);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public BlockPattern.PatternHelper createPatternHelper(IWorld worldIn, BlockPos p_181089_2_) {
        EnumFacing.Axis enumfacing$axis = EnumFacing.Axis.Z;
        BlockParallelDimensionPortal.Size blockportal$size = new BlockParallelDimensionPortal.Size(worldIn, p_181089_2_, EnumFacing.Axis.X);
        LoadingCache<BlockPos, BlockWorldState> loadingcache = BlockPattern.createLoadingCache(worldIn, true);
        if (!blockportal$size.isValid()) {
            enumfacing$axis = EnumFacing.Axis.X;
            blockportal$size = new BlockParallelDimensionPortal.Size(worldIn, p_181089_2_, EnumFacing.Axis.Z);
        }

        if (!blockportal$size.isValid()) {
            return new BlockPattern.PatternHelper(p_181089_2_, EnumFacing.NORTH, EnumFacing.UP, loadingcache, 1, 1, 1);
        } else {
            int[] aint = new int[EnumFacing.AxisDirection.values().length];
            EnumFacing enumfacing = blockportal$size.rightDir.rotateYCCW();
            BlockPos blockpos = blockportal$size.bottomLeft.up(blockportal$size.getHeight() - 1);

            for(EnumFacing.AxisDirection enumfacing$axisdirection : EnumFacing.AxisDirection.values()) {
                BlockPattern.PatternHelper blockpattern$patternhelper = new BlockPattern.PatternHelper(enumfacing.getAxisDirection() == enumfacing$axisdirection ? blockpos : blockpos.offset(blockportal$size.rightDir, blockportal$size.getWidth() - 1), EnumFacing.getFacingFromAxis(enumfacing$axisdirection, enumfacing$axis), EnumFacing.UP, loadingcache, blockportal$size.getWidth(), blockportal$size.getHeight(), 1);

                for(int i = 0; i < blockportal$size.getWidth(); ++i) {
                    for(int j = 0; j < blockportal$size.getHeight(); ++j) {
                        BlockWorldState blockworldstate = blockpattern$patternhelper.translateOffset(i, j, 1);
                        if (!blockworldstate.getBlockState().isAir()) {
                            ++aint[enumfacing$axisdirection.ordinal()];
                        }
                    }
                }
            }

            EnumFacing.AxisDirection enumfacing$axisdirection1 = EnumFacing.AxisDirection.POSITIVE;

            for(EnumFacing.AxisDirection enumfacing$axisdirection2 : EnumFacing.AxisDirection.values()) {
                if (aint[enumfacing$axisdirection2.ordinal()] < aint[enumfacing$axisdirection1.ordinal()]) {
                    enumfacing$axisdirection1 = enumfacing$axisdirection2;
                }
            }

            return new BlockPattern.PatternHelper(enumfacing.getAxisDirection() == enumfacing$axisdirection1 ? blockpos : blockpos.offset(blockportal$size.rightDir, blockportal$size.getWidth() - 1), EnumFacing.getFacingFromAxis(enumfacing$axisdirection1, enumfacing$axis), EnumFacing.UP, loadingcache, blockportal$size.getWidth(), blockportal$size.getHeight(), 1);
        }
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    public static class Size{
        private final IWorld world;
        private final EnumFacing.Axis axis;
        private final EnumFacing rightDir;
        private final EnumFacing leftDir;
        private int portalBlockCount;
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public Size(IWorld p_i48740_1_, BlockPos p_i48740_2_, EnumFacing.Axis p_i48740_3_) {
            this.world = p_i48740_1_;
            this.axis = p_i48740_3_;
            if (p_i48740_3_ == EnumFacing.Axis.X) {
                this.leftDir = EnumFacing.EAST;
                this.rightDir = EnumFacing.WEST;
            } else {
                this.leftDir = EnumFacing.NORTH;
                this.rightDir = EnumFacing.SOUTH;
            }

            for(BlockPos blockpos = p_i48740_2_; p_i48740_2_.getY() > blockpos.getY() - 21 && p_i48740_2_.getY() > 0 && this.func_196900_a(p_i48740_1_.getBlockState(p_i48740_2_.down())); p_i48740_2_ = p_i48740_2_.down()) {
                ;
            }

            int i = this.getDistanceUntilEdge(p_i48740_2_, this.leftDir) - 1;
            if (i >= 0) {
                this.bottomLeft = p_i48740_2_.offset(this.leftDir, i);
                this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
                if (this.width < 2 || this.width > 21) {
                    this.bottomLeft = null;
                    this.width = 0;
                }
            }

            if (this.bottomLeft != null) {
                this.height = this.calculatePortalHeight();
            }

        }

        protected int getDistanceUntilEdge(BlockPos p_180120_1_, EnumFacing p_180120_2_) {
            int i;
            for(i = 0; i < 22; ++i) {
                BlockPos blockpos = p_180120_1_.offset(p_180120_2_, i);
                if (!world.isAirBlock(blockpos) || this.world.getBlockState(blockpos.down()).getBlock() != Blocks.OBSIDIAN) {
                    break;
                }
            }

            Block block = this.world.getBlockState(p_180120_1_.offset(p_180120_2_, i)).getBlock();
            return block == Blocks.OBSIDIAN ? i : 0;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        protected int calculatePortalHeight() {
            label56:
            for(this.height = 0; this.height < 21; ++this.height) {
                for(int i = 0; i < this.width; ++i) {
                    BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
                    IBlockState iblockstate = this.world.getBlockState(blockpos);
                    if (!this.func_196900_a(iblockstate)) {
                        break label56;
                    }

                    Block block = iblockstate.getBlock();
                    if (block == BlockInit.ParallelDimensionPortal) {
                        ++this.portalBlockCount;
                    }

                    if (i == 0) {
                        block = this.world.getBlockState(blockpos.offset(this.leftDir)).getBlock();
                        if (block != Blocks.OBSIDIAN) {
                            break label56;
                        }
                    } else if (i == this.width - 1) {
                        block = this.world.getBlockState(blockpos.offset(this.rightDir)).getBlock();
                        if (block != Blocks.OBSIDIAN) {
                            break label56;
                        }
                    }
                }
            }

            for(int j = 0; j < this.width; ++j) {
                if (this.world.getBlockState(this.bottomLeft.offset(this.rightDir, j).up(this.height)).getBlock() != Blocks.OBSIDIAN) {
                    this.height = 0;
                    break;
                }
            }

            if (this.height <= 21 && this.height >= 3) {
                return this.height;
            } else {
                this.bottomLeft = null;
                this.width = 0;
                this.height = 0;
                return 0;
            }
        }


		protected boolean func_196900_a(IBlockState p_196900_1_) {
            Block blockIn = p_196900_1_.getBlock();
            return blockIn.getMaterial(blockIn.getDefaultState()) == Material.AIR || blockIn == BlockInit.HoellenFeuer || blockIn == BlockInit.ParallelDimensionPortal;
        }

        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        public void placePortalBlocks() {
            for(int i = 0; i < this.width; ++i) {
                BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i);

                for(int j = 0; j < this.height; ++j) {
                    this.world.setBlockState(blockpos.up(j), BlockInit.ParallelDimensionPortal.getDefaultState().with(BlockPortal.AXIS, this.axis), 18);
                }
            }

        }

        private boolean func_196899_f() {
            return this.portalBlockCount >= this.width * this.height;
        }

        public boolean func_208508_f() {
            return this.isValid() && this.func_196899_f();
        }
}
	
	  


}