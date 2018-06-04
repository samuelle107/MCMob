package com.example.examplemod.proxy

import com.example.examplemod.mob.ModEntities
import net.minecraft.item.Item
import net.minecraftforge.fml.common.event.FMLInitializationEvent

open class CommonProxy
{
    open fun registerItemRenderer(item: Item, meta: Int, id: String)
    {
    }
}