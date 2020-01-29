package com.frierenzk.gravitational_armor.recipe

import com.frierenzk.gravitational_armor.GravitationalArmor
import com.frierenzk.gravitational_armor.item.ItemName
import com.frierenzk.gravitational_armor.item.ItemRegister
import ic2.api.item.IC2Items
import ic2.core.block.wiring.CableType
import ic2.core.item.type.CraftingItemType
import ic2.core.ref.TeBlock
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.GameRegistry

object CraftingRecipe {
    fun addCraftingRecipes() {
        //superconductorCover_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("${ItemName.superconductorCover.name}_crafting"),
                ResourceLocation(GravitationalArmor.MOD_ID),
                ItemStack(ItemRegister.getItems(ItemName.superconductorCover.name), 3),
                "AIA",
                "CCC",
                "AIA",
                'A', IC2Items.getItem(ic2.core.ref.ItemName.crafting.name, CraftingItemType.alloy.name),
                'I', IC2Items.getItem(ic2.core.ref.ItemName.crafting.name, CraftingItemType.iridium.name),
                'C', IC2Items.getItem(ic2.core.ref.ItemName.crafting.name, CraftingItemType.carbon_plate.name)
        )
        //superconductor_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("${ItemName.superconductor.name}_crafting"),
                ResourceLocation(GravitationalArmor.MOD_ID),
                ItemStack(ItemRegister.getItems(ItemName.superconductor.name), 1),
                "CCC",
                "FGF",
                "CCC",
                'G', Items.GOLD_INGOT,
                'F', IC2Items.getItem(ic2.core.ref.ItemName.cable.name, "type:glass"),
                'C', ItemRegister.getItems(ItemName.superconductorCover.name)
        )
        //coolingCore_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("${ItemName.coolingCore.name}_crafting"),
                ResourceLocation(GravitationalArmor.MOD_ID),
                ItemStack(ItemRegister.getItems(ItemName.coolingCore.name), 1),
                "SES",
                "CIC",
                "SES",
                'I', IC2Items.getItem(ic2.core.ref.ItemName.crafting.name, CraftingItemType.iridium.name),
                'C', IC2Items.getItem(ic2.core.ref.ItemName.heat_plating.name),
                'S', IC2Items.getItem(ic2.core.ref.ItemName.hex_heat_storage.name),
                'E', IC2Items.getItem(ic2.core.ref.ItemName.advanced_heat_exchanger.name)
        )
        //gravitationEngine_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("${ItemName.gravitationEngine.name}_crafting"),
                ResourceLocation(GravitationalArmor.MOD_ID),
                ItemStack(ItemRegister.getItems(ItemName.gravitationEngine.name), 1),
                "TST",
                "CHC",
                "TST",
                'C', ItemRegister.getItems(ItemName.coolingCore.name),
                'H', IC2Items.getItem("te",TeBlock.hv_transformer.name),
                'S', ItemRegister.getItems(ItemName.superconductor.name),
                'T', IC2Items.getItem("te",TeBlock.tesla_coil.name)
        )
    }
}