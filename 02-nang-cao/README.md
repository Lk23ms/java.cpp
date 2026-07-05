# Chương 02: Java nâng cao

## 2.1 Collections (List, Map, Set)

API modding dùng `List`/`Map` liên tục (danh sách người chơi, bảng ánh xạ item...).

```java
import java.util.*;

List<String> players = new ArrayList<>();
players.add("Steve");
players.add("Alex");

Map<String, Integer> playerScores = new HashMap<>();
playerScores.put("Steve", 100);
playerScores.put("Alex", 80);

for (Map.Entry<String, Integer> entry : playerScores.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

Set<String> uniqueItems = new HashSet<>(List.of("Sword", "Sword", "Shield"));
System.out.println(uniqueItems.size()); // 2, vì Set không cho trùng
```

## 2.2 Generic

```java
class Box<T> {
    private T content;
    public void set(T content) { this.content = content; }
    public T get() { return content; }
}

Box<String> box = new Box<>();
box.set("Diamond");
System.out.println(box.get());
```

Bạn sẽ thấy Generic khắp nơi trong Forge, ví dụ: `DeferredRegister<Item>`, `RegistryObject<Block>`.

## 2.3 Exception Handling

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Lỗi chia cho 0: " + e.getMessage());
} finally {
    System.out.println("Luôn chạy dù có lỗi hay không");
}
```

Plugin Spigot thường bọc try-catch quanh việc đọc file config để tránh crash server.

## 2.4 Lambda & Stream (Java hiện đại)

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

// Lambda
numbers.forEach(n -> System.out.println("Số: " + n));

// Stream
int sum = numbers.stream()
                  .filter(n -> n % 2 == 0)
                  .mapToInt(n -> n)
                  .sum();
System.out.println("Tổng số chẵn: " + sum);
```

Event system của Forge/Fabric/Spigot dùng rất nhiều **lambda** để đăng ký sự kiện gọn gàng:

```java
// Ví dụ cú pháp tương tự thực tế trong Spigot
// getServer().getPluginManager().registerEvents(event -> { ... }, this);
```

## 2.5 Annotation — chìa khóa để hiểu Forge/Fabric

```java
@FunctionalInterface
interface Action {
    void run();
}
```

Trong Forge, bạn sẽ thấy annotation như `@Mod`, `@SubscribeEvent`, `@EventBusSubscriber`. Đây là cách Java "gắn nhãn" cho class/method để framework tự động nhận diện và gọi đúng lúc — không cần bạn tự gọi thủ công.

## 2.6 Đa luồng (Multithreading) cơ bản

Minecraft server xử lý nhiều việc song song (world tick, network, plugin task...).

```java
Runnable task = () -> {
    System.out.println("Chạy tác vụ nền, không chặn main thread");
};
Thread thread = new Thread(task);
thread.start();
```

Trong Spigot, bạn thường dùng `BukkitScheduler` thay vì tự tạo `Thread` — sẽ học ở Chương 04.

## 2.7 Build tool: Gradle cơ bản

Forge/Fabric dùng Gradle để tải thư viện và build mod thành file `.jar`. File `build.gradle` khai báo:

```groovy
dependencies {
    implementation "net.minecraftforge:forge:1.20.1-47.2.0"
}
```

Bạn không cần viết Gradle từ đầu — các template mod (Chương 03) đã có sẵn, bạn chỉ chỉnh sửa.

## 2.8 Bài tập

1. Dùng `Map<String, Integer>` để lưu kho đồ (tên item → số lượng), viết hàm thêm/xóa vật phẩm.
2. Dùng Stream để lọc ra danh sách người chơi có điểm > 50 từ một `List<Player>`.
3. Viết một class custom Exception `NotEnoughGoldException` và ném (`throw`) nó khi số vàng không đủ.

Code mẫu: [`vi-du/AdvancedDemo.java`](./vi-du/AdvancedDemo.java)

➡️ Từ đây bạn đã đủ nền tảng Java để bước vào modding thật sự: [Chương 03 - Minecraft Mod với Forge](../03-minecraft-forge-mod)
