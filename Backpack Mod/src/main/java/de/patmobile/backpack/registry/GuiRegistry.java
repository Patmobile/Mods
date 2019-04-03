package de.patmobile.backpack.registry;

import java.util.*;
import java.util.function.Function;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.network.FMLPlayMessages.OpenContainer;

@OnlyIn(Dist.CLIENT)
public class GuiRegistry {
	
	static Map<ModContainer, Map<ResourceLocation, Function<OpenContainer, GuiScreen>>> guis = new HashMap<>();
	
	public static void registerTileEntity(ResourceLocation location, Function<Data, GuiContainer> function) {
		register(location, openContainer -> {
			EntityPlayerSP player = Minecraft.getInstance().player;
			World world = player.getEntityWorld();
			
			PacketBuffer buffer = openContainer.getAdditionalData();
			BlockPos pos = buffer.readBlockPos();
			
			TileEntity tileentity = world.getTileEntity(pos);
			
			Data data = new Data(openContainer, player, world, tileentity);
			
			return function.apply(data);
		});
	}
	
	public static void register(ResourceLocation location, Function<OpenContainer, GuiScreen> function) {
		ModLoadingContext context = ModLoadingContext.get();
		ModContainer container = context.getActiveContainer();
		if (!guis.containsKey(container)) {
			guis.put(container, new HashMap<>());
			context.registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> openContainer -> {
				return guis.get(container).getOrDefault(openContainer.getId(), nullFunction -> null).apply(openContainer);
			});
		}
		guis.get(container).put(location, function);
	}
	
	public static class Data {
		
		private OpenContainer openContainer;
		private EntityPlayerSP player;
		private World world;
		private TileEntity tileentity;

		
		private Data(OpenContainer openContainer, EntityPlayerSP player, World world, TileEntity tileentity) {
			this.openContainer = openContainer;
			this.player = player;
			this.world = world;
			this.tileentity = tileentity;
		}
		
		public OpenContainer getOpenContainer() {
			return openContainer;
		}
		
		public EntityPlayerSP getPlayer() {
			return player;
		}
		
		public World getWorld() {
			return world;
		}
		
		public TileEntity getTileentity() {
			return tileentity;
		}
		
	}
	
}