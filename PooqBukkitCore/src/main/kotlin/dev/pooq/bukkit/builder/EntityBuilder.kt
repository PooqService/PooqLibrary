package dev.pooq.bukkit.builder

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity
import org.bukkit.metadata.MetadataValue
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.potion.PotionEffect
import org.bukkit.util.Consumer
import org.bukkit.util.Vector
import org.jetbrains.annotations.NotNull

class EntityBuilder(private val entity: LivingEntity) {

  companion object Of{
    fun of(entity: LivingEntity): EntityBuilder {
      return EntityBuilder(entity)
    }
    
    fun of(type: EntityType, location: Location) : EntityBuilder{
      return EntityBuilder(location.world.spawnEntity(location, type) as LivingEntity)
    }
  }

  fun withPassenger(@NotNull passenger: List<Entity>): EntityBuilder {
    for(e in passenger){
      entity.addPassenger(e)
    }

    return this
  }

  fun withScoreboardTag(@NotNull tag: String): EntityBuilder {
    entity.addScoreboardTag(tag)
    return this
  }

  fun withVelocity(@NotNull velocity: Vector): EntityBuilder {
    entity.velocity = velocity
    return this
  }

  fun withRotation(yaw: Float, pitch: Float): EntityBuilder {
    entity.setRotation(yaw, pitch)
    return this
  }

  fun withFireTicks(ticks: Int): EntityBuilder {
    entity.fireTicks = ticks
    return this
  }

  fun isPersistent(persistent: Boolean): EntityBuilder {
    entity.isPersistent = persistent
    return this
  }

  fun withFallDistance(distance: Float): EntityBuilder {
    entity.fallDistance = distance
    return this
  }

  fun withTicksLived(value: Int): EntityBuilder {
    entity.ticksLived = value
    return this
  }

  fun withVisibleCustomName(flag: Boolean): EntityBuilder {
    entity.isCustomNameVisible = flag
    return this
  }

  fun withGlowing(flag: Boolean): EntityBuilder {
    entity.isGlowing = flag
    return this
  }

  fun asInvulnerable(flag: Boolean): EntityBuilder {
    entity.isInvulnerable = flag
    return this
  }

  fun asSilent(flag: Boolean): EntityBuilder {
    entity.isSilent = flag
    return this
  }

  fun withGravity(gravity: Boolean): EntityBuilder {
    entity.setGravity(gravity)
    return this
  }

  fun withMetadata(metadataKey: String, newMetadataValue: MetadataValue): EntityBuilder {
    entity.setMetadata(metadataKey, newMetadataValue)
    return this
  }

  fun withCustomName(@NotNull name: String): EntityBuilder {
    entity.customName(MiniMessage.miniMessage().deserialize(name))
    return this
  }

  fun withNBT(change: Consumer<PersistentDataContainer?>): EntityBuilder {
    change.accept(entity.persistentDataContainer)
    return this
  }
  
  fun withPotionEffect(effect: PotionEffect): EntityBuilder {
    entity.addPotionEffect(effect)
    return this
  }
  
  fun withAI(ai: Boolean): EntityBuilder {
    entity.setAI(ai)
    return this
  }

  fun with(entityConsumer: Consumer<LivingEntity?>): EntityBuilder {
    entityConsumer.accept(entity)
    return this
  }

  fun setCollidable(collidable: Boolean): EntityBuilder {
    entity.isCollidable = collidable
    return this
  }

  fun setInvisible(invisible: Boolean): EntityBuilder {
    entity.isInvisible = invisible
    return this
  }

  fun withHealth(health: Double): EntityBuilder {
    entity.health = health
    return this
  }

  fun withAbsorptionAmount(amount: Double): EntityBuilder {
    entity.absorptionAmount = amount
    return this
  }

  fun <T : LivingEntity> build(): T {
    return entity as T
  }
}