package com.example.examplemod.mob

import net.minecraft.entity.ai.EntityAIAttackMelee


class EntityAIWeirdZombieAttack(private val weirdZombie: EntityWeirdZombie, speedIn: Double, longMemoryIn: Boolean) : EntityAIAttackMelee(weirdZombie, speedIn, longMemoryIn)
{
    private var raiseArmTicks: Int = 0

    /**
     * Execute a one shot task or start executing a continuous task
     */
    override fun startExecuting()
    {
        super.startExecuting()
        this.raiseArmTicks = 0
    }

    /**
     * Resets the task
     */
    override fun resetTask()
    {
        super.resetTask()
        this.weirdZombie.isArmsRaised = false
    }

    /**
     * Updates the task
     */
    override fun updateTask()
    {
        super.updateTask()
        ++this.raiseArmTicks

        if (this.raiseArmTicks >= 5 && this.attackTick < 10)
        {
            this.weirdZombie.isArmsRaised = true
        } else
        {
            this.weirdZombie.isArmsRaised = false
        }
    }
}
