package pl.notpiotrekdev.zombiessurvive.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.notpiotrekdev.zombiessurvive.Zombies_survive;

import java.util.EventListener;

public class menu implements CommandExecutor, EventListener, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("[ZombiesSurvive] Only players can execute this command!");
            return false;
        } else {
            Inventory inv;
            inv = Bukkit.createInventory(null, 9, ChatColor.RED + "Zombies Survive" + ChatColor.GRAY + " | " + ChatColor.GREEN + "Settings");
            ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.RED + "");
            item.setItemMeta(meta);
            inv.setItem(0, item);
            ((Player) sender).openInventory(inv);

            return true;
        }
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Zombies Survive" + ChatColor.GRAY + " | " + ChatColor.GREEN + "Settings")) {
            if (e.getCurrentItem() == null) {
                return;
            }

            if (e.getRawSlot() == 0) {
                // Perform your action here
                e.getWhoClicked().sendMessage("You clicked slot 0!");

                // Cancel the event to prevent the item from being moved (optional)
                e.setCancelled(true);
            }

            e.setCancelled(true);
        }
    }

}
