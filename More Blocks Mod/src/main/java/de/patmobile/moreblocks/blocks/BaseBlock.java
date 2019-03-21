package de.patmobile.moreblocks.blocks;

import de.patmobile.moreblocks.ModConfig;
import de.patmobile.moreblocks.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BaseBlock extends Block {

    private String blockName;

    private ItemGroup itemGroup;

    public BaseBlock(String Name, Material material, float hardness1, float resistance, SoundType soundType,ItemGroup group) {
        super(Block.Properties.create(material).sound(soundType).hardnessAndResistance(hardness1,resistance));
        blockName=Name;
        setRegistryName(ModConfig.MODID,blockName);
        itemGroup=group;
    }

    public BaseBlock(String Name, Block.Properties properties,ItemGroup group) {
        super(properties);
        blockName=Name;
        setRegistryName(ModConfig.MODID,blockName);
        itemGroup=group;
    }

    public String getBlockName(){
        return blockName;
    }

    public ItemGroup getItemGroup(){
        return itemGroup;
    }

    public BaseBlock addToBlockRegistryList(){
        BlockInit.blockRegistryList.add(this);
        return this;
    }

    public BaseBlock addToItemBlockRegistryList(){
    	BlockInit.itemBlocksRegistryList.add(new ItemBlock(this,new Item.Properties().group(getItemGroup())));
        return this;
    }

    public BaseBlock addToBlockAndItemBlockRegistryList(){
    	BlockInit.blockRegistryList.add(this);
    	BlockInit.itemBlocksRegistryList.add(new ItemBlock(this,new Item.Properties().group(getItemGroup())));
        return this;
    }

    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return super.getItemDropped(state, worldIn, pos, fortune);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(this);
    }
}