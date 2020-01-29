package com.frierenzk.gravitational_armor.recipe

import com.frierenzk.gravitational_armor.item.ItemRegister
import com.frierenzk.gravitational_armor.item.crafting.ItemSuperconductorCover
import ic2.api.item.IC2Items
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.GameRegistry

object CraftingRecipe {
    fun addCraftingRecipes() {
        //superconductorCover_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("superconductorCover_crafting"),
                ResourceLocation("gravitation_armor"),
                ItemStack(ItemRegister.getItems("superconductorCover"), 3),
                "AIA",
                "CCC",
                "AIA",
                'A', IC2Items.getItem("crafting", "alloy"),
                'I', IC2Items.getItem("crafting", "iridium"),
                'C', IC2Items.getItem("crafting", "carbon_plate")
        )
        //superconductor_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("superconductor_crafting"),
                ResourceLocation("gravitation_armor"),
                ItemStack(ItemRegister.getItems("superconductor"), 1),
                "CCC",
                "FGF",
                "CCC",
                'G', Items.GOLD_INGOT,
                'F', IC2Items.getItem("cable", "type:glass"),
                'C', ItemRegister.getItems("superconductorCover")
        )
        //coolingCore_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("coolingCore_crafting"),
                ResourceLocation("gravitation_armor"),
                ItemStack(ItemRegister.getItems("coolingCore"), 1),
                "SES",
                "CIC",
                "SES",
                'I', IC2Items.getItem("crafting", "iridium"),
                'C', IC2Items.getItem("heat_plating"),
                'S', IC2Items.getItem("hex_heat_storage"),
                'E', IC2Items.getItem("advanced_heat_exchanger")
        )
        //gravitationEngine_crafting
        GameRegistry.addShapedRecipe(
                ResourceLocation("gravitationEngine_crafting"),
                ResourceLocation("gravitation_armor"),
                ItemStack(ItemRegister.getItems("gravitationEngine"), 1),
                "TST",
                "CHC",
                "TST",
                'C', ItemRegister.getItems("coolingCore"),
                'H', IC2Items.getItem("te","hv_transformer"),
                'S', ItemRegister.getItems("superconductor"),
                'T', IC2Items.getItem("te","tesla_coil")
        )
    }
}