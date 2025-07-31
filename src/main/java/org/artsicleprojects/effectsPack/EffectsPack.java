package org.artsicleprojects.effectsPack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import electroblob.wizardry.spell.Spell;
import org.artsicleprojects.effectsPack.Spells.InstantTeleport;
import org.artsicleprojects.effectsPack.Spells.InvisibilityOrb;
import org.artsicleprojects.effectsPack.Spells.TimeDay;
import org.artsicleprojects.effectsPack.Spells.TimeNight;

@Mod(
        modid = "aef",
        version = "0.0.2",
        name = "Art's Effects Pack",
        dependencies = "required-after:wizardry"
)
public class EffectsPack {
    public static final String MODID = "aef";
    public static final String VERSION = "0.0.2";
    public static final String NAME = "Art's Effects Pack";
    public InvisibilityOrb invisibilityOrb = new InvisibilityOrb();
    public TimeNight timenight = new TimeNight();
    public TimeDay timeday = new TimeDay();
    public InstantTeleport instantTeleport = new InstantTeleport();

    public EffectsPack() {
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent preInitializationEvent) {
        Spell.register(this.timeday);
        Spell.register(this.timenight);
        Spell.register(this.invisibilityOrb);
        Spell.register(this.instantTeleport);
    }
}
