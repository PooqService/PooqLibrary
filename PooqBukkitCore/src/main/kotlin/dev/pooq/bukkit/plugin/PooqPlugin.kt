package dev.pooq.bukkit.plugin

import net.axay.kspigot.event.register
import net.axay.kspigot.extensions.bukkit.kill
import org.bukkit.Bukkit
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.loot.LootTable
import org.bukkit.plugin.java.JavaPlugin
import java.util.*
import kotlin.collections.ArrayList

class PooqPlugin : JavaPlugin(), Listener{

  private val blockMarkers: ArrayList<LivingEntity> = ArrayList()

  fun addBlockMarker(entity: LivingEntity){
    blockMarkers.add(entity)
  }

  fun removeBlockMarkers(){
    for(e in blockMarkers){
      e.kill()
    }
  }

  override fun onEnable() {
    Bukkit.getPluginManager().registerEvents(this, this)
  }

  @EventHandler
  fun onEntityDeath(event: EntityDeathEvent){
    if(!blockMarkers.contains(event.entity)){
      return
    }

    event.drops.clear()
    event.droppedExp = 0
    event.setShouldPlayDeathSound(false)
  }

}