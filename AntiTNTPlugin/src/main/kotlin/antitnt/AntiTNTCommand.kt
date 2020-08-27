package antitnt

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class AntiTNTCommand:CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        var done = false

        if (args.size == 1) {
            if (args[0].equals("enable",true)) {
                Config.pluginActivated = true
                done = true
                sender.sendMessage("TNT Plugin is now enabled")
            } else if (args[0].equals("disable",true)) {
                Config.pluginActivated = false
                done = true
                sender.sendMessage("TNT Plugin is now disabled")
            }
        }

        if (args.size == 2) {
            if (args[0].equals("ignite",true)) {
                if (args[1].equals("false",true)) {
                    Config.canIgnite = false
                    done = true
                    sender.sendMessage("TNT is not flammable")
                } else if (args[1].equals("true",true)) {
                    Config.canIgnite = true
                    done = true
                    sender.sendMessage("TNT is now flammable")
                }
            }
        }

        if (!done) {
            sender.sendMessage(ChatColor.BOLD.toString() + "" + ChatColor.RED + "Wrong input /TNT [true,false]")
        }

        return true
    }
}