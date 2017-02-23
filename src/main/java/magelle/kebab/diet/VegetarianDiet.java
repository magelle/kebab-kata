package magelle.kebab.diet;

import magelle.kebab.Diet;
import magelle.kebab.Food;

import java.util.List;

import static magelle.kebab.FoodType.FISH;
import static magelle.kebab.FoodType.MEAT;

public class VegetarianDiet implements Diet {

    @Override
    public boolean accept(List<Food> ingredients) {
        return ingredients.stream()
                .map(Food::getFoodType)
                .noneMatch(type -> type == MEAT || type == FISH);
    }

}