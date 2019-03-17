package de.patmobile.trampolin.init;

import de.patmobile.trampolin.ModConfig;
import de.patmobile.trampolin.blocks.BlockTrampolin;
import de.patmobile.trampolin.registry.BlockRegistry;

public class BlockInit {
	
	public static final BlockTrampolin WeissesTrampolin = new BlockTrampolin("weissestrampolin");
	public static final BlockTrampolin OrangenesTrampolin = new BlockTrampolin("orangenestrampolin");
	public static final BlockTrampolin MagentaTrampolin = new BlockTrampolin("magentatrampolin");
	public static final BlockTrampolin HellblauesTrampolin = new BlockTrampolin("hellblauestrampolin");
	public static final BlockTrampolin GelbesTrampolin = new BlockTrampolin("gelbestrampolin");
	public static final BlockTrampolin HellgruenesTrampolin = new BlockTrampolin("hellgruenestrampolin");
	public static final BlockTrampolin RosanesTrampolin = new BlockTrampolin("rosanestrampolin");
	public static final BlockTrampolin GrauesTrampolin = new BlockTrampolin("grauestrampolin");
	public static final BlockTrampolin HellgrauesTrampolin = new BlockTrampolin("hellgrauestrampolin");
	public static final BlockTrampolin TuerkisesTrampolin = new BlockTrampolin("tuerkisestrampolin");
	public static final BlockTrampolin ViolettesTrampolin = new BlockTrampolin("violettestrampolin");
	public static final BlockTrampolin BlauesTrampolin = new BlockTrampolin("blauestrampolin");
	public static final BlockTrampolin BraunesTrampolin = new BlockTrampolin("braunestrampolin");
	public static final BlockTrampolin GruenesTrampolin = new BlockTrampolin("gruenestrampolin");
	public static final BlockTrampolin RotesTrampolin = new BlockTrampolin("rotestrampolin");
	public static final BlockTrampolin SchwarzesTrampolin = new BlockTrampolin("schwarzestrampolin");
	
	public static void construct() {
		BlockRegistry.register(ModConfig.MODID, BlockInit.class);
	}
	
}