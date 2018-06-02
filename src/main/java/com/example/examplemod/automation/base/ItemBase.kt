package com.example.examplemod.item

import com.example.examplemod.TutorialMod
import net.minecraft.item.Item
import net.minecraft.creativetab.CreativeTabs

open class ItemBase(var name: String) : Item()
{
    init
    {
        unlocalizedName = name
        setRegistryName(name)
    }
    fun registerItemModel()
    {
        TutorialMod.proxy!!.registerItemRenderer(this, 0, name)
    }

    override fun setCreativeTab(tab: CreativeTabs): ItemBase
    {
        super.setCreativeTab(tab)
        return this
    }
}