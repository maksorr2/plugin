package me.kody.test.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoin implements Listener {

    private final JavaPlugin plugin;

    public PlayerJoin(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void test(PlayerJoinEvent e){
        String path = String.join(".", "welcome");
        var test = plugin.getConfig().get(path, "welcome");
        Player player = e.getPlayer();
        e.setJoinMessage("\u0414\u043e\u0431\u0440\u043e \u043f\u043e\u0436\u0430\u043b\u043e\u0432\u0430\u0442\u044c " + test + "!");
    }
}
