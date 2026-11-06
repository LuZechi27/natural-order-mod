package net.lugz.naturalorder.block.custom.onions;

import net.lugz.naturalorder.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jspecify.annotations.NonNull;

public class RedOnionCropBlock extends OnionCropBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    public RedOnionCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull ItemLike getBaseSeedId() {
        return ModItems.RED_ONION_SETS.get();
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected @NonNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
