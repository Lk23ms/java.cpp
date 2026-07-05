# Chương 05: Minecraft Client Modding với Fabric

> ⚠️ **Phạm vi chương này**: hướng dẫn modding client hợp lệ — thêm HUD, keybind, hiệu ứng hình ảnh, quản lý config phía client... chạy trên client của chính bạn hoặc server đồng ý cho phép mod. Chương này **không** hướng dẫn tạo cheat/hack (auto-aim, x-ray, fly hack...) để gian lận trên server không cho phép, vì vi phạm điều khoản dịch vụ (ToS) và có thể khiến tài khoản/IP bị cấm.

## 5.1 Vì sao chọn Fabric cho client modding?

Fabric nhẹ hơn Forge, cập nhật phiên bản Minecraft mới nhanh hơn, và rất phổ biến cho các mod chỉ chạy phía client (ví dụ: Sodium tối ưu FPS, Iris shader...).

## 5.2 Setup môi trường Fabric

1. Vào [Fabric Example Mod](https://github.com/FabricMC/fabric-example-mod) — clone hoặc tải template.
2. Mở bằng IntelliJ IDEA, chạy:

```bash
./gradlew genSources
./gradlew runClient
```

## 5.3 Cấu trúc mod Fabric cơ bản

```java
public class ExampleClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Client mod đã khởi động!");
    }
}
```

Khai báo trong `fabric.mod.json`:

```json
{
  "entrypoints": {
    "client": ["com.example.ExampleClientMod"]
  }
}
```

## 5.4 Thêm Keybinding tùy chỉnh

```java
private static KeyBinding openMenuKey;

@Override
public void onInitializeClient() {
    openMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.examplemod.openmenu",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_M,
            "category.examplemod.general"
    ));

    ClientTickEvents.END_CLIENT_TICK.register(client -> {
        while (openMenuKey.wasPressed()) {
            client.player.sendMessage(Text.literal("Bạn vừa nhấn phím M!"), false);
        }
    });
}
```

## 5.5 Vẽ thêm HUD (giao diện trong game)

```java
HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
    MinecraftClient client = MinecraftClient.getInstance();
    drawContext.drawText(client.textRenderer, "FPS: " + client.getCurrentFps(),
            10, 10, 0xFFFFFF, true);
});
```

Đây là cách các mod hiển thị coordinate, minimap, thông tin server... hoạt động — hoàn toàn hợp lệ vì chỉ hiển thị thông tin có sẵn, không thay đổi dữ liệu server.

## 5.6 Giới thiệu Mixin (nâng cao)

Mixin cho phép "chèn" code vào giữa các hàm gốc của Minecraft mà không cần sửa trực tiếp file class gốc — kỹ thuật này dùng bytecode manipulation, khá nâng cao.

```java
@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "getName", at = @At("RETURN"), cancellable = true)
    private void onGetName(CallbackInfoReturnable<Text> cir) {
        // Ví dụ: thêm prefix vào tên hiển thị (chỉ minh họa kỹ thuật, không đổi dữ liệu thật)
    }
}
```

Mixin cần khai báo trong file `<modid>.mixins.json` và yêu cầu hiểu rõ vòng đời (lifecycle) của method gốc để không phá vỡ game — nên tìm hiểu kỹ tài liệu chính thức trước khi dùng.

## 5.7 Bài tập thực hành

1. Thêm 1 dòng chữ custom lên HUD hiển thị tọa độ người chơi hiện tại.
2. Thêm keybind mở 1 thông báo chat khi nhấn phím tùy chọn.
3. Tìm hiểu và thử nghiệm 1 Mixin đơn giản để log ra console mỗi khi người chơi nhảy (`jump()`).

## 5.8 Tài liệu tham khảo

- Fabric Docs: https://fabricmc.net/wiki/
- Mixin Wiki (SpongePowered): https://github.com/SpongePowered/Mixin/wiki

➡️ Tiếp theo: [Chương 06 - Dự án thực hành tổng hợp](../06-du-an-thuc-hanh)
