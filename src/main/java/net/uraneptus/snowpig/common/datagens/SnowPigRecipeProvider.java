package net.uraneptus.snowpig.common.datagens;

import com.nhoryzon.mc.farmersdelight.entity.block.inventory.RecipeWrapper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.uraneptus.snowpig.core.ModIntegrations;
import net.uraneptus.snowpig.core.registry.SnowPigItems;

import java.util.function.Consumer;

public class SnowPigRecipeProvider extends FabricRecipeProvider {
    public SnowPigRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        registerCookables(exporter, SnowPigItems.FROZEN_PORKCHOP, Items.PORKCHOP, 0.2F);
//        if (ModIntegrations.isFDLoaded()){
//            registerCookables(exporter, SnowPigItems.FROZEN_HAM, ModIntegrations.getHam(), 0.2F);
//        }
    }


    public void registerCookables(Consumer<RecipeJsonProvider> exporter, ItemConvertible input, ItemConvertible output, float xp) {
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(input), RecipeCategory.FOOD, output, xp, 200).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter, getItemPath(output) + "_from_smelting_" + getItemPath(input));
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(input), RecipeCategory.FOOD, output, xp, 100).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter, getItemPath(output) + "_from_smoking_" + getItemPath(input));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(input), RecipeCategory.FOOD, output, xp, 600).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter, getItemPath(output) + "_from_campfire_cooking_" + getItemPath(input));
    }

}
