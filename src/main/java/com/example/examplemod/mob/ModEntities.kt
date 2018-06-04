package com.example.examplemod.mob

import com.example.examplemod.TutorialMod.Companion.instance
import com.example.examplemod.modId
import net.minecraftforge.fml.client.registry.RenderingRegistry
import net.minecraftforge.fml.common.thread.SidedThreadGroups.CLIENT
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraft.world.storage.loot.LootTableList
import net.minecraft.init.Biomes
import net.minecraft.entity.EnumCreatureType
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.EntityRegistry
import net.minecraftforge.fml.relauncher.Side


object ModEntities
{
    fun init()
    {
        // Every entity in our mod has an ID (local to this mod)
        var id = 1
        EntityRegistry.registerModEntity( ResourceLocation(modId),EntityWeirdZombie::class.java, "WeirdZombie", id++, instance, 64, 3, true, 0x996600, 0x00ff00)

        // We want our mob to spawn in Plains and ice plains biomes. If you don't add this then it will not spawn automatically
        // but you can of course still make it spawn manually
        EntityRegistry.addSpawn(EntityWeirdZombie::class.java, 100, 3, 5, EnumCreatureType.MONSTER, Biomes.PLAINS, Biomes.ICE_PLAINS)

        // This is the loot table for our mob
        LootTableList.register(EntityWeirdZombie.LOOT)
    }
    @SideOnly(Side.CLIENT)
    fun initModels()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityWeirdZombie::class.java, RenderWeirdZombie.FACTORY)
    }
}
