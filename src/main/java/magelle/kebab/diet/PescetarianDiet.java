package magelle.kebab.diet;

import magelle.kebab.Diet;
import magelle.kebab.Food;
import magelle.kebab.FoodType;

import java.util.List;

public class PescetarianDiet implements Diet {

    @Override
    public boolean accept(List<Food> foods) {
        return foods.stream()
                .map(Food::getFoodType)
                .noneMatch(type -> type == FoodType.MEAT);
    }
}
