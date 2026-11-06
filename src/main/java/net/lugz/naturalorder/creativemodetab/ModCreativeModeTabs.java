package net.lugz.naturalorder.creativemodetab;

import net.lugz.naturalorder.NaturalOrder;
import net.lugz.naturalorder.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NaturalOrder.MOD_ID);

    public static final Supplier<CreativeModeTab> ALL_MOD_ITEMS_TAB = CREATIVE_MODE_TABS.register("all_natural_order_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ONION.get()))
                    .title(Component.translatable("creativetab.naturalorder.all_natural_order_items"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ONION);
                        output.accept(ModItems.RED_ONION);
                        output.accept(ModItems.WHITE_ONION);

                        output.accept(ModItems.ONION_SEEDS);
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
