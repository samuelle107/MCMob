package com.example.examplemod.automation.registration

import com.example.examplemod.automation.base.BlockBase
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.registries.IForgeRegistry

open class RegisterBlocks
{
    //Creates a blockList that is an ArrayList of BlockBase objects
    val blockList = ArrayList<BlockBase>()
    //This function loops every entry in the blockList arrayList and registers it as an item
    fun register(registry: IForgeRegistry<Block>)
    {
        for(block in blockList)
        {
            registry.register(block)
        }
    }
    //This function loops every entry in the blockList and registers the items as blocks
    fun registerItemBlocks(registry: IForgeRegistry<Item>)
    {
        for(block in blockList)
        {
            registry.register(block.createItemBlock())
        }
    }
    //This function loops every entry in the blockList and registers the models of the item and block
    fun registerModels()
    {
        for(block in blockList)
        {
            block.registerItemModel(Item.getItemFromBlock(block))
        }
    }
}