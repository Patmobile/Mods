package de.patmobile.backpack.handler;


import de.patmobile.backpack.ModConfig;
import de.patmobile.backpack.gui.GuiRucksack;
import de.patmobile.backpack.inventory.InventoryRucksack;
import de.patmobile.backpack.items.ItemRucksack;
import de.patmobile.backpack.registry.GuiRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;

public class GuiHandler {

	public static void construct() {
		
		GuiRegistry.register(new ResourceLocation(ModConfig.MODID, "rucksack"), openContainer -> {
			EntityPlayerSP player = Minecraft.getInstance().player;
			PacketBuffer buffer = openContainer.getAdditionalData();
			EnumHand hand = buffer.readEnumValue(EnumHand.class);
			
			if (hand == null) {
				return null;
			}
			
			ItemStack stack = player.getHeldItem(hand);
			Item item = stack.getItem();
			
			if (!(item instanceof ItemRucksack)) {
				return null;
			}
			ItemRucksack backpack = (ItemRucksack) item;
			return new GuiRucksack(player.inventory, new InventoryRucksack(stack, backpack.getType()));
		});
}
}
