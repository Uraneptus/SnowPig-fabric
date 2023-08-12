package net.uraneptus.snowpig.core.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.uraneptus.snowpig.SnowPig;

public class SnowPigSounds {
    public static final SoundEvent SNOW_PIG_AMBIENT = register("entity.snow_pig.ambient");


    public static final SoundEvent SNOW_PIG_HURT = register("entity.snow_pig.hurt");


    public static final SoundEvent SNOW_PIG_DEATH = register("entity.snow_pig.death");


    public static final SoundEvent SNOW_PIG_STEP = register("entity.snow_pig.step");


    public static final SoundEvent MUSIC_DISC_FROSTY_SNIG = register("music_disc.frosty_snig");

    public static void registerSounds() {

    }
    private static SoundEvent register(String id){
        return register(SnowPig.id(id));
    }

    private static SoundEvent register(Identifier id){
        return register(id, id);
    }
    private static SoundEvent register(Identifier id, Identifier soundId) {
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(soundId));
    }
}
