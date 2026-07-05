// LƯU Ý: Cần project Fabric (fabric-example-mod template) với Fabric API
// để build & chạy thật. Xem README.md của chương này để setup.

package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class ExampleClientMod implements ClientModInitializer {

    private static KeyBinding showCoordsKey;

    @Override
    public void onInitializeClient() {
        System.out.println("[ExampleClientMod] Client mod đã khởi động!");

        // Đăng ký keybind
        showCoordsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.examplemod.showcoords",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_M,
                "category.examplemod.general"
        ));

        // Xử lý khi phím được nhấn
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (showCoordsKey.wasPressed()) {
                if (client.player != null) {
                    client.player.sendMessage(Text.literal(String.format(
                            "Tọa độ hiện tại: x=%.1f y=%.1f z=%.1f",
                            client.player.getX(), client.player.getY(), client.player.getZ()
                    )), false);
                }
            }
        });

        // Vẽ FPS lên HUD
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            drawContext.drawText(client.textRenderer, "FPS: " + client.getCurrentFps(),
                    10, 10, 0xFFFFFF, true);
        });
    }
}
