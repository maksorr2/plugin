package me.kody.test;

import me.kody.test.commands.Reloads;
import me.kody.test.handlers.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Test extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getCommand("rel").setExecutor(new Reloads(this));
        getCommand("menu").setExecutor(new SimpleInventory());

    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
        getLogger().info("Disabling...");
    }
}
