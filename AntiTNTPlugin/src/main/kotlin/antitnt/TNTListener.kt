package antitnt

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityExplodeEvent


class TNTListener : Listener {
    @EventHandler
    fun onEntityAddToWorld(e: EntityAddToWorldEvent) {
        if (e.entityType == EntityType.PRIMED_TNT && Config.pluginActivated && !Config.canIgnite) {
            //println("TNT was added to world");
            val loc = e.entity.location
            e.entity.remove()
            Bukkit.getServer().scheduler.scheduleSyncDelayedTask(
                Main.plugin,
                {
                    loc.world.getBlockAt(loc).setType(Material.TNT, false)
                },
                1L
            )
        }
    }

    @EventHandler
    fun onEntityExplodeEvent(e: EntityExplodeEvent) {
        if (e.entityType == EntityType.PRIMED_TNT && Config.pluginActivated) {
            e.isCancelled = true
        }
    }
}