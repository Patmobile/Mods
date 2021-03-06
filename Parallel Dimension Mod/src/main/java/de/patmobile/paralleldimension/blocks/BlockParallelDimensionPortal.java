package de.patmobile.paralleldimension.blocks;

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

import javax.annotation.Nullable;
import java.util.Random;

public class BlockParallelDimensionPortal extends BlockPortal
{
    public static final EnumProperty<EnumFacing.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    private ItemGroup itemGroup;

    public BlockParallelDimensionPortal(String Name,ItemGroup group)
    {
        super(Block.Properties.create(Material.PORTAL).needsRandomTick().hardnessAndResistance(-1,-1).doesNotBlockMovement().lightValue(1).sound(SoundType.GLASS));
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

        /*if(worldIn.dimension.getDimension()==KCore.DIMENSION_ID) {
            List<EntityStrangeWanderer> e = worldIn.getEntitiesWithinAABB(EntityStrangeWanderer.class, new AxisAlignedBB(pos.getX() - 15, pos.getY() - 15, pos.getZ() - 15, pos.getX()  + 15, pos.getY() + 15, pos.getZ() + 15));
            if(e.size()==0) {
                if(!worldIn.isRemote) {
                    int X=pos.getX()+rand.nextInt(4)-rand.nextInt(4);
                    int Y=pos.getY();
                    int Z = pos.getZ()+rand.nextInt(4)-rand.nextInt(4);
                    if(worldIn.isAirBlock(new BlockPos(X,Y,Z))&&worldIn.isAirBlock(new BlockPos(X,Y,Z).up())) {
                        EntityStrangeWanderer esw = new EntityStrangeWanderer(worldIn);
                        esw.setPosition(X,Y,Z);
                        worldIn.spawnEntity(esw);
                    }
                }
            }
        }
        if(ModConfig.shouldBlocksSpreadAroundPortal) {
            for (int x = 0; x < 1 + rand.nextInt(4); x++) {
                updateBlocksAroundPortal(worldIn, pos, state, rand);
            }
        }*/

    }

    /*private IBlockState pickUpRandomFlowerStateForKether(Random random) {
        IBlockState[] flowers = {KCore.MysticMiniGrass.getDefaultState(),KCore.MysticTallGrass.getDefaultState(),KCore.MysticNightFlower.getDefaultState(),
                KCore.ButterflyFlower.getDefaultState(),KCore.MysticFlower.getDefaultState(),KCore.MysticFungus.getDefaultState(),
                KCore.MysticMiniGrass.getDefaultState(),KCore.MysticTallGrass.getDefaultState(),KCore.MysticMiniGrass.getDefaultState(),KCore.MysticTallGrass.getDefaultState(),
                KCore.MysticMiniGrass.getDefaultState(),KCore.MysticTallGrass.getDefaultState(),KCore.MysticMiniGrass.getDefaultState(),KCore.MysticTallGrass.getDefaultState(),
                KCore.MysticMiniGrass.getDefaultState(),KCore.MysticTallGrass.getDefaultState(),KCore.MysticMiniGrass.getDefaultState(),KCore.MysticTallGrass.getDefaultState(),
                KCore.MysticSapling.getDefaultState(),KCore.EyePlant.getDefaultState(),KCore.MagicBeans.getDefaultState(),KCore.GooseberryBlock.getDefaultState(),
                KCore.SteppedSucculent.getDefaultState()
        };
        return flowers[random.nextInt(flowers.length)];
    }*/

   /* private IBlockState pickUpRandomFlowerState(Random random) {
        ArrayList<IBlockState> flowers = new ArrayList<IBlockState>();
        for (BlockFlower.EnumFlowerType type : BlockFlower.EnumFlowerType.values())
        {
            if (type.getBlockType() == BlockFlower.EnumFlowerColor.YELLOW) continue;
            if (type == BlockFlower.EnumFlowerType.BLUE_ORCHID) type = BlockFlower.EnumFlowerType.POPPY;
            flowers.add(net.minecraft.init.Blocks.RED_FLOWER.getDefaultState().withProperty(net.minecraft.init.Blocks.RED_FLOWER.getTypeProperty(), type));
        }
        for(int x=0;x<=10;x++) {
            flowers.add(Blocks.TALLGRASS.getDefaultState());
        }
        return flowers.get(RANDOM.nextInt(flowers.size()));
    }*/


