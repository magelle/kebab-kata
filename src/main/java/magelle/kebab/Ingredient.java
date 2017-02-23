package magelle.kebab;

import static magelle.kebab.FoodType.*;

public enum Ingredient implements Food {
    TOMATO(OTHER), CHEDDAR(OTHER), LAMB(MEAT), LETTUCE(OTHER), BEEF(MEAT), MACKEREL(FISH), TUNA(FISH);

    private final FoodType foodType;

    Ingredient(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public FoodType getFoodType() {
        return foodType;
    }
}
