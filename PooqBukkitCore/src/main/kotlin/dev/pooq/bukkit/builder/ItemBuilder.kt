package dev.pooq.bukkit.builder

import net.axay.kspigot.items.customModel
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeModifier
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataType
import org.jetbrains.annotations.NotNull

class ItemBuilder(material: Material = Material.STONE, amount: Int = 1, itemStack: ItemStack = ItemStack(material)){

  private var itemMeta: ItemMeta
  private var itemStack: ItemStack = ItemStack(material, amount)

  companion object Of{
    fun of(itemStack: ItemStack) : ItemBuilder{
      return ItemBuilder(itemStack = itemStack)
    }
  }

  init {
    itemMeta = itemStack.itemMeta
  }

  fun withName(@NotNull name: String) : ItemBuilder{
    itemMeta.displayName(MiniMessage.miniMessage().deserialize(name))
    return this
  }

  fun withEnchantments(@NotNull map: Map<Enchantment, Int>): ItemBuilder {
    itemStack.addUnsafeEnchantments(map)
    return this
  }

  fun withEnchantment(@NotNull enchantment: Enchantment, level: Int): ItemBuilder {
    itemStack.addUnsafeEnchantment(enchantment, level)
    return this
  }

  fun withLore(@NotNull lore: List<String>): ItemBuilder {
    val list = ArrayList<Component>()

    for(s in lore){
      list.add(MiniMessage.miniMessage().deserialize(s))
    }

    itemMeta.lore(list)
    return this
  }

  fun withItemFlags(@NotNull flags: List<ItemFlag>): ItemBuilder {
    for(f in flags){
      itemMeta.addItemFlags(f)
    }

    return this
  }

  fun isUnbreakable(breakable: Boolean): ItemBuilder {
    itemMeta.isUnbreakable = breakable
    return this
  }

  fun withAttributeModifier(@NotNull attribute: Attribute, @NotNull modifier: AttributeModifier): ItemBuilder {
    itemMeta.addAttributeModifier(attribute, modifier)
    return this
  }

  fun withItemFlag(@NotNull flag: ItemFlag): ItemBuilder {
    itemMeta.addItemFlags(flag)
    return this
  }

  fun <T, Z> withDataContainer(@NotNull key: NamespacedKey, @NotNull containerType: PersistentDataType<T, Z>, @NotNull value: Z): ItemBuilder {
    itemMeta.persistentDataContainer.set(key, containerType, value)
    return this
  }

  fun withCustomModelData(data: Int): ItemBuilder {
    itemMeta.customModel = data
    return this
  }

  fun build(): ItemStack{
    itemStack.itemMeta = itemMeta
    return itemStack
  }
}