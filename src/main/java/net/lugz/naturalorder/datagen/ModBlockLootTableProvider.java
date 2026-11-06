package net.lugz.naturalorder.datagen;

import net.lugz.naturalorder.block.ModBlocks;
import net.lugz.naturalorder.block.custom.onions.OnionCropBlock;
import net.lugz.naturalorder.block.custom.onions.RedOnionCropBlock;
import net.lugz.naturalorder.block.custom.onions.WhiteOnionCropBlock;
import net.lugz.naturalorder.item.ModItems;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import org.jspecify.annotations.NonNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        addCropDrops(
                ModBlocks.ONION_CROP.get(),
                ModItems.ONION.get(),
                ModItems.ONION_SETS.get(),
                OnionCropBlock.AGE,
                OnionCropBlock.MAX_AGE
        );
        addCropDrops(
                ModBlocks.RED_ONION_CROP.get(),
                ModItems.RED_ONION.get(),
                ModItems.RED_ONION_SETS.get(),
                RedOnionCropBlock.AGE,
                RedOnionCropBlock.MAX_AGE
        );
        addCropDrops(
                ModBlocks.WHITE_ONION_CROP.get(),
                ModItems.WHITE_ONION.get(),
                ModItems.WHITE_ONION_SETS.get(),
                WhiteOnionCropBlock.AGE,
                WhiteOnionCropBlock.MAX_AGE
        );
    }

    @Override
    protected @NonNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    private void addCropDrops(Block cropBlock, Item dropItem, Item cropSeed, IntegerProperty age, int maxAge) {
        add(cropBlock, createCropDrops(cropBlock, dropItem, cropSeed, LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(age, maxAge))));
    }
}
