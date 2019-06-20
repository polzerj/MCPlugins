package antitnt;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class AutocompleteListener implements TabCompleter {

    private static final String[] COMMANDS = { "ignite", "true", "false" };

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        //create new array
        final List<String> completions = new ArrayList<>();
        //copy matches of first argument from list (ex: if first arg is 'm' will return just 'minecraft'
        List<String> prop =Arrays.asList(COMMANDS);
        if ( args[0].equalsIgnoreCase("ignite")){
            prop=Arrays.asList(Arrays.copyOfRange( COMMANDS,1,3));
        }
        StringUtil.copyPartialMatches(args[args.length-1], prop , completions);
        //sort the list
        Collections.sort(completions);
        return completions;
    }
}
