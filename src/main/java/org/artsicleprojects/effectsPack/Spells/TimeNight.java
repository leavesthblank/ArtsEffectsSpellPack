package org.artsicleprojects.effectsPack.Spells;

import electroblob.wizardry.EnumElement;
import electroblob.wizardry.EnumSpellType;
import electroblob.wizardry.EnumTier;
import electroblob.wizardry.spell.Spell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.world.World;

public class TimeNight extends Spell {
    public TimeNight() {
        super(EnumTier.ADVANCED, 60, EnumElement.EARTH, "tonight", EnumSpellType.UTILITY, 10000, EnumAction.none, false);
    }

    public boolean cast(World world, EntityPlayer entityPlayer, int i, float v, float v1, float v2, float v3) {
        world.setWorldTime((world.getWorldTime()/24000) * 24000 + 37500L);
        world.playSoundAtEntity(entityPlayer, "wizardry:magic", 1.0F, world.rand.nextFloat() * 0.4F + 1.2F);
        return true;
    }
}
