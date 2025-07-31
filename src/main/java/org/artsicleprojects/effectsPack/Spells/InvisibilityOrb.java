package org.artsicleprojects.effectsPack.Spells;

import electroblob.wizardry.EnumElement;
import electroblob.wizardry.EnumSpellType;
import electroblob.wizardry.EnumTier;
import electroblob.wizardry.entity.projectile.EntityMagicProjectile;
import electroblob.wizardry.spell.Spell;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class InvisibilityOrb extends Spell {
    public InvisibilityOrb() {
        super(EnumTier.APPRENTICE, 15, EnumElement.SORCERY, "invisibilityorb", EnumSpellType.DEFENCE, 70, EnumAction.none, false, "aef");
    }

    public boolean cast(World world, EntityPlayer entityPlayer, int ticksInUse, float damageM, float rangeM, final float duractionM, float blastM) {
        EntityMagicProjectile projectile = new EntityMagicProjectile(world, entityPlayer) {
            protected void onImpact(MovingObjectPosition p) {
                if (p.typeOfHit == MovingObjectType.ENTITY) {
                    ((EntityLivingBase)p.entityHit).addPotionEffect(new PotionEffect(Potion.invisibility.id, (int)(600.0F * duractionM), 0, true));
                }
            }
        };
        world.spawnEntityInWorld(projectile);
        world.playSoundAtEntity(entityPlayer, "wizardry:magic", 1.0F, world.rand.nextFloat() * 0.4F + 1.2F);
        return true;
    }
}
