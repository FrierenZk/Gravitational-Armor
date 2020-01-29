package com.frierenzk.gravitational_armor

import com.frierenzk.gravitational_armor.core.CommonProxy
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.Mod.Instance
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger

@Mod(
    modid = GravitationalArmor.MOD_ID, name = GravitationalArmor.MOD_NAME,version =GravitationalArmor.MOD_VERSION,dependencies = "required-after:ic2@[2.8.188,);required-after:forgelin@[1.8.4,);",acceptedMinecraftVersions = "[1.12,1.12.2]"
)
class GravitationalArmor {
    companion object {
        const val MOD_ID = "gravitational_armor"
        const val MOD_NAME = "Gravitational Armor"
        const val MOD_VERSION = "1.0"
        @Instance(MOD_ID)
        lateinit var instance: GravitationalArmor
        @SidedProxy(clientSide = "com.frierenzk.gravitational_armor.core.ClientProxy",
                serverSide = "com.frierenzk.gravitational_armor.core.CommonProxy")
        lateinit var proxy:CommonProxy
    }
    private lateinit var _logger: Logger
    val logger:Logger
    get() = _logger

    @EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        _logger = event.modLog
        proxy.preInit(event)
    }

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        proxy.init(event)
    }
}