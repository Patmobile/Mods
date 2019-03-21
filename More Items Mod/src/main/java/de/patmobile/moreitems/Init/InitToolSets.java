package de.patmobile.moreitems.Init;

import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public enum InitToolSets implements IItemTier {
    SMARAGD(2, 1000, 10.0F, 2.5F, 15, () -> {
        return Ingredient.fromItems(Items.EMERALD);
    }),
    OBSIDIAN(3, 1250, 7.0F, 3.0F, 8, () -> {
        return Ingredient.fromItems(Blocks.OBSIDIAN);
    }),
    VERSTAERKTERDIAMANT(4, 2000, 16.0F, 4.0F, 35, () -> {
        return Ingredient.fromItems(ItemInit.VerstaerkterDiamant);
    });
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;

    private InitToolSets(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}