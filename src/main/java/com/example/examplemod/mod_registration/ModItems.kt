package com.example.examplemod.mod_registration

import com.example.examplemod.automation.registration.RegisterItems
import com.example.examplemod.item.ItemBase
import com.example.examplemod.items.IngotCopper
import net.minecraft.creativetab.CreativeTabs

object ModItems : RegisterItems()
{
    //Creates an object of the custom item class and sets it to be in the creative tab
    var ingotCopper: ItemBase = IngotCopper().setCreativeTab(CreativeTabs.MATERIALS)

    init
    {
        //itemList is an array, so by doing "with", it is saying with the array itemList, we add ingotCopper into that array.
        with(itemList)
        {
            add(ingotCopper)
        }
    }
}