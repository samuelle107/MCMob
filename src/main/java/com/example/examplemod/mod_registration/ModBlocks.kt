package com.example.examplemod.mod_registration

import com.example.examplemod.automation.registration.RegisterBlocks
import com.example.examplemod.blocks.CopperOre
import net.minecraft.creativetab.CreativeTabs

object ModBlocks : RegisterBlocks()
{
    private var oreCopper = CopperOre().setCreativeTab(CreativeTabs.MATERIALS)

    init
    {
        with(blockList)
        {
            add(oreCopper)
        }
    }
}