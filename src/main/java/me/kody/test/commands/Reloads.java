package me.kody.test.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Reloads implements CommandExecutor {
    private final JavaPlugin plugin;

    public Reloads(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (command.getName().equalsIgnoreCase("rel")){
                String path = String.join(".", "welcome");
                var test = plugin.getConfig().getString(path,"welcome");
                sender.sendMessage(test);
                plugin.reloadConfig();
                plugin.saveConfig();
            }
        }
        return true;
    }
}
