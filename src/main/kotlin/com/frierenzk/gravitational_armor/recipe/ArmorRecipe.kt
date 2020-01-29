package com.frierenzk.gravitational_armor.recipe

import com.frierenzk.gravitational_armor.GravitationalArmor
import com.frierenzk.gravitational_armor.item.ItemName
import com.frierenzk.gravitational_armor.item.ItemRegister
import ic2.api.item.IC2Items
import ic2.core.item.type.CraftingItemType
import ic2.core.ref.TeBlock
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.GameRegistry

object ArmorRecipe {
    fun addCraftingRecipes() {
        //ultimateLapPack_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("${ItemName.ultimateLapPack.name}_crafting"),
                ResourceLocation(GravitationalArmor.MOD_ID),
                ItemStack(ItemRegister.getItems(ItemName.ultimateLapPack.name), 1),
                "CIC",
                "CPC",
                "CSC",
                'C', IC2Items.getItem(ic2.core.ref.ItemName.lapotron_crystal.name),
                'I', IC2Items.getItem(ic2.core.ref.ItemName.crafting.name, CraftingItemType.iridium.name),
                'P', IC2Items.getItem(ic2.core.ref.ItemName.energy_pack.name),
                'S', ItemRegister.getItems(ItemName.superconductor.name)
        )
        //gravitationArmor_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("${ItemName.gravitationArmor.name}_crafting"),
                ResourceLocation(GravitationalArmor.MOD_ID),
                ItemStack(ItemRegister.getItems(ItemName.gravitationArmor.name), 1),
                "SNS",
                "EHE",
                "SPS",
                'E', ItemRegister.getItems(ItemName.gravitationEngine.name),
                'H', IC2Items.getItem("te", TeBlock.hv_transformer.name),
                'N', IC2Items.getItem(ic2.core.ref.ItemName.nano_chestplate.name),
                'P', ItemRegister.getItems(ItemName.ultimateLapPack.name),
                'S', ItemRegister.getItems(ItemName.superconductor.name)
        )
    }
}