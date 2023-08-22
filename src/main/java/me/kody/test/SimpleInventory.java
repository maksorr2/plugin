package me.kody.test;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.Random;


public class SimpleInventory implements InventoryProvider, CommandExecutor {
        public static final SmartInventory INVENTORY = SmartInventory.builder()
                .id("myInventory")
                .provider(new SimpleInventory())
                .size(3, 9)
                .title(ChatColor.BLUE + "My Awesome Inventory!")
                .build();

        private final Random random = new Random();


    @Override
        public void init(Player player, InventoryContents contents) {
            contents.fillBorders(ClickableItem.empty(new ItemStack(Material.BLACK_STAINED_GLASS)));

            contents.set(1, 1, ClickableItem.of(new ItemStack(Material.GOLDEN_CARROT),
                    e -> player.sendMessage(ChatColor.GOLD + "You clicked on a potato.")));

            contents.set(1, 7, ClickableItem.of(new ItemStack(Material.BARRIER),
                    e -> player.closeInventory()));
        }

        @Override
        public void update(Player player, InventoryContents contents) {
            int state = contents.property("state", 0);
            contents.setProperty("state", state + 1);

            if(state % 5 != 0)
                return;

            short durability = (short) random.nextInt(15);

            ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS, 1, durability);
            contents.fillBorders(ClickableItem.empty(glass));
        }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (command.getName().equalsIgnoreCase("menu")){
               SimpleInventory.INVENTORY.open(((Player) sender).getPlayer());
            }
        }
        return true;
    }
}
