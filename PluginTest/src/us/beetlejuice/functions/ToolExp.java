package us.beetlejuice.functions;

import java.util.ArrayList;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import us.beetlejuice.Util;

public class ToolExp {
	private static int LEVELING_CONSTANT = 100;
	/**
	 * Function:
	 * Each time a block is broken with a valid tool (see util.java), that tool gains
	 * experience, and once the tool has gained enough experience, another level of
	 * Efficiency is added to the tool's enchantment list.
	 * @param e BlockUpdateEvent which triggers this code.
	 */
	public static void toolExp(BlockBreakEvent e) {
		
		if(Util.isTool(e.getPlayer().getInventory().getItemInMainHand())) {
			/*
			 * INTITIAL SETUP OF VARIABLES
			 */
			//item and metadata
			ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
			ItemMeta meta = item.getItemMeta();
			//vars used by program.
			int toolLevel = item.getEnchantmentLevel(Enchantment.DIG_SPEED); //tool's current level determined by current enchantment level
			int xpToGet = LEVELING_CONSTANT * (toolLevel + 1); //xp to earn to level up, proportional to the leveling constant and tool's current level
			int toolXP = 0; // tool's current xp. initialized to 0 to avoid errors
			
			/*
			 * sets up tool's current xp based on its metadata (if exists), otherwise, xp is still 0.
			 */	
			if (toolLevel <= 4 && meta.hasLore()) {
				toolXP = Integer.parseInt(meta.getLore().get(0));
			}
			
			
		
			ArrayList<String> data = new ArrayList<String>(); //storage for metadata to add to the item
			
			/*
			 * If the item is a tool, add XP to it.
			 */
			
			data.clear(); // clears list from previous call, makes sure no duplication happens
			toolXP++;
			String XP = String.valueOf(toolXP);
				
			//adds item lore to be shown and used
			data.add(XP);
			data.add("level " + toolLevel);
			data.add(toolXP + "/" + xpToGet + "XP");
			//sets metadata for next time
			meta.setLore(data);
			item.setItemMeta(meta);
			
			
			//tool level up, xp increases based on tool's current level and set constant.
			if(toolXP % xpToGet == 0) {
				meta = item.getItemMeta();
				meta.addEnchant(Enchantment.DIG_SPEED, toolLevel + 1, true);
				toolXP = 0;
				toolLevel++;
				
				data.clear();
				data.add("0");
				data.add("level " + toolLevel);
				data.add(toolXP + "/" + xpToGet + "XP");
				meta.setLore(data);
				item.setItemMeta(meta);
				e.getPlayer().sendMessage("Congrats! Your tool is now level " + toolLevel);
			}
			
			/*
			 * final case if tool is max level, deal with that.
			 */
			if (toolLevel == 5) {
				meta = item.getItemMeta();
				data.clear();
				data.add("level 5");
				data.add(0 + "/" + 0 + "XP");
				data.add("Max Level");
				meta.setLore(data);
				item.setItemMeta(meta);
			}
		}
	}
}
