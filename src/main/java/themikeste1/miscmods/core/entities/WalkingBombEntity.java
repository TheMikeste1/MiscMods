package themikeste1.miscmods.core.entities;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IChargeableMob;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Collection;

public class WalkingBombEntity extends CreatureEntity implements IChargeableMob {
    public static final String ID = "walking_bomb";

    public float explosionRadius = 1.0F;

    public WalkingBombEntity(EntityType<? extends CreatureEntity> type, World world) {
        super(type, world);
    }


    @Override
    protected void registerGoals() {
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();

    }

    @Override
    protected void onDeathUpdate() {
        super.onDeathUpdate();
        if (deathTime == 20) {
            explode();
        }
    }

    /**
     * Creates an explosion as determined by this bomb's power and explosion radius.
     */
    private void explode() {
        if (!this.world.isRemote) {
            Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
            float f = this.func_225509_J__() ? 2.0F : 1.0F;
            this.dead = true;
            this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), (float)this.explosionRadius * f, explosion$mode);
            this.remove();
            this.spawnLingeringCloud();
        }

    }

    private void spawnLingeringCloud() {
        Collection<EffectInstance> collection = this.getActivePotionEffects();
        if (!collection.isEmpty()) {
            AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ());
            areaeffectcloudentity.setRadius(2.5F);
            areaeffectcloudentity.setRadiusOnUse(-0.5F);
            areaeffectcloudentity.setWaitTime(10);
            areaeffectcloudentity.setDuration(areaeffectcloudentity.getDuration() / 2);
            areaeffectcloudentity.setRadiusPerTick(-areaeffectcloudentity.getRadius() / (float)areaeffectcloudentity.getDuration());

            for(EffectInstance effectinstance : collection) {
                areaeffectcloudentity.addEffect(new EffectInstance(effectinstance));
            }

            this.world.addEntity(areaeffectcloudentity);
        }

    }

    @Override
    public boolean func_225509_J__() {
        return false;
    }
}
