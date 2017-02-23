package magelle.kebab;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Kebab {
    private final List<Food> ingredients;

    public Kebab(Food ... ingredients) {
        this.ingredients = new ArrayList<>(asList(ingredients));
    }

    public List<Food> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public boolean validate(Diet diet) {
        return diet.accept(this.ingredients);
    }
}
