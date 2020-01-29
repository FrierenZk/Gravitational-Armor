package com.frierenzk.gravitational_armor.core

import com.frierenzk.gravitational_armor.item.ItemRegister
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

open class ClientProxy:CommonProxy() {
    override fun preInit(event: FMLPreInitializationEvent) {
        super.preInit(event)
        ItemRegister.clientInit()
    }

    override fun init(event: FMLInitializationEvent) {
        super.init(event)
    }
}