package antitnt;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class TNTListener implements Listener {
	/*@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (!Main.canIgnite&&Main.pluginActivated) {
			if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				if (e.getClickedBlock().getType().equals(Material.TNT)
						&& e.getItem().getType().equals(Material.FLINT_AND_STEEL)) {
					e.setCancelled(true);
				}
			}
		}
	}

	@EventHandler
	public void onExplosionPrime(ExplosionPrimeEvent e){
		if (e.getEntityType().equals(EntityType.PRIMED_TNT) && Main.pluginActivated) {
			e.setCancelled(true);
		}
	}*/

	@EventHandler
	public void onEntityAddToWorld(EntityAddToWorldEvent e){
		if(e.getEntityType().equals(EntityType.PRIMED_TNT)&&Main.pluginActivated&&!Main.canIgnite){
			//System.out.println("TNT was added to world");
			Location loc = e.getEntity().getLocation();

			e.getEntity().remove();
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.main, new Runnable() {
				@Override
				public void run() {
					loc.getWorld().getBlockAt(loc).setType(Material.TNT,false);
				}
			}, 1L);

		}
	}

	@EventHandler
	public void onEntityExplodeEvent(EntityExplodeEvent e) {
		if (e.getEntityType().equals(EntityType.PRIMED_TNT) && Main.pluginActivated) {
			e.setCancelled(true);
		}
	}

}
