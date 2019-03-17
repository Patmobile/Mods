package de.patmobile.moreblocks.api;

import de.patmobile.moreblocks.registry.IUBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;

public class UBlock extends Block implements IUBlock {
	
	protected final String name;
	
	protected final ItemBlock itemblock;
	
	public UBlock(String name, Properties properties) {
		this(name, null, properties);
	}
	
	public UBlock(String name, ItemGroup group, Properties properties) {
		this(name, group, properties, null);
	}
	
	public UBlock(String name, Properties properties, Item.Properties itemblockproperties) {
		this(name, null, properties, itemblockproperties);
	}
	
	public UBlock(String name, ItemGroup group, Properties properties, Item.Properties itemblockproperties) {
		super(properties);
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