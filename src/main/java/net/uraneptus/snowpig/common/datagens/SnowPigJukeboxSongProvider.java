package net.uraneptus.snowpig.common.datagens;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.uraneptus.snowpig.core.registry.SnowPigJukeboxSongs;

import java.util.concurrent.CompletableFuture;

public class SnowPigJukeboxSongProvider extends FabricDynamicRegistryProvider {
    public SnowPigJukeboxSongProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        add(registries, entries, SnowPigJukeboxSongs.FROSTY_SNIG);
    }

    private void add(RegistryWrapper.WrapperLookup registries, Entries entries, RegistryKey<JukeboxSong> resourceKey) {
        RegistryWrapper.Impl<JukeboxSong> configuredFeatureRegistryLookup = registries.getOrThrow(RegistryKeys.JUKEBOX_SONG);

        entries.add(resourceKey, configuredFeatureRegistryLookup.getOrThrow(resourceKey).value());
    }
    @Override
    public String getName() {
        return "jukebox_song";
    }
}