    /*private void updateBlocksAroundPortal(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if(worldIn.provider.getDimension()==KCore.DIMENSION_ID) {
            int radius=5;
            int shiftX=+rand.nextInt(radius+1)-rand.nextInt(radius+1);
            int shiftY=-rand.nextInt(radius+1)+rand.nextInt(radius+1);
            int shiftZ=+rand.nextInt(radius+1)-rand.nextInt(radius+1);
            int randomX=pos.getX()+shiftX;
            int randomY=pos.getY()+shiftY;
            int randomZ=pos.getZ()+shiftZ;
            if((MathHelper.abs(randomX-pos.getX())*MathHelper.abs(randomX-pos.getX()))+
                    (MathHelper.abs(randomZ-pos.getZ())*MathHelper.abs(randomZ-pos.getZ()))<=radius*radius) {
                BlockPos tmp = new BlockPos(randomX,randomY,randomZ);
                if(worldIn.getBlockState(tmp)==KCore.KatharianGrass.getDefaultState()) {
                    worldIn.setBlockState(tmp, Blocks.GRASS.getDefaultState(),2);
                }
                if(worldIn.getBlockState(tmp)==KCore.KatharianDirt.getDefaultState()) {
                    worldIn.setBlockState(tmp, Blocks.DIRT.getDefaultState(),2);
                }
                if(worldIn.getBlockState(tmp)==KCore.MythicStone.getDefaultState()) {
                    worldIn.setBlockState(tmp, Blocks.OBSIDIAN.getDefaultState(),2);
                }
                if(worldIn.getBlockState(tmp)==KCore.ForgottenSand.getDefaultState()) {
                    worldIn.setBlockState(tmp, Blocks.SAND.getDefaultState(),2);
                }
                if(worldIn.getBlockState(tmp)==Blocks.GRASS.getDefaultState()&&worldIn.getBlockState(tmp.up())==Blocks.AIR.getDefaultState()) {
                    worldIn.setBlockState(tmp.up(), pickUpRandomFlowerState(rand),2);
                }
            }
            if(rand.nextInt(2)==0) {
                this.updateBlocksAroundPortal(worldIn, pos, state, rand);
            }
        }else {
            int radius=5;
            int randomX=pos.getX()+rand.nextInt(radius+1)-rand.nextInt(radius+1);
            int randomY=pos.getY()-rand.nextInt(radius+1)+rand.nextInt(radius+1);
            int randomZ=pos.getZ()+rand.nextInt(radius+1)-rand.nextInt(radius+1);
            BlockPos tmp = new BlockPos(randomX,randomY,randomZ);
            if((MathHelper.abs(randomX-pos.getX())*MathHelper.abs(randomX-pos.getX()))+
                    (MathHelper.abs(randomZ-pos.getZ())*MathHelper.abs(randomZ-pos.getZ()))<=radius*radius) {
                if(worldIn.getBlockState(tmp)==Blocks.GRASS.getDefaultState()) {
                    worldIn.setBlockState(tmp, KCore.KatharianGrass.getDefaultState(),2);
                }
                if(worldIn.getBlockState(tmp)==Blocks.DIRT.getDefaultState()) {
                    worldIn.setBlockState(tmp, KCore.KatharianDirt.getDefaultState(),2);
                }
                if(worldIn.getBlockState(tmp)==Blocks.OBSIDIAN.getDefaultState()) {
                    worldIn.setBlockState(tmp, KCore.MythicStone.getDefaultState(),2);
                }
                if(worldIn.getBlockState(tmp)==Blocks.SAND.getDefaultState()) {
                    worldIn.setBlockState(tmp, KCore.ForgottenSand.getDefaultState(),2);
                }
                if(worldIn.getBlockState(tmp)==KCore.KatharianGrass.getDefaultState()&&worldIn.getBlockState(tmp.up())==Blocks.AIR.getDefaultState()) {
                    worldIn.setBlockState(tmp.up(), pickUpRandomFlowerStateForKether(rand),2);
                }
            }
        }
    }*/

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
           /* if(!worldIn.isRemote) {
                if (!entityIn.isPassenger() && !entityIn.isBeingRidden() && entityIn.isNonBoss()) {
                    entityIn.setPortal(pos);
                    if (entityIn instanceof EntityPlayerMP) {
                        EntityPlayerMP player = (EntityPlayerMP) entityIn;
                        entityIn.timeUntilPortal = 10;
                        if (player.dimension == Kathairis.kath_Dim_type) {
                        } else if (player.dimension == DimensionType.OVERWORLD) {
                            WorldServer server = player.getServer().getWorld(DimensionType.OVERWORLD);
                            player.changeDimension(DimensionType.OVERWORLD, new TeleporterKathairis(server));
                        }
                    } else {
                        entityIn.timeUntilPortal = 10;
                        if (entityIn.dimension == Kathairis.kath_Dim_type) {
                            entityIn.changeDimension(DimensionType.OVERWORLD, new TeleporterKathairis(entityIn.getServer().getWorld(DimensionType.OVERWORLD)));
                        } else if (entityIn.dimension == DimensionType.OVERWORLD) {
                            WorldServer server = worldIn.getServer().getWorld(DimensionType.OVERWORLD);
                            Validate.notNull(server, "server is null!");
                            entityIn.changeDimension(DimensionType.OVERWORLD, new TeleporterKathairis(server));
                        }
                    }
                }
            /*}
        }
    }
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, IBlockState state) {
        return ItemStack.EMPTY;
    }
    @Override
    public boolean trySpawnPortal(IWorld worldIn, BlockPos pos) {
        BlockKathairisPortal.Size blockportal$size = this.isPortal1(worldIn, pos);
        if (blockportal$size != null) {
            blockportal$size.placePortalBlocks();
            return true;
        } else {
            return false;
        }
    }
    /*@Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if(entityIn instanceof EntityPlayer){
            TileEntityKether.tele((EntityPlayer) entityIn);
        }else {
            TileEntityKether.teleEntity(entityIn);
        }
        if ((entityIn.getRidingEntity() == null))
        {
            if(((entityIn instanceof EntityPlayerMP))) {
                EntityPlayerMP player1 = (EntityPlayerMP) entityIn;
                TileEntityKether.tele(player1);
            }else{
                TileEntityKether.teleEntity(entityIn);
            }
        }
        if ((entityIn.getRidingEntity() == null) && ((entityIn instanceof EntityPlayerMP)))
		{
			EntityPlayerMP player1 = (EntityPlayerMP)entityIn;
			TileEntityKether.tele(player1);
		}
    }
    @OnlyIn(Dist.CLIENT)
    public void animateTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        /*if (rand.nextInt(100) == 0) {
            worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }
        for (int i = 0; i < 6; ++i) {
            double d0 = (double) ((float) pos.getX() + rand.nextFloat());
            double d1 = (double) ((float) pos.getY() + rand.nextFloat());
            double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
            double d3 = ((double) rand.nextFloat() - 0.5D) * 0.15D;
            double d4 = ((double) rand.nextFloat() - 0.5D) * 0.15D;
            double d5 = ((double) rand.nextFloat() - 0.5D) * 0.15D;
            Particle theParticle = new DynamicParticle(
                    ParticlesFactory.PORTAL,
                    worldIn,
                    d0, d1, d2,
                    d3, d4, d5)
                    .setRotSpeed(((float) Math.random() - 0.5F) * 0.1F)
                    .setLifeSpan(20 + rand.nextInt(20))
                    .setGravity(0F)
                    .setScale(2.0F)
                    .setInitialAlpha(1.0F)
                    .setFinalAlpha(0.5F)
                    .setEnableDepth(true);
            worldIn.spawnParticle(theParticle,d0,d1,d2,d3,d4,d5);
        }*/
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
            return blockIn.getMaterial(blockIn.getDefaultState()) == Material.AIR || blockIn == Blocks.FIRE || blockIn == BlockInit.ParallelDimensionPortal;
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