package us.beetlejuice;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import org.bukkit.plugin.java.JavaPlugin;
import us.beetlejuice.commands.*;
import us.beetlejuice.functions.*;

public class PluginTest extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		this.getCommand("TestCommand").setExecutor(new TestCommand());
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	/**
	 * On a block break event, do the following:
	 * Tool Experience Function
	 * @param e BlockBreakEvent that causes the code to run.
	 */
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		ToolExp.toolExp(e);
	}
		
	
}
