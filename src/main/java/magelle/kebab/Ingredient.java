package magelle.kebab;

import static magelle.kebab.FoodType.*;

public enum Ingredient implements Food {
    TOMATO(OTHER),
    CHEDDAR(CHEESE),
    LAMB(MEAT),
    LETTUCE(OTHER),
    BEEF(MEAT),
    MACKEREL(FISH),
    TUNA(FISH),
    PARMESAN(CHEESE),
    ONION(OTHER);

    private final FoodType foodType;

    Ingredient(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public FoodType getFoodType() {
        return foodType;
    }
}
