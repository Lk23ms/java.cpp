// LƯU Ý: Đây là code minh họa cú pháp/cấu trúc, cần chạy trong 1 project Forge MDK
// thật (có đầy đủ thư viện Forge qua Gradle) mới build và chạy được.
// Xem README.md của chương này để biết cách setup project Forge đầy đủ.

package com.example.examplemod;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(ExampleModStructure.MODID)
public class ExampleModStructure {

    public static final String MODID = "examplemod";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public ExampleModStructure() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        System.out.println("[ExampleMod] Mod đã khởi động, item 'ruby' đã được đăng ký!");
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ModEvents {
        @SubscribeEvent
        public static void onServerStarting(net.minecraftforge.event.server.ServerStartingEvent event) {
            System.out.println("[ExampleMod] Server đang khởi động, mod sẵn sàng hoạt động!");
        }
    }
}
