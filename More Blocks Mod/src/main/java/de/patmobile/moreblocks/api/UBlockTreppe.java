package de.patmobile.moreblocks.api;

import de.patmobile.moreblocks.registry.IUBlock;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.*;

public class UBlockTreppe extends BlockStairs implements IUBlock {
	
	protected final String name;
	
	protected final ItemBlock itemblock;
	
	public UBlockTreppe(String name, IBlockState modelState, Properties properties) {
		this(name, modelState, null, properties);
	}
	
	public UBlockTreppe(String name, IBlockState modelState, ItemGroup group, Properties properties) {
		this(name, modelState, group, properties, null);
	}
	
	public UBlockTreppe(String name, IBlockState modelState, Properties properties, Item.Properties itemblockproperties) {
		this(name, modelState, null, properties, itemblockproperties);
	}
	
	public UBlockTreppe(String name, IBlockState modelState, ItemGroup group, Properties properties, Item.Properties itemblockproperties) {
		super(modelState, properties);
		this.name = name;
		itemblock = createItemBlock(itemblockproperties == null ? new Item.Properties().group(group) : group == null ? itemblockproperties : itemblockproperties.group(group));
	}
	
	protected ItemBlock createItemBlock(Item.Properties itemblockproperties) {
		return new ItemBlock(this, itemblockproperties);
	}
	
	@Override
	public String getEntryName() {
		return name;
	}
	
	@Override
	public ItemBlock getItemBlock() {
		return itemblock;
	}
	
}