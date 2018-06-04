package com.example.examplemod.mob

import com.example.examplemod.modId
import net.minecraft.entity.Entity
import net.minecraft.util.ResourceLocation
import net.minecraft.init.MobEffects
import net.minecraft.potion.PotionEffect
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.monster.EntityIronGolem
import net.minecraft.entity.ai.EntityAINearestAttackableTarget
import net.minecraft.entity.passive.EntityVillager
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.monster.EntityPigZombie
import net.minecraft.entity.ai.EntityAIHurtByTarget
import net.minecraft.entity.ai.EntityAIMoveThroughVillage
import net.minecraft.entity.ai.EntityAILookIdle
import net.minecraft.entity.ai.EntityAIWatchClosest
import net.minecraft.entity.ai.EntityAIWander
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction
import net.minecraft.entity.ai.EntityAISwimming
import oracle.jrockit.jfr.events.Bits.booleanValue
import net.minecraftforge.fml.common.thread.SidedThreadGroups.CLIENT
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.world.World
import net.minecraft.network.datasync.DataSerializers
import net.minecraft.network.datasync.EntityDataManager
import net.minecraft.network.datasync.DataParameter
import net.minecraft.entity.monster.EntityMob
import net.minecraftforge.fml.relauncher.Side
import javax.annotation.Nullable

class EntityWeirdZombie(worldIn: World) : EntityMob(worldIn)
{

    var isArmsRaised: Boolean
        @SideOnly(Side.CLIENT)
        get() = this.getDataManager().get(ARMS_RAISED)//.booleanValue()
        set(armsRaised) = this.getDataManager().set(ARMS_RAISED, java.lang.Boolean.valueOf(armsRaised))

    init
    {
        setSize(0.6f, 1.95f)
    }
    override fun entityInit()
    {
        super.entityInit()
        this.getDataManager().register(ARMS_RAISED, java.lang.Boolean.valueOf(false))
    }
    override fun applyEntityAttributes()
    {
        super.applyEntityAttributes()
        // Here we set various attributes for our mob. Like maximum health, armor, speed, ...
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).baseValue = 35.0
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).baseValue = 0.13
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).baseValue = 3.0
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).baseValue = 2.0
    }
    override fun initEntityAI()
    {
        this.tasks.addTask(0, EntityAISwimming(this))
        this.tasks.addTask(2, EntityAIWeirdZombieAttack(this, 1.0, false))
        this.tasks.addTask(5, EntityAIMoveTowardsRestriction(this, 1.0))
        this.tasks.addTask(7, EntityAIWander(this, 1.0))
        this.tasks.addTask(8, EntityAIWatchClosest(this, EntityPlayer::class.java, 8.0f))
        this.tasks.addTask(8, EntityAILookIdle(this))
        this.applyEntityAI()
    }
    private fun applyEntityAI()
    {
        this.tasks.addTask(6, EntityAIMoveThroughVillage(this, 1.0, false))
        this.targetTasks.addTask(1, EntityAIHurtByTarget(this, true, *arrayOf<Class<*>>(EntityPigZombie::class.java)))
        this.targetTasks.addTask(2, EntityAINearestAttackableTarget(this, EntityPlayer::class.java, true))
        this.targetTasks.addTask(3, EntityAINearestAttackableTarget(this, EntityVillager::class.java, false))
        this.targetTasks.addTask(3, EntityAINearestAttackableTarget(this, EntityIronGolem::class.java, true))
    }
    override fun attackEntityAsMob(entityIn: Entity): Boolean
    {
        if (super.attackEntityAsMob(entityIn))
        {
            if (entityIn is EntityLivingBase)
            {
                // This zombie gives health boost and regeneration when it attacks
                (entityIn as EntityLivingBase).addPotionEffect(PotionEffect(MobEffects.HEALTH_BOOST, 200))
                (entityIn as EntityLivingBase).addPotionEffect(PotionEffect(MobEffects.REGENERATION, 200))
            }
            return true
        } else
        {
            return false
        }
    }
    @Nullable
    override fun getLootTable(): ResourceLocation?
    {
        return LOOT
    }
    override fun isValidLightLevel(): Boolean
    {
        return true
    }
    override fun getMaxSpawnedInChunk(): Int
    {
        return 5
    }
    companion object
    {

        // We reuse the zombie model which has arms that need to be raised when the zombie is attacking:
        private val ARMS_RAISED = EntityDataManager.createKey(EntityWeirdZombie::class.java, DataSerializers.BOOLEAN)

        val LOOT = ResourceLocation(modId, "entities/weird_zombie")
    }
}
