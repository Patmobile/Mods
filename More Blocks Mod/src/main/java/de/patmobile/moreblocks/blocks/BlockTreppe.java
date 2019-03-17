package de.patmobile.moreblocks.blocks;

import de.patmobile.moreblocks.MoreBlocksMod;
import de.patmobile.moreblocks.api.UBlockTreppe;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockTreppe extends UBlockTreppe {
	
	public BlockTreppe(String name, IBlockState modelState) {
		super(name, modelState, MoreBlocksMod.MoreBlocksTab, Properties.create(Material.ROCK).hardnessAndResistance(2F).sound(SoundType.METAL));
	}
	
	
}