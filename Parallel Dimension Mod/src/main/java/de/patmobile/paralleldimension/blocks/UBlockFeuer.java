package de.patmobile.paralleldimension.blocks;


import de.patmobile.paralleldimension.api.IUBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;

public class UBlockFeuer extends Block implements IUBlock {
	
	protected final String name;
	
	protected final ItemBlock itemblock;
	
	
	public UBlockFeuer(String name, Properties properties) {
		this(name, null, properties);
	}
	
	public UBlockFeuer(String name, ItemGroup group, Properties properties) {
		this(name, group, properties, null);
	}
	
	public UBlockFeuer(String name, Properties properties, Item.Properties itemblockproperties) {
		this(name, null, properties, itemblockproperties);
	}
	
	public UBlockFeuer(String name, ItemGroup group, Properties properties, Item.Properties itemblockproperties) {
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