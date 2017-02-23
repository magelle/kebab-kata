package magelle.kebab;

import org.junit.Test;

import static magelle.kebab.Ingredient.LAMB;
import static magelle.kebab.Ingredient.LETTUCE;
import static magelle.kebab.Ingredient.CHEDDAR;
import static org.assertj.core.api.Assertions.assertThat;

public class KebabTest {

    @Test
    public void new_kebab_should_record_ingredients() {
        Kebab kebab = new Kebab(CHEDDAR, LAMB);
        assertThat(kebab.getIngredients()).containsExactly(CHEDDAR, LAMB);
    }

    @Test
    public void kebab_constructor_should_make_defensive_copy() {
        Ingredient[] ingredients = {CHEDDAR, LAMB};
        Kebab kebab = new Kebab(ingredients);
        ingredients[0] = LETTUCE;
        assertThat(kebab.getIngredients()).containsExactly(CHEDDAR, LAMB);
    }

    @Test
    public void getIngredients_should_make_defensive_copy() {
        Kebab kebab = new Kebab(CHEDDAR, LAMB);
        kebab.getIngredients().add(LETTUCE);
        assertThat(kebab.getIngredients()).containsExactly(CHEDDAR, LAMB);
    }

    @Test
    public void isVegetarian_should_return_true_when_kebab_contains_meet() {
        Kebab kebab = new Kebab(CHEDDAR, LETTUCE);
        assertThat(kebab.isVegetarian()).isTrue();
    }

    @Test
    public void isVegetarian_should_return_false_when_kebab_does_not_contains_meet() {
        Kebab kebab = new Kebab(CHEDDAR, LAMB);
        assertThat(kebab.isVegetarian()).isFalse();
    }

}