package de.patmobile.paralleldimension.init;

import java.util.ArrayList;

import de.patmobile.paralleldimension.ParallelDimensionMod;
import de.patmobile.paralleldimension.blocks.BlockFeuer;
import de.patmobile.paralleldimension.blocks.BlockOre;
import de.patmobile.paralleldimension.blocks.BlockParallelDimensionPortal;
import de.patmobile.paralleldimension.helper.HarvestLevelHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

import net.minecraft.item.ItemBlock;

@net.minecraftforge.registries.ObjectHolder("paralleldimension:blocks")
public class BlockInit {


    public static ArrayList<Block> blockRegistryList=new ArrayList<>();
    public static ArrayList<ItemBlock> itemBlocksRegistryList=new ArrayList<>();

	public static Block Saphirerz;
	public static Block Rubinerz;
	public static Block HoellenFeuer;	
	public static Block ParallelDimensionPortal;
	
	public static void initBlocks(){

		Saphirerz = new BlockOre("saphirerz", Block.Properties.create(Material.IRON).hardnessAndResistance(3F, 3F).sound(SoundType.STONE), HarvestLevelHelper.RUBIN).addToBlockAndItemBlockRegistryList();
		Rubinerz = new BlockOre("rubinerz", Block.Properties.create(Material.IRON).hardnessAndResistance(3F, 3F).sound(SoundType.STONE), HarvestLevelHelper.RUBIN).addToBlockAndItemBlockRegistryList();
		HoellenFeuer = new BlockFeuer("hoellenfeuer", Block.Properties.create(Material.FIRE, MaterialColor.TNT).doesNotBlockMovement().needsRandomTick().lightValue(15).sound(SoundType.CLOTH)).addToBlockAndItemBlockRegistryList();
		ParallelDimensionPortal = new BlockParallelDimensionPortal("paralleldimensionportal", ParallelDimensionMod.ParallelDimensionTab).addToBlockAndItemBlockRegistryList();

	}

}