package org.artsicleprojects.effectsPack.Spells;

import electroblob.wizardry.EnumElement;
import electroblob.wizardry.EnumSpellType;
import electroblob.wizardry.EnumTier;
import electroblob.wizardry.spell.Spell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class InstantTeleport extends Spell {
    public InstantTeleport() {
        super(EnumTier.ADVANCED, 45, EnumElement.SORCERY, "instantteleport", EnumSpellType.UTILITY, 20, EnumAction.none, false);
    }

    public boolean cast(World world, EntityPlayer entityPlaye, int i, float v, float v1, float v2, float v3) {
        if (entityPlaye instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayer = (EntityPlayerMP)entityPlaye;
            MovingObjectPosition s = entityPlayer.rayTrace(500.0F, 1.62F);
            world.playSoundAtEntity(entityPlayer, "wizardry:magic", 1.0F, world.rand.nextFloat() * 0.4F + 1.2F);
            if (s != null) {
                entityPlayer.setPositionAndUpdate(s.blockX, (double)s.blockY + 1.62, s.blockZ);
                return true;
            }else{
                entityPlayer.setPositionAndUpdate(entityPlayer.posX, entityPlayer.posY + (double)entityPlayer.getEyeHeight(), entityPlaye.posZ);
                return false;
            }
        }
        return false;
    }
}

