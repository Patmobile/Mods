package de.patmobile.trampolin.init;

import java.util.ArrayList;

import de.patmobile.trampolin.blocks.BlockTrampolin;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

@net.minecraftforge.registries.ObjectHolder("trampolin:blocks")
public class BlockInit {
	
    public static ArrayList<Block> blockRegistryList=new ArrayList<>();
    public static ArrayList<ItemBlock> itemBlocksRegistryList=new ArrayList<>();
    
    

	 public static Block WeissesTrampolin;
	 public static Block OrangenesTrampolin;
	 public static Block MagentaTrampolin;
	 public static Block HellblauesTrampolin;
	 public static Block GelbesTrampolin;
	 public static Block HellgruenesTrampolin;
	 public static Block RosanesTrampolin;
	 public static Block GrauesTrampolin;
	 public static Block HellgrauesTrampolin;
	 public static Block TuerkisesTrampolin;
	 public static Block ViolettesTrampolin;
	 public static Block BlauesTrampolin;
	 public static Block BraunesTrampolin;
	 public static Block GruenesTrampolin;
	 public static Block RotesTrampolin;
	 public static Block SchwarzesTrampolin;
	 
	 public static void initBlocks(){

		 WeissesTrampolin = new BlockTrampolin("weissestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 OrangenesTrampolin = new BlockTrampolin("orangenestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 MagentaTrampolin = new BlockTrampolin("magentatrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 HellblauesTrampolin = new BlockTrampolin("hellblauestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 GelbesTrampolin = new BlockTrampolin("gelbestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 HellgruenesTrampolin = new BlockTrampolin("hellgruenestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 RosanesTrampolin = new BlockTrampolin("rosanestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 GrauesTrampolin = new BlockTrampolin("grauestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 HellgrauesTrampolin = new BlockTrampolin("hellgrauestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 TuerkisesTrampolin = new BlockTrampolin("tuerkisestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 ViolettesTrampolin = new BlockTrampolin("violettestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 BlauesTrampolin = new BlockTrampolin("blauestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 BraunesTrampolin = new BlockTrampolin("braunestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 GruenesTrampolin = new BlockTrampolin("gruenestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 RotesTrampolin = new BlockTrampolin("rotestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
		 SchwarzesTrampolin = new BlockTrampolin("schwarzestrampolin", Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 2F).sound(SoundType.METAL)).addToBlockAndItemBlockRegistryList();
				
	 }
}