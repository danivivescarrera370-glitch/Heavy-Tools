package com.example.heavytools;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

@Mod(HeavyToolsMod.MODID)
public class HeavyToolsMod {
    public static final String MODID = "heavytools";
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MODID);

    // Creating custom high-damage, slow attack speed tools mimicking the Mace profile
    public static final DeferredHolder<Item, Item> HEAVY_AXE = ITEMS.register("heavy_axe", 
        () -> new AxeItem(Tiers.NETHERITE, new Item.Properties().attributes(
            AxeItem.createAttributes(Tiers.NETHERITE, 9.0F, -3.5F)
        ))
    );

    public static final DeferredHolder<Item, Item> HEAVY_PICKAXE = ITEMS.register("heavy_pickaxe", 
        () -> new PickaxeItem(Tiers.NETHERITE, new Item.Properties().attributes(
            PickaxeItem.createAttributes(Tiers.NETHERITE, 5.0F, -3.2F)
        ))
    );

    public static final DeferredHolder<Item, Item> HEAVY_HOE = ITEMS.register("heavy_hoe", 
        () -> new HoeItem(Tiers.NETHERITE, new Item.Properties().attributes(
            HoeItem.createAttributes(Tiers.NETHERITE, 1.0F, -2.5F)
        ))
    );

    public static final DeferredHolder<Item, CreativeModeTab> HEAVY_TOOLS_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID)
        .register("heavy_tools_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(HEAVY_AXE.get()))
            .title(net.minecraft.network.chat.Component.translatable("creativetab.heavytools"))
            .displayItems((parameters, output) -> {
                output.accept(HEAVY_AXE.get());
                output.accept(HEAVY_PICKAXE.get());
                output.accept(HEAVY_HOE.get());
            }).build()
        );

    public HeavyToolsMod(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
