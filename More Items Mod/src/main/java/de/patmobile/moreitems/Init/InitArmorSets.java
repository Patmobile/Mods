package de.patmobile.moreitems.Init;

import java.util.function.Supplier;

import de.patmobile.moreitems.ModConfig;
import de.patmobile.paralleldimension.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum InitArmorSets implements IArmorMaterial {
	
    STEINARMOR(ModConfig.MODID +":"+"stein", 7, new int[]{1, 2, 2, 1}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{Blocks.STONE});
    }),
    SMARAGDARMOR(ModConfig.MODID+":"+"smaragd", 24, new int[]{3, 6, 7, 2}, 17, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{Items.EMERALD});
    }),
    OBSIDIANARMOR(ModConfig.MODID+":"+"obsidian", 30, new int[]{3, 6, 8, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{Blocks.OBSIDIAN});
    }),
    VERSTAERKTEDIAMANTARMOR(ModConfig.MODID+":"+"verstaerktediamant", 50, new int[]{3, 6, 8, 3}, 40, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.5F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{ItemInitMI.VerstaerkterDiamant});
    }),
	SAPHIRARMOR(ModConfig.MODID+":"+"saphir", 20, new int[]{3, 5, 7, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{ItemInit.Saphir});
    }),
	RUBINARMOR(ModConfig.MODID+":"+"rubin", 28, new int[]{3, 5, 8, 3}, 27, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, () -> {
        return Ingredient.fromItems(new IItemProvider[]{ItemInit.Rubin});
    });


    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyLoadBase<Ingredient> repairMaterial;

    private InitArmorSets(String p_i48533_3_, int p_i48533_4_, int[] p_i48533_5_, int p_i48533_6_, SoundEvent p_i48533_7_, float p_i48533_8_, Supplier<Ingredient> p_i48533_9_) {
        this.name = p_i48533_3_;
        this.maxDamageFactor = p_i48533_4_;
        this.damageReductionAmountArray = p_i48533_5_;
        this.enchantability = p_i48533_6_;
        this.soundEvent = p_i48533_7_;
        this.toughness = p_i48533_8_;
        this.repairMaterial = new LazyLoadBase(p_i48533_9_);
    }

    public int getDurability(EntityEquipmentSlot p_200896_1_) {
        return MAX_DAMAGE_ARRAY[p_200896_1_.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EntityEquipmentSlot p_200902_1_) {
        return this.damageReductionAmountArray[p_200902_1_.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return (Ingredient)this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }
}