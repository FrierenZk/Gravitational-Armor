package com.frierenzk.gravitational_armor.item.armor

import ic2.core.item.armor.ItemArmorElectric
import ic2.core.item.armor.jetpack.IJetpack
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.ItemStack

class ItemGraviChestPlate :ItemArmorElectric(null,null, EntityEquipmentSlot.CHEST, 6.0E7, 100000.0,4),IJetpack {
    override fun getEnergyPerDamage(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDamageAbsorptionRatio(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isJetpackActive(p0: ItemStack?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChargeLevel(p0: ItemStack?): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPower(p0: ItemStack?): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun drainEnergy(p0: ItemStack?, p1: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDropPercentage(p0: ItemStack?): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHoverMultiplier(p0: ItemStack?, p1: Boolean): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWorldHeightDivisor(p0: ItemStack?): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}