package com.frierenzk.gravitational_armor.item.armor

import com.frierenzk.gravitational_armor.core.GACreativeTab
import ic2.core.item.armor.ItemArmorElectric
import ic2.core.ref.ItemName
import net.minecraft.entity.Entity
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.EnumRarity
import net.minecraft.item.ItemStack


class ItemUltimateLapPack: ItemArmorElectric(null,null,EntityEquipmentSlot.CHEST, 6.0E7, 100000.0,4) {
    init {
        creativeTab = GACreativeTab.tab
    }

    override fun registerModels(name: ItemName?) {}

    override fun getArmorTexture(stack: ItemStack?, entity: Entity?, slot: EntityEquipmentSlot?, type: String?) = "gravitational_armor:textures/armor/ultimate_lap_pack.png"

    override fun canProvideEnergy(stack: ItemStack?) = true

    override fun getEnergyPerDamage() = 0

    override fun getDamageAbsorptionRatio() = 0.0

    override fun getRarity(stack: ItemStack) = EnumRarity.RARE
}