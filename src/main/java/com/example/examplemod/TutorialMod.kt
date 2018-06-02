package com.example.examplemod

import com.example.examplemod.mod_registration.ModBlocks
import com.example.examplemod.mod_registration.ModItems
import net.minecraftforge.fml.common.Mod
import com.example.examplemod.proxy.CommonProxy
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.client.event.ModelRegistryEvent

const val modId = "tutorial"
const val name = "Tutorial Mod"
const val version = "1.0.0"

@Mod(modid = modId, name = name, version = version)
class TutorialMod
{
    @Mod.EventBusSubscriber(modid = modId)
    object ObjectRegistryHandler
    {
        @JvmStatic
        @SubscribeEvent
        fun registerItems(event: RegistryEvent.Register<Item>)
        {
            ModItems.register(event.registry)
            ModBlocks.registerItemBlocks(event.registry)
        }

        @JvmStatic
        @SubscribeEvent
        fun registerModels(event: ModelRegistryEvent)
        {
            ModItems.registerModels()
            ModBlocks.registerModels()

        }
        @JvmStatic
        @SubscribeEvent
        fun registerBlocks(event: RegistryEvent.Register<Block>)
        {
            ModBlocks.register(event.registry)
        }
    }
    companion object
    {
        @Mod.Instance(modId)
        var instance: TutorialMod? = null
        @JvmStatic
        @SidedProxy(serverSide = "com.example.examplemod.proxy.CommonProxy", clientSide = "com.example.examplemod.proxy.ClientProxy")
        var proxy: CommonProxy? = null
    }

}
