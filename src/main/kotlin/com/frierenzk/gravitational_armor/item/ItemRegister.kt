package com.frierenzk.gravitational_armor.item

import com.frierenzk.gravitational_armor.item.crafting.ItemSuperconductorCover
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

object ItemRegister {
    private val nameMap = mapOf(
            Pair("superconductorCover","crafting/superconductor_cover"), //first one is language var name, and second one is model json name
            Pair("superconductor","crafting/superconductor"),
            Pair("coolingCore","crafting/cooling_core"),
            Pair("gravitationEngine","crafting/gravitation_engine")
    )

    private val registerMap = HashMap<String,Item>()

    fun init(){
        registerMap["superconductorCover"] = ItemSuperconductorCover().setUnlocalizedName("superconductorCover")
        registerMap["superconductor"] = ItemSuperconductorCover().setUnlocalizedName("superconductor")
        registerMap["coolingCore"] = ItemSuperconductorCover().setUnlocalizedName("coolingCore")
        registerMap["gravitationEngine"] = ItemSuperconductorCover().setUnlocalizedName("gravitationEngine")

        for(i in registerMap){
            ForgeRegistries.ITEMS.register(i.value.setRegistryName((nameMap[i.key]?: errorPuts(i.key))))
        }
    }

    @SideOnly(Side.CLIENT)
    fun clientInit() {
        for(i in registerMap){
           ModelLoader.setCustomModelResourceLocation(i.value,0,ModelResourceLocation(i.value.registryName!!,"inventory"))
        }
    }

    private fun errorPuts(args:String):Nothing {
        error("can't find $args in nameMap!")
    }
}