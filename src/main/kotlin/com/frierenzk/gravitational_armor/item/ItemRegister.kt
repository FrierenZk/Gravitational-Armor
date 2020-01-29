package com.frierenzk.gravitational_armor.item

import com.frierenzk.gravitational_armor.item.crafting.ItemCoolingCore
import com.frierenzk.gravitational_armor.item.crafting.ItemSuperconductor
import com.frierenzk.gravitational_armor.item.crafting.ItemSuperconductorCover
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

object ItemRegister {
    private val nameMap = mapOf(
            Pair("superconductorCover",Pair("superconductorCover","crafting/superconductor_cover")), //first one is language var name, and second one is model json name
            Pair("superconductor",Pair("superconductor","crafting/superconductor")),
            Pair("coolingCore",Pair("coolingCore","crafting/cooling_core"))
    )

    //val registMap = HashMap<String,Item>()

    val itemSuperconductorCover: Item = ItemSuperconductorCover().setUnlocalizedName((nameMap["superconductorCover"] ?: errorPuts("superconductorCover")).first)
    val itemSuperconductor:Item = ItemSuperconductor().setUnlocalizedName((nameMap["superconductor"] ?: errorPuts("superconductor")).first)
    val itemCoolingCore:Item = ItemCoolingCore().setUnlocalizedName((nameMap["coolingCore"] ?: errorPuts("coolingCore")).first)

    fun init(){
        //registMap["superconductorCover"] = ItemSuperconductorCover().setUnlocalizedName((nameMap["superconductorCover"] ?: errorPuts("superconductorCover")).first)
        //registMap["superconductor"] = ItemSuperconductorCover().setUnlocalizedName((nameMap["superconductor"] ?: errorPuts("superconductor")).first)
        //registMap["coolingCore"] = ItemSuperconductorCover().setUnlocalizedName((nameMap["coolingCore"] ?: errorPuts("coolingCore")).first)


        //for(i in registMap){
        //    ForgeRegistries.ITEMS.register(i.value.setRegistryName((nameMap[i.key]?: errorPuts(i.key)).second))
        //}

        ForgeRegistries.ITEMS.register(itemSuperconductorCover.setRegistryName((nameMap["superconductorCover"] ?: errorPuts("superconductorCover")).second))
        ForgeRegistries.ITEMS.register(itemSuperconductor.setRegistryName((nameMap["superconductor"] ?: errorPuts("superconductor")).second))
        ForgeRegistries.ITEMS.register(itemCoolingCore.setRegistryName((nameMap["coolingCore"] ?: errorPuts("coolingCore")).second))
    }

    @SideOnly(Side.CLIENT)
    fun clientInit() {
        //for(i in registMap){
        //   ModelLoader.setCustomModelResourceLocation(i.value,0,ModelResourceLocation(i.value.registryName!!,"inventory"))
        //}
        ModelLoader.setCustomModelResourceLocation(itemSuperconductorCover, 0, ModelResourceLocation(itemSuperconductorCover.registryName!!, "inventory"))
        ModelLoader.setCustomModelResourceLocation(itemSuperconductor, 0, ModelResourceLocation(itemSuperconductor.registryName!!, "inventory"))
        ModelLoader.setCustomModelResourceLocation(itemCoolingCore, 0, ModelResourceLocation(itemCoolingCore.registryName!!, "inventory"))
    }

    private fun errorPuts(args:String):Nothing {
        error("can't find $args in nameMap!")
    }
}