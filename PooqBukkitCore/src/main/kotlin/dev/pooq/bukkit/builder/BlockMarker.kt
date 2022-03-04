package dev.pooq.bukkit.builder

import dev.pooq.bukkit.plugin.PooqPlugin
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.entity.EntityType
import org.bukkit.entity.Shulker

class BlockMarker(private val location: Location, private val plugin: PooqPlugin) {

  private val block: Block = location.block

  fun markWithColor(color: NamedTextColor = NamedTextColor.WHITE){

    val shulker = EntityBuilder.of(EntityType.SHULKER, location)
      .withAI(false)
      .asInvulnerable(true)
      .asSilent(true)
      .setCollidable(false)
      .setInvisible(true)
      .withGlowing(true)
      .build<Shulker>()

    val team = Bukkit.getScoreboardManager().newScoreboard.registerNewTeam(shulker.uniqueId.toString())
    team.color(color)
    team.addEntity(shulker)
  }
}