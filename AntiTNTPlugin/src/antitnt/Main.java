package antitnt;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {

	static boolean pluginActivated = true;
	static boolean canIgnite = true;

	static Main main;

	@Override
	public void onEnable() {
		// Setup Manager
		PluginManager pManager = getServer().getPluginManager();
		// Create Listener
		pManager.registerEvents(new TNTListener(), this);
		main = this;
	}

	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("TNT")) {
			boolean done = false;

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("false")) {
					pluginActivated = true;
					done = true;
					sender.sendMessage("TNT Plugin is now enabled");
				} else if (args[0].equalsIgnoreCase("true")) {
					pluginActivated = false;
					done = true;
					sender.sendMessage("TNT Plugin is now disabled");
				}
			}

			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("ignite")) {
					if (args[1].equalsIgnoreCase("false")) {
						canIgnite = false;
						done = true;
						sender.sendMessage("TNT is not flammable");
					} else if (args[1].equalsIgnoreCase("true")) {
						canIgnite = true;
						done = true;
						sender.sendMessage("TNT is now flammable");
					}
				}
			}

			if (!done) {
				sender.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "Eingabe ung�ltig /TNT [true,false]");
			}

			return true;
		}

		return false;
	}
}
