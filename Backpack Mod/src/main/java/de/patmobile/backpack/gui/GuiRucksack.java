package de.patmobile.backpack.gui;

import de.patmobile.backpack.ModConfig;

import de.patmobile.backpack.container.ContainerRucksack;
import de.patmobile.backpack.container.UGuiContainer;
import de.patmobile.backpack.enums.EnumRucksack;
import de.patmobile.backpack.inventory.InventoryRucksack;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiRucksack extends UGuiContainer {
	
	private final EnumRucksack type;
	
	public GuiRucksack(InventoryPlayer playerInventory, InventoryRucksack backpackInventory) {
		super(new ContainerRucksack(playerInventory, backpackInventory), new ResourceLocation(ModConfig.MODID, "textures/gui/" + backpackInventory.getType().getName() + ".png"));
		
		type = backpackInventory.getType();
		
		switch (type) {
		
		case KLEIN:
			xSize = 176;
			ySize = 159;
			break;
			
		case GROSS:
			xSize = 176;
			ySize = 204;
			break;
		}
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		super.render(mouseX, mouseY, partialTicks);
		renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		if (type == EnumRucksack.KLEIN) {
		fontRenderer.drawString(I18n.format("item.backpack.kleinerrucksack"), 7, 5, 4210752);
		}
		
		else if (type == EnumRucksack.GROSS) {
			fontRenderer.drawString(I18n.format("item.backpack.grosserrucksack"), 7, 7, 4210752);
		}
     }
	
	
	@Override
	public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(background);
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		drawModalRectWithCustomSizedTexture(xStart, yStart, 0, 0, xSize, ySize, 512, 512);
	}
}
