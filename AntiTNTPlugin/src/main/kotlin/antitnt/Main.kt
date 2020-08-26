package antitnt

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }

    override fun onEnable() {
        var pManager = server.pluginManager

        pManager.registerEvents(TNTListener(), this)
        plugin = this
        loadConfig()
        Config.pluginActivated = config.getBoolean("config.PluginEnabled")
        Config.canIgnite = config.getBoolean("config.CanIgnite")
        getCommand("antiTNT")?.tabCompleter = AutocompleteListener()
        getCommand("antiTNT")?.setExecutor(AntiTNTCommand())

    }

    override fun onDisable() {
        config.set("config.PluginEnabled", Config.pluginActivated)
        config.set("config.CanIgnite", Config.canIgnite);
        saveConfig();
    }

    private fun loadConfig() {
        config.options().copyDefaults(true)
        saveConfig()
    }
}