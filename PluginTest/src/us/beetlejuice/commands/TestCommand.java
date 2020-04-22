package us.beetlejuice.commands;

import org.bukkit.command.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.isOp()) {
				p.getInventory().
				getItemInMainHand().
				addEnchantment(Enchantment.DIG_SPEED, Integer.parseInt(args[0]));
			} else {
				p.sendMessage("You do not have permission to perform this command.");
				return false;
			}
		}
		return false;
	}
}
