package net.uraneptus.snowpig.core.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.uraneptus.snowpig.SnowPig;

public class SnowPigSounds {
    public static final Identifier SNOW_PIG_AMBIENT_ID = new Identifier(SnowPig.MOD_ID, "entity.snow_pig.ambient");
    public static final SoundEvent SNOW_PIG_AMBIENT = new SoundEvent(SNOW_PIG_AMBIENT_ID);

    public static final Identifier SNOW_PIG_HURT_ID = new Identifier(SnowPig.MOD_ID, "entity.snow_pig.hurt");
    public static final SoundEvent SNOW_PIG_HURT = new SoundEvent(SNOW_PIG_HURT_ID);

    public static final Identifier SNOW_PIG_DEATH_ID = new Identifier(SnowPig.MOD_ID, "entity.snow_pig.death");
    public static final SoundEvent SNOW_PIG_DEATH = new SoundEvent(SNOW_PIG_DEATH_ID);

    public static final Identifier SNOW_PIG_STEP_ID = new Identifier(SnowPig.MOD_ID, "entity.snow_pig.step");
    public static final SoundEvent SNOW_PIG_STEP = new SoundEvent(SNOW_PIG_STEP_ID);

    public static final Identifier MUSIC_DISC_FROSTY_SNIG_ID = new Identifier(SnowPig.MOD_ID, "music_disc.frosty_snig");
    public static final SoundEvent MUSIC_DISC_FROSTY_SNIG = new SoundEvent(MUSIC_DISC_FROSTY_SNIG_ID);

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, SNOW_PIG_AMBIENT_ID, SNOW_PIG_AMBIENT);
        Registry.register(Registry.SOUND_EVENT, SNOW_PIG_HURT_ID, SNOW_PIG_HURT);
        Registry.register(Registry.SOUND_EVENT, SNOW_PIG_DEATH_ID, SNOW_PIG_DEATH);
        Registry.register(Registry.SOUND_EVENT, SNOW_PIG_STEP_ID, SNOW_PIG_STEP);
        Registry.register(Registry.SOUND_EVENT, MUSIC_DISC_FROSTY_SNIG_ID, MUSIC_DISC_FROSTY_SNIG);
    }
}
