package net.uraneptus.snowpig.common.datagens;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.uraneptus.snowpig.core.registry.SnowPigItems;

import java.util.concurrent.CompletableFuture;

public class SnowPigRecipeProvider extends FabricRecipeProvider {

    public SnowPigRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup,recipeExporter) {
            @Override
            public void generate() {
                registerCookables(exporter, SnowPigItems.FROZEN_PORKCHOP, Items.PORKCHOP, 0.2F);
            }
            public void registerCookables(RecipeExporter exporter, ItemConvertible input, ItemConvertible output, float xp){
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(input), RecipeCategory.FOOD, output, xp, 200).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter, getItemPath(output) + "_from_smelting_" + getItemPath(input));
                CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(input), RecipeCategory.FOOD, output, xp, 100).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter, getItemPath(output) + "_from_smoking_" + getItemPath(input));
                CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(input), RecipeCategory.FOOD, output, xp, 550).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter, getItemPath(output) + "_from_campfire_cooking_" + getItemPath(input));

            }
        };
    }



    @Override
    public String getName() {
        return "recipe";
    }
}
