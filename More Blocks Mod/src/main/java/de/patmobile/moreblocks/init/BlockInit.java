package de.patmobile.moreblocks.init;

import java.util.ArrayList;

import de.patmobile.moreblocks.blocks.BlockBasic;
import de.patmobile.moreblocks.blocks.BlockStufe;
import de.patmobile.moreblocks.blocks.BlockTreppe;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

@net.minecraftforge.registries.ObjectHolder("moreblocks:blocks")
public class BlockInit {
	
    public static ArrayList<Block> blockRegistryList=new ArrayList<>();
    public static ArrayList<ItemBlock> itemBlocksRegistryList=new ArrayList<>();
    
    //Blöcke
	public static Block Eisziegel, Schneeziegel, VerstaerkterDiamantblock, Saphirblock, Rubinblock;
	
	//Treppen
	public static Block EisziegelTreppe, SchneeziegelTreppe, VerstaerkteDiamantTreppe, SaphirTreppe, RubinTreppe;
	
	//Stufen
	public static Block EisziegelStufe, SchneeziegelStufe, VerstaerkteDiamantStufe, SaphirStufe, RubinStufe;

	 
	 public static void initBlocks(){
		 

		 Eisziegel = new BlockBasic("eisziegel", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();
		 Schneeziegel = new BlockBasic("schneeziegel", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();
		 VerstaerkterDiamantblock = new BlockBasic("verstaerkterdiamantblock", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();
		 Saphirblock = new BlockBasic("saphirblock", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();
		 Rubinblock = new BlockBasic("rubinblock", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();
		 
		 EisziegelTreppe = new BlockTreppe(BlockInit.Eisziegel.getDefaultState(), "eisziegeltreppe", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();
		 SchneeziegelTreppe = new BlockTreppe(BlockInit.Schneeziegel.getDefaultState(), "schneeziegeltreppe", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();
		 VerstaerkteDiamantTreppe = new BlockTreppe(BlockInit.VerstaerkterDiamantblock.getDefaultState(), "verstaerktediamanttreppe", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();
		 SaphirTreppe = new BlockTreppe(BlockInit.Saphirblock.getDefaultState(), "saphirtreppe", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();
		 RubinTreppe = new BlockTreppe(BlockInit.Rubinblock.getDefaultState(), "rubintreppe", Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.0f).sound(SoundType.STONE)).addToBlockAndItemBlockRegistryList();

		 EisziegelStufe = new BlockStufe("eisziegelstufe", Material.ROCK, 2.0f, SoundType.STONE).addToBlockAndItemBlockRegistryList();
		 SchneeziegelStufe = new BlockStufe("schneeziegelstufe", Material.ROCK, 2.0f, SoundType.STONE).addToBlockAndItemBlockRegistryList();
		 VerstaerkteDiamantStufe = new BlockStufe("verstaerktediamantstufe", Material.ROCK, 2.0f, SoundType.STONE).addToBlockAndItemBlockRegistryList();
		 SaphirStufe = new BlockStufe("saphirstufe", Material.ROCK, 2.0f, SoundType.STONE).addToBlockAndItemBlockRegistryList();
		 RubinStufe = new BlockStufe("rubinstufe", Material.ROCK, 2.0f, SoundType.STONE).addToBlockAndItemBlockRegistryList();

	 }

	
}