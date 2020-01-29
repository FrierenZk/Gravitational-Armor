package com.frierenzk.gravitational_armor.item.armor

import ic2.api.item.ElectricItem
import ic2.core.item.armor.ItemArmorElectric
import ic2.core.item.armor.jetpack.IJetpack
import ic2.core.ref.ItemName
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.EnumRarity
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class ItemGravitationArmor :ItemArmorElectric(null,null, EntityEquipmentSlot.CHEST, 6.0E7, 100000.0,4),IJetpack {
    override fun getEnergyPerDamage() = 20000

    override fun getDamageAbsorptionRatio() = 0.8

    override fun isJetpackActive(p0: ItemStack?) = true

    override fun getChargeLevel(stack: ItemStack?) = ElectricItem.manager.getCharge(stack) / this.getMaxCharge(stack);

    override fun getPower(p0: ItemStack?) = 1.5f

    override fun drainEnergy(stack: ItemStack?, amount: Int): Boolean = ElectricItem.manager.discharge(stack, (amount+6).toDouble(), 2147483647, true, false, false) > 0.0

    override fun getDropPercentage(p0: ItemStack?) = 0.05f

    override fun getHoverMultiplier(p0: ItemStack?, p1: Boolean) = 1.0f

    override fun getWorldHeightDivisor(p0: ItemStack?) = 0.9f

    override fun registerModels(name: ItemName?) {}

    override fun getArmorTexture(stack: ItemStack?, entity: Entity?, slot: EntityEquipmentSlot?, type: String?) = "gravitational_armor:textures/armor/gravitation_armor.png"

    override fun canProvideEnergy(stack: ItemStack?) = true

    override fun onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack) {
        super.onArmorTick(world, player, itemStack)
        player.extinguish()
    }

    override fun getRarity(stack: ItemStack) = EnumRarity.EPIC
}