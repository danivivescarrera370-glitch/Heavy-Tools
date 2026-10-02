package com.example.heavytools;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Heavytools.MODID)
public class Heavytools {
    public static final String MODID = "minecraft";
    
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Custom structural tier with updated durability set to 2070
    public static final Tier HEAVY_TIER = new SimpleTier(
            4, 
            2070, 
            6.0f, 
            4.0f, 
            15, 
            () -> Ingredient.of(Items.HEAVY_CORE)
    );

    public static final DeferredItem<AxeItem> HEAVY_AXE = ITEMS.register("heavy_axe",
            () -> new AxeItem(HEAVY_TIER, new Item.Properties().attributes(
                    AxeItem.createAttributes(HEAVY_TIER, 11.0f, -3.35f)
            ))
    );

    public static final DeferredItem<PickaxeItem> HEAVY_PICKAXE = ITEMS.register("heavy_pickaxe",
            () -> new PickaxeItem(HEAVY_TIER, new Item.Properties().attributes(
                    PickaxeItem.createAttributes(HEAVY_TIER, 8.0f, -3.2f)
            ))
    );

    public static final DeferredItem<HoeItem> HEAVY_HOE = ITEMS.register("heavy_hoe",
            () -> new HoeItem(HEAVY_TIER, new Item.Properties().attributes(
                    HoeItem.createAttributes(HEAVY_TIER, 5.0f, -3.0f)
            ))
    );

    public Heavytools(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        
        modEventBus.addListener(this::onBuildCreativeTabs);
        
        NeoForge.EVENT_BUS.register(HeavySmashHandler.class);
    }

    private void onBuildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(HEAVY_AXE.get());
            event.accept(HEAVY_PICKAXE.get());
            event.accept(HEAVY_HOE.get());
        }
        
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(HEAVY_AXE.get());
        }
    }
}
