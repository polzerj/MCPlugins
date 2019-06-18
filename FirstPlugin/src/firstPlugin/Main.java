package firstPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		super.onEnable();
		
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label,String[] args) {
		if(command.getName().equalsIgnoreCase("Jonny")) {
			sender.sendMessage("Du bist cool");
			if (sender instanceof Player) {
				Player p = (Player)sender;
				//p.getInventory().addItem(new )
			}
		}
		return false;
	}
}
