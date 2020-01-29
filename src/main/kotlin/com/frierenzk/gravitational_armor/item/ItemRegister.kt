package com.frierenzk.gravitational_armor.item

import com.frierenzk.gravitational_armor.item.armor.ItemGravitationArmor
import com.frierenzk.gravitational_armor.item.armor.ItemUltimateLapPack
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
            Pair(ItemName.superconductorCover.name, "crafting/superconductor_cover"), //first one is language var name, and second one is model json name
            Pair(ItemName.superconductor.name, "crafting/superconductor"),
            Pair(ItemName.coolingCore.name, "crafting/cooling_core"),
            Pair(ItemName.gravitationEngine.name, "crafting/gravitation_engine"),
            Pair(ItemName.ultimateLapPack.name, "ultimate_lap_pack"),
            Pair(ItemName.gravitationArmor.name, "gravitation_armor")
    )

    private val registerMap = HashMap<String, Item>()
    lateinit var creativeTabIcon: ItemStack

    fun init() {
        registerMap[ItemName.superconductorCover.name] = ItemSuperconductorCover().setUnlocalizedName(ItemName.superconductorCover.name)
        registerMap[ItemName.superconductor.name] = ItemSuperconductor().setUnlocalizedName(ItemName.superconductor.name)
        registerMap[ItemName.coolingCore.name] = ItemCoolingCore().setUnlocalizedName(ItemName.coolingCore.name)
        registerMap[ItemName.gravitationEngine.name] = ItemGravitationEngine().setUnlocalizedName(ItemName.gravitationEngine.name)

        registerMap[ItemName.ultimateLapPack.name] = ItemUltimateLapPack().setUnlocalizedName(ItemName.ultimateLapPack.name)
        registerMap[ItemName.gravitationArmor.name] = ItemGravitationArmor().setUnlocalizedName(ItemName.gravitationArmor.name)
        //Other items
        // registerMap["xxx"] = ItemSuperconductorCover().setUnlocalizedName("xxx")

        creativeTabIcon = ItemStack(registerMap[ItemName.gravitationArmor.name]!!)

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

    fun getItems(name: String): Item {
        return registerMap[name]!!
    }

    private fun errorPuts(args: String): Nothing {
        error("can't find $args in nameMap!")
    }
}