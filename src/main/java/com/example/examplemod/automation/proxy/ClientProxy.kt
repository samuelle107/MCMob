package com.example.examplemod.proxy

import com.example.examplemod.mob.ModEntities
import com.example.examplemod.modId
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.event.FMLInitializationEvent

class ClientProxy : CommonProxy()
{
    override fun registerItemRenderer(item: Item, meta: Int, id: String)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, ModelResourceLocation(modId + ":" + id, "inventory"))
    }
}