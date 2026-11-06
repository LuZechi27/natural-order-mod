package net.lugz.naturalorder.item;

import net.lugz.naturalorder.NaturalOrder;
import net.lugz.naturalorder.block.ModBlocks;
import net.lugz.naturalorder.food.ModFoods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NaturalOrder.MOD_ID);

    public static final DeferredItem<Item> ONION = ITEMS.registerItem("onion",
            properties -> new Item(properties.food(ModFoods.ONION)));

    public static final DeferredItem<Item> RED_ONION = ITEMS.registerItem("red_onion",
            properties -> new Item(properties.food(ModFoods.ONION)));

    public static final DeferredItem<Item> WHITE_ONION = ITEMS.registerItem("white_onion",
            properties -> new Item(properties.food(ModFoods.ONION)));

    //Crop seeds
    public static final DeferredItem<Item> ONION_SEEDS = ITEMS.registerItem("onion_seeds",
            properties -> new BlockItem(ModBlocks.ONION_CROP.get() ,properties));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
