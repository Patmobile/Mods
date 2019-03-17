package de.patmobile.moreblocks.blocks;

import de.patmobile.moreblocks.MoreBlocksMod;
import de.patmobile.moreblocks.api.UBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;

public class BlockBasic extends UBlock {
	
	public BlockBasic(String name) {
		super(name, MoreBlocksMod.MoreBlocksTab, Properties.create(Material.ROCK).hardnessAndResistance(2F).sound(SoundType.STONE), new Item.Properties().rarity(EnumRarity.COMMON));
	}
	
}