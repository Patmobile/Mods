package de.patmobile.paralleldimension.blocks;


import de.patmobile.paralleldimension.api.IUBlock;
import net.minecraft.block.BlockOre;
import net.minecraft.item.*;

public class UBlockOre extends BlockOre implements IUBlock {
	
	protected final String name;
	
	protected final ItemBlock itemblock;
	
	
	public UBlockOre(String name, Properties properties) {
		this(name, null, properties);
	}
	
	public UBlockOre(String name, ItemGroup group, Properties properties) {
		this(name, group, properties, null);
	}
	
	public UBlockOre(String name, Properties properties, Item.Properties itemblockproperties) {
		this(name, null, properties, itemblockproperties);
	}
	
	public UBlockOre(String name, ItemGroup group, Properties properties, Item.Properties itemblockproperties) {
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