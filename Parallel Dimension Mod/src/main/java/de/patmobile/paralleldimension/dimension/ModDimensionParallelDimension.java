package de.patmobile.paralleldimension.dimension;

import com.mojang.datafixers.FunctionType;

import de.patmobile.paralleldimension.ModConfig;
import de.patmobile.paralleldimension.ParallelDimensionMod;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

import javax.annotation.Nonnull;
import java.util.function.Function;

public class ModDimensionParallelDimension extends ModDimension {

    public ModDimensionParallelDimension(){
        setRegistryName(ModConfig.MODID,ModConfig.MODID);
    }

    @Override
    public Function<DimensionType, ? extends Dimension> getFactory() {
        return new FunctionType<DimensionType, Dimension>() {
            @Nonnull
            @Override
            public Dimension apply(@Nonnull DimensionType dimensionType) {
                return ParallelDimensionMod.ParallelDimensionTyp.create();
            }
        };
    }
}