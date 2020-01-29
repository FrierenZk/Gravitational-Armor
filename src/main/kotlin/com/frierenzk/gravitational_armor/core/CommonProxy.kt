package com.frierenzk.gravitational_armor.core

import com.frierenzk.gravitational_armor.item.ItemRegister
import com.frierenzk.gravitational_armor.recipe.CraftingRecipe
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

open class CommonProxy {
    open fun preInit(event: FMLPreInitializationEvent) {
        ItemRegister.init()
    }

    open fun init(event: FMLInitializationEvent) {
        CraftingRecipe.addCraftingRecipes()
    }
}