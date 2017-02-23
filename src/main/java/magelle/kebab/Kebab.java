package magelle.kebab;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Kebab {
    private final List<Ingredient> ingredients;

    public Kebab(Ingredient ... ingredients) {
        this.ingredients = new ArrayList<>(asList(ingredients));
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }
}
