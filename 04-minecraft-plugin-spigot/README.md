# Chương 04: Viết Plugin server với Spigot/Paper

## 4.1 Plugin khác Mod ở điểm gì?

| | Mod (Forge/Fabric) | Plugin (Spigot/Paper) |
|---|---|---|
| Chạy ở đâu | Client + Server | Chỉ Server |
| Người chơi cần cài gì? | Phải cài mod giống server | Không cần cài gì, chỉ cần join server |
| Khả năng | Thêm block/item/rendering mới hoàn toàn | Chỉnh sửa hành vi game bằng API có sẵn (không thêm block/item mới dễ dàng) |
| Dùng cho | Thay đổi sâu vào game | Server minigame, quản trị, kinh tế, chat... |

## 4.2 Setup dự án Plugin

1. Tải server **Paper** (khuyên dùng, tối ưu hơn Spigot gốc): https://papermc.io/downloads
2. Tạo project Java mới bằng Maven/Gradle, thêm dependency Paper API vào `pom.xml`:

```xml
<repositories>
    <repository>
        <id>papermc</id>
        <url>https://repo.papermc.io/repository/maven-public/</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>io.papermc.paper</groupId>
        <artifactId>paper-api</artifactId>
        <version>1.20.1-R0.1-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

3. Tạo file `plugin.yml` trong `src/main/resources/`:

```yaml
name: ExamplePlugin
version: 1.0
main: com.example.exampleplugin.ExamplePlugin
api-version: 1.20
```

## 4.3 Class Plugin chính

```java
public class ExamplePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("ExamplePlugin đã được bật!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ExamplePlugin đã tắt!");
    }
}
```

Build ra file `.jar` (dùng `mvn package`), thả vào thư mục `plugins/` của server, restart server.

## 4.4 Tạo Command (lệnh chat)

Đăng ký thêm trong `plugin.yml`:

```yaml
commands:
  heal:
    description: Hồi đầy máu cho người chơi
```

Xử lý command trong code:

```java
public class ExamplePlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("heal").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player.setHealth(20.0);
            player.sendMessage("Bạn đã được hồi đầy máu!");
            return true;
        }
        return false;
    }
}
```

## 4.5 Xử lý Event (sự kiện)

```java
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(player.getName() + " vừa tham gia server!");
        player.sendMessage("Chào mừng bạn đến server!");
    }
}
```

Đăng ký listener trong `onEnable()`:

```java
getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
```

## 4.6 Lưu dữ liệu (Config & File)

```java
@Override
public void onEnable() {
    saveDefaultConfig(); // tạo config.yml mặc định nếu chưa có
    int spawnX = getConfig().getInt("spawn.x", 0);
}
```

File `config.yml`:

```yaml
spawn:
  x: 100
  y: 65
  z: 100
```

## 4.7 Chạy tác vụ định kỳ (Scheduler) — thay cho Thread thủ công

```java
Bukkit.getScheduler().runTaskTimer(this, () -> {
    Bukkit.broadcastMessage("Server sẽ restart sau 5 phút!");
}, 0L, 20L * 60 * 5); // chạy mỗi 5 phút (20 tick = 1 giây)
```

## 4.8 Bài tập thực hành

1. Viết command `/tpheal` — dịch chuyển người chơi về spawn và hồi máu.
2. Viết listener: khi người chơi chết, thông báo cho toàn server kèm tọa độ chết.
3. Lưu điểm số người chơi vào file YAML, viết lệnh `/score` để xem điểm.

## 4.9 Tài liệu tham khảo

- Paper API Docs: https://docs.papermc.io/
- SpigotMC Wiki: https://www.spigotmc.org/wiki/

➡️ Tiếp theo: [Chương 05 - Minecraft Client Modding với Fabric](../05-minecraft-fabric-client)
