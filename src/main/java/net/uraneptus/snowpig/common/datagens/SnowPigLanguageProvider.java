package net.uraneptus.snowpig.common.datagens;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundEvent;
import net.uraneptus.snowpig.core.registry.SnowPigEntityTypes;
import net.uraneptus.snowpig.core.registry.SnowPigItems;
import net.uraneptus.snowpig.core.registry.SnowPigJukeboxSongs;
import net.uraneptus.snowpig.core.registry.SnowPigSounds;
import net.uraneptus.snowpig.core.tags.SnowPigBiomeTags;
import net.uraneptus.snowpig.core.tags.SnowPigEntityTags;

import java.util.concurrent.CompletableFuture;

public class SnowPigLanguageProvider extends FabricLanguageProvider {
    public SnowPigLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(SnowPigBiomeTags.SPAWNS_SNOW_PIG, "Spawns Snow Pig");
        translationBuilder.add(SnowPigEntityTags.KILLER_FOR_SNOWPIG_DISC, "Killer for Snow Pig Disc");
        translationBuilder.add(SnowPigItems.SNOW_PIG_SPAWN_EGG, "Snow Pig Spawn Egg");
        translationBuilder.add(SnowPigItems.FROZEN_HAM, "Frozen Ham");
        translationBuilder.add(SnowPigItems.FROZEN_PORKCHOP, "Frozen Porkchop");
        translationBuilder.add(SnowPigItems.MUSIC_DISC_FROSTY_SNIG, "Music Disc");
        jukeboxSongTranslation(translationBuilder, SnowPigJukeboxSongs.FROSTY_SNIG, "Luz - Frosty Snig");
        translationBuilder.add(SnowPigEntityTypes.SNOW_PIG, "Snow Pig");
        soundTranslation(translationBuilder, SnowPigSounds.SNOW_PIG_AMBIENT, "Snow Pig oinks");
        soundTranslation(translationBuilder, SnowPigSounds.SNOW_PIG_DEATH, "Snow Pig dies");
        soundTranslation(translationBuilder, SnowPigSounds.SNOW_PIG_HURT, "Snow Pig hurts");
    }
    private static void jukeboxSongTranslation(TranslationBuilder translationBuilder, RegistryKey<JukeboxSong> song, String value){
        translationBuilder.add("jukebox_song." + song.getValue().toTranslationKey(), value);
    }
    private static void soundTranslation(TranslationBuilder translationBuilder, SoundEvent sound, String value){
        translationBuilder.add("subtitles." + sound.id().toTranslationKey(), value);
    }
}
