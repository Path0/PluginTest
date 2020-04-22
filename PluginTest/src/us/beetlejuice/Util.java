package us.beetlejuice;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Util {

	public static Material[] woodenTools = {
			Material.WOODEN_AXE, 
			Material.WOODEN_HOE, 
			Material.WOODEN_PICKAXE,
			Material.WOODEN_SHOVEL, 
			Material.WOODEN_SWORD
	};
	
	public static Material[] stoneTools = {
			Material.STONE_AXE,
			Material.STONE_HOE,
			Material.STONE_PICKAXE,
			Material.STONE_SHOVEL,
			Material.STONE_SWORD,
	};
	
	public static Material[] ironTools = {
			Material.IRON_AXE,
			Material.IRON_HOE,
			Material.IRON_PICKAXE,
			Material.IRON_SHOVEL,
			Material.IRON_SWORD
	};
	
	public static Material[] goldTools = {
			Material.GOLDEN_AXE,
			Material.GOLDEN_HOE,
			Material.GOLDEN_PICKAXE,
			Material.GOLDEN_SHOVEL,
			Material.GOLDEN_SWORD
	};
	
	public static Material[] diamondTools = {
		Material.DIAMOND_AXE,
		Material.DIAMOND_HOE,
		Material.DIAMOND_PICKAXE,
		Material.DIAMOND_SHOVEL,
		Material.DIAMOND_SWORD
	};
	
	public static Material[][] tools = {
		woodenTools,
		stoneTools,
		ironTools,
		goldTools,
		diamondTools
	};
	
	public static boolean isTool(ItemStack i) {
		for(Material[] mat : tools) {
			for(Material m : mat) {
				if(i.getType().equals(m)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
