package antitnt

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.util.StringUtil


class AutocompleteListener : TabCompleter {
    private val FIRST_LVL_COMMANDS = arrayOf( "ignite", "enable", "disable")

    override fun onTabComplete(sender: CommandSender, cmd: Command, alias: String, args: Array<out String>): MutableList<String>  {
        //create new array
        val completions = mutableListOf<String>()
        //copy matches of first argument from list (ex: if first arg is 'm' will return just 'minecraft'
        var prop = FIRST_LVL_COMMANDS.toMutableList()
        if (args[0].equals("ignite", ignoreCase = true)  ) {
            if (args.size>2)return mutableListOf<String>()
            prop = mutableListOf("true","false")
        }else if (args.size>1) return mutableListOf<String>()
        StringUtil.copyPartialMatches(args.last(), prop, completions)
        //sort the list
        completions.sort()
        return completions
    }
}
