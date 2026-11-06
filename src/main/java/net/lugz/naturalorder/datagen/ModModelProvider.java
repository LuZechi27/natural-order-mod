package net.lugz.naturalorder.datagen;

import net.lugz.naturalorder.NaturalOrder;
import net.lugz.naturalorder.block.ModBlocks;
import net.lugz.naturalorder.block.custom.OnionCropBlock;
import net.lugz.naturalorder.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, NaturalOrder.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.ONION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RED_ONION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.WHITE_ONION.get(), ModelTemplates.FLAT_ITEM);

        //BLOCKS
        blockModels.createCropBlock(ModBlocks.ONION_CROP.get(), OnionCropBlock.AGE, 0, 1, 2, 3);
    }
}
