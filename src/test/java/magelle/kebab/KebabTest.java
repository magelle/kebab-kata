package magelle.kebab;

import org.junit.Test;

import static magelle.kebab.Ingredient.Lamb;
import static magelle.kebab.Ingredient.Lettuce;
import static magelle.kebab.Ingredient.cheddar;
import static org.assertj.core.api.Assertions.assertThat;

public class KebabTest {

    @Test
    public void new_kebab_should_record_ingredients() {
        Kebab kebab = new Kebab(cheddar, Lamb);
        assertThat(kebab.getIngredients()).containsExactly(cheddar, Lamb);
    }

    @Test
    public void kebab_constructor_should_make_defensive_copy() {
        Ingredient[] ingredients = {cheddar, Lamb};
        Kebab kebab = new Kebab(ingredients);
        ingredients[0] = Lettuce;
        assertThat(kebab.getIngredients()).containsExactly(cheddar, Lamb);
    }

    @Test
    public void getIngredients_should_make_defensive_copy() {
        Kebab kebab = new Kebab(cheddar, Lamb);
        kebab.getIngredients().add(Lettuce);
        assertThat(kebab.getIngredients()).containsExactly(cheddar, Lamb);
    }

}