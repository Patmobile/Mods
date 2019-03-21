package de.patmobile.moreblocks.init;

import java.util.ArrayList;

import de.patmobile.moreblocks.blocks.BlockBasic;
import de.patmobile.moreblocks.blocks.BlockTreppe;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

@net.minecraftforge.registries.ObjectHolder("moreblocks:blocks")
public class BlockInit {
	
    public static ArrayList<Block> blockRegistryList=new ArrayList<>();
    public static ArrayList<ItemBlock> itemBlocksRegistryList=new ArrayList<>();
    
	 public static Block Eisziegel;
	 public static Block Schneeziegel;
	 public static Block VerstaerkterDiamantblock;
	 public static Block EisziegelTreppe;
	 public static Block SchneeziegelTreppe;
	 public static Block VerstaerkteDiamantTreppe;

	 
	 public static void initBlocks(){
		 

		 Eisziegel = new BlockBasic("eisziegel", Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 Schneeziegel = new BlockBasic("schneeziegel", Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 VerstaerkterDiamantblock = new BlockBasic("verstaerkterdiamantblock", Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 EisziegelTreppe = new BlockTreppe(BlockInit.Eisziegel.getDefaultState(), "eisziegeltreppe", Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 SchneeziegelTreppe = new BlockTreppe(BlockInit.Schneeziegel.getDefaultState(), "schneeziegeltreppe", Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 VerstaerkteDiamantTreppe = new BlockTreppe(BlockInit.VerstaerkterDiamantblock.getDefaultState(), "verstaerktediamanttreppe", Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
	}

	
}