package magelle.kebab;

import java.util.List;

public class VegetarianDiet {
    public boolean isVegetarian(List<Ingredient> ingredients) {
        return ingredients.stream()
                .noneMatch(ingredient -> ingredient == Ingredient.BEEF || ingredient == Ingredient.LAMB);
    }
}