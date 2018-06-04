package com.example.examplemod.mob

import net.minecraft.client.renderer.entity.RenderManager
import net.minecraft.client.renderer.entity.Render
import net.minecraftforge.fml.client.registry.IRenderFactory
import javax.annotation.Nonnull
import net.minecraft.util.ResourceLocation
import net.minecraft.client.model.ModelZombie
import net.minecraft.client.renderer.entity.RenderLiving


class RenderWeirdZombie(rendermanagerIn: RenderManager)// We use the vanilla zombie model here and we simply
// retexture it. Of course you can make your own model
    : RenderLiving<EntityWeirdZombie>(rendermanagerIn, ModelZombie(), 0.5f)
{
    private val mobTexture = ResourceLocation("tutorial:textures/entity/weirdzombie.png")

    override fun getEntityTexture(entity: EntityWeirdZombie): ResourceLocation
    {
        return mobTexture
    }
    class Factory : IRenderFactory<EntityWeirdZombie>
    {
        override fun createRenderFor(manager: RenderManager): Render<in EntityWeirdZombie>
        {
            return RenderWeirdZombie(manager)
        }
    }
    companion object
    {
        val FACTORY = Factory()
    }
}
