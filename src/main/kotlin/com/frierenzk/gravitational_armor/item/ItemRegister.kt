package com.frierenzk.gravitational_armor.item

import com.frierenzk.gravitational_armor.item.crafting.ItemCoolingCore
import com.frierenzk.gravitational_armor.item.crafting.ItemGravitationEngine
import com.frierenzk.gravitational_armor.item.crafting.ItemSuperconductor
import com.frierenzk.gravitational_armor.item.crafting.ItemSuperconductorCover
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

object ItemRegister {
    private val nameMap = mapOf(
            Pair("superconductorCover", "crafting/superconductor_cover"), //first one is language var name, and second one is model json name
            Pair("superconductor", "crafting/superconductor"),
            Pair("coolingCore", "crafting/cooling_core"),
            Pair("gravitationEngine", "crafting/gravitation_engine"),
            Pair("gravitationArmor","gravitation_armor")
    )

    private val registerMap = HashMap<String, Item>()
    lateinit var creativeTabIcon:ItemStack

    fun init() {
        registerMap["superconductorCover"] = ItemSuperconductorCover().setUnlocalizedName("superconductorCover")
        registerMap["superconductor"] = ItemSuperconductor().setUnlocalizedName("superconductor")
        registerMap["coolingCore"] = ItemCoolingCore().setUnlocalizedName("coolingCore")
        registerMap["gravitationEngine"] = ItemGravitationEngine().setUnlocalizedName("gravitationEngine")

        registerMap["gravitationArmor"] = ItemGravitationEngine().setUnlocalizedName("gravitationArmor")
        //Other items
        // registerMap["xxx"] = ItemSuperconductorCover().setUnlocalizedName("xxx")

        creativeTabIcon = ItemStack(registerMap["gravitationArmor"]!!)

        for (i in registerMap) {
            ForgeRegistries.ITEMS.register(i.value.setRegistryName((nameMap[i.key] ?: errorPuts(i.key))))
        }
    }

    @SideOnly(Side.CLIENT)
    fun clientInit() {
        for (i in registerMap) {
            ModelLoader.setCustomModelResourceLocation(i.value, 0, ModelResourceLocation(i.value.registryName!!, "inventory"))
        }
    }

    fun getItems(name:String):Item {
        return registerMap[name]!!
    }

    private fun errorPuts(args: String): Nothing {
        error("can't find $args in nameMap!")
    }
}