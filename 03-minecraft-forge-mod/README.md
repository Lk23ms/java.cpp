# Chương 03: Viết Mod Minecraft với Forge

## 3.1 Forge là gì?

Forge là một framework/API giúp bạn "cắm" (hook) code Java của mình vào vòng lặp game của Minecraft mà không cần sửa trực tiếp mã nguồn gốc (obfuscated) của Mojang. Forge lo phần khó (decompile, mapping, tương thích phiên bản), bạn chỉ tập trung viết tính năng.

## 3.2 Setup môi trường

1. Vào [Minecraft Forge - Files](https://files.minecraftforge.net/) chọn phiên bản Minecraft muốn mod (khuyên bắt đầu với 1.20.1, cộng đồng đông, tài liệu nhiều).
2. Hoặc dùng **MDK (Mod Development Kit)** template có sẵn trên GitHub của Forge — tải về, giải nén.
3. Mở thư mục bằng IntelliJ IDEA (File → Open → chọn `build.gradle`).
4. Chạy lệnh Gradle để setup:

```bash
./gradlew genIntellijRuns   # sinh cấu hình chạy game để debug trong IDE
```

5. Chạy cấu hình "runClient" trong IntelliJ để mở Minecraft có mod của bạn.

## 3.3 Cấu trúc mod cơ bản

```java
@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";

    public ExampleMod() {
        // Đăng ký các sự kiện khởi tạo mod tại đây
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        System.out.println("Mod của tôi đã khởi động!");
    }
}
```

`@Mod` là annotation Forge dùng để nhận diện class chính của mod (liên hệ lại kiến thức Annotation ở Chương 02).

## 3.4 Tạo Item mới

```java
public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
        () -> new Item(new Item.Properties()));
```

Đăng ký `ITEMS` vào mod event bus trong constructor:

```java
ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
```

Thêm texture cho item tại: `src/main/resources/assets/examplemod/textures/item/ruby.png`
và model json tại: `src/main/resources/assets/examplemod/models/item/ruby.json`.

## 3.5 Tạo Block mới

```java
public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5.0f)));
```

Đừng quên đăng ký thêm **BlockItem** (để block xuất hiện trong inventory):

```java
ITEMS.register("ruby_block", () -> new BlockItem(RUBY_BLOCK.get(), new Item.Properties()));
```

## 3.6 Xử lý Event (sự kiện game)

Ví dụ: in ra chat khi người chơi login vào thế giới.

```java
@Mod.EventBusSubscriber(modid = ExampleMod.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerLogin(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Player player) {
            player.sendSystemMessage(Component.literal("Chào mừng đến thế giới mod của tôi!"));
        }
    }
}
```

`@SubscribeEvent` chính là annotation Forge dùng để tự động gọi hàm này đúng lúc sự kiện xảy ra — không cần bạn gọi thủ công (liên hệ interface/annotation ở Chương 01-02).

## 3.7 Bài tập thực hành

1. Tạo 1 item mới có tên riêng (ví dụ "Ngọc Rồng"), thêm texture, cho vào creative tab.
2. Tạo 1 block mới, khi người chơi phá block thì nhận thêm 1 item ngẫu nhiên (dùng `LootTable` hoặc event `BlockDropsEvent`).
3. Viết event: khi người chơi ăn item bất kỳ, in ra chat "Ngon quá!".

## 3.8 Tài liệu tham khảo chính thức

- Forge Docs: https://docs.minecraftforge.net/
- Forge Community Wiki: https://forge.gemwire.uk/wiki/

➡️ Tiếp theo: [Chương 04 - Viết Plugin server với Spigot/Paper](../04-minecraft-plugin-spigot)
