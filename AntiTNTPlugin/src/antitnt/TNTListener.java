package antitnt;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TNTListener implements Listener {
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getClickedBlock().getType().equals(Material.TNT) && e.getItem().getType().equals(Material.FLINT_AND_STEEL)) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBBlockRedstoneEvent(BlockRedstoneEvent e) {
		System.out.print("Redstone");
		if(e.getBlock().getType().equals(Material.TNT)) {
			System.out.print("TNT");
			e.setNewCurrent(0);
		}
	}
	
	@EventHandler
	public void onEntityExplodeEvent(EntityExplodeEvent e) {
		if (e.getEntityType().equals(EntityType.PRIMED_TNT) && Main.pluginActivated){
			e.setCancelled(true);
		}
	}
	
	
}
