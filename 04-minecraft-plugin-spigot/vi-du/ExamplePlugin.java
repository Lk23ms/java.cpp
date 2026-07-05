// LƯU Ý: Cần project Maven/Gradle có dependency Paper/Spigot API để build & chạy thật.
// Xem README.md của chương này để setup pom.xml và plugin.yml.

package com.example.exampleplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin implements CommandExecutor, Listener {

    @Override
    public void onEnable() {
        getLogger().info("ExamplePlugin đã được bật!");
        saveDefaultConfig();

        // Đăng ký command "/heal" (nhớ khai báo trong plugin.yml)
        getCommand("heal").setExecutor(this);

        // Đăng ký listener sự kiện
        getServer().getPluginManager().registerEvents(this, this);

        // Tác vụ định kỳ: nhắc nhở mỗi 5 phút
        Bukkit.getScheduler().runTaskTimer(this, () ->
                Bukkit.broadcastMessage("[ExamplePlugin] Server vẫn đang chạy ổn định!"),
                0L, 20L * 60 * 5);
    }

    @Override
    public void onDisable() {
        getLogger().info("ExamplePlugin đã tắt!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("heal") && sender instanceof Player player) {
            player.setHealth(20.0);
            player.sendMessage("Bạn đã được hồi đầy máu!");
            return true;
        }
        return false;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(player.getName() + " vừa tham gia server!");
        player.sendMessage("Chào mừng bạn đến server!");
    }
}
