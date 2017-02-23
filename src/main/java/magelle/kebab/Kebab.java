package magelle.kebab;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static magelle.kebab.FoodType.CHEESE;

public class Kebab {
    private final List<Food> ingredients;

    public Kebab(Food ... ingredients) {
        this.ingredients = new ArrayList<>(asList(ingredients));
    }

    public Kebab(List<Food> ingredients) {
        this.ingredients = new ArrayList<>(ingredients);
    }

    public List<Food> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public boolean validate(Diet diet) {
        return diet.accept(this.ingredients);
    }

    public Kebab doubleCheese() {
        return new Kebab(doubleIngredient(CHEESE));
    }

    public Kebab without(Food foodToRemove) {
        return new Kebab(
                this.ingredients.stream()
                .filter(food -> ! food.equals(foodToRemove))
                .collect(toList())
        );
    }

    private List<Food> doubleIngredient(FoodType ingredientToDouble) {
        return this.ingredients.stream()
                .flatMap(food -> {
                    if (food.getFoodType() == ingredientToDouble)
                        return Stream.of(food, food);
                    return Stream.of(food);
                })
                .collect(toList());
    }
}
