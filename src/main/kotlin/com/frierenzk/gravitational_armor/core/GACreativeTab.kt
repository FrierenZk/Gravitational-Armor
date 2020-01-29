package com.frierenzk.gravitational_armor.core

import com.frierenzk.gravitational_armor.item.ItemRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class GACreativeTab: CreativeTabs("gravitation_armor") {
    companion object{
        val tab = GACreativeTab()
    }
    override fun getTabIconItem(): ItemStack {
        return ItemRegister.creativeTabIcon
    }
}