package de.patmobile.trampolin.blocks;

import de.patmobile.trampolin.ModConfig;
import de.patmobile.trampolin.init.BlockInit;
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

public class BlockBase extends Block {

    private String blockName;

    private ItemGroup itemGroup;

    public BlockBase(String Name, Material material, float hardness1, float resistance, SoundType soundType,ItemGroup group) {
        super(Block.Properties.create(material).sound(soundType).hardnessAndResistance(hardness1,resistance));
        blockName=Name;
        setRegistryName(ModConfig.MODID,blockName);
        itemGroup=group;
    }

    public BlockBase(String Name, Block.Properties properties,ItemGroup group) {
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



    @Override
    public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune) {
        return super.getItemDropped(state, worldIn, pos, fortune);
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(this);
    }
}