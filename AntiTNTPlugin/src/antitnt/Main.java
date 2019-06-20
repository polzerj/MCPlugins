package antitnt;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    static Main main;
    boolean pluginActivated = true;
    boolean canIgnite = true;

    @Override
    public void onEnable() {
        // Setup Manager
        PluginManager pManager = getServer().getPluginManager();
        // Create Listener
        pManager.registerEvents(new TNTListener(), this);
        main = this;
        loadConfig();
        pluginActivated = getConfig().getBoolean("config.PluginEnabled");
        canIgnite = getConfig().getBoolean("config.CanIgnite");
        getCommand("tnt").setTabCompleter(new AutocompleteListener());
    }


    @Override
    public void onDisable() {
        getConfig().set("config.PluginEnabled", pluginActivated);
        getConfig().set("config.CanIgnite", canIgnite);
        saveConfig();
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getLabel().equalsIgnoreCase("TNT")) {
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
                sender.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "Eingabe ungültig /TNT [true,false]");
            }

            return true;
        }

        return false;
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
