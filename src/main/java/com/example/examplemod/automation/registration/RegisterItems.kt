package com.example.examplemod.automation.registration

import com.example.examplemod.item.ItemBase
import net.minecraft.item.Item
import net.minecraftforge.registries.IForgeRegistry

open class RegisterItems
{
    //Creates an itemList that is an arrayList of the object itemBase().  This means that each array entry will be objects of itemBase()
    val itemList = arrayListOf<ItemBase>()
    //This register function will loop for every item in the itemList arrayList.  In every loop, it will register that item.
    fun register(registry: IForgeRegistry<Item>)
    {
        for(item in itemList)
        {
            registry.register(item)
        }
    }
    //Same logic as register, except it will register the item model
    fun registerModels()
    {
        for(item in itemList)
        {
            item.registerItemModel()
        }
    }
}