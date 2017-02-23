package magelle.kebab;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static magelle.kebab.Ingredient.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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
    public void validate_should_return_diet_accept_result() {
        Diet diet = mock(Diet.class);
        List<Food> foods = asList(CHEDDAR, TUNA);
        when(diet.accept(foods)).thenReturn(true);
        Kebab kebab = new Kebab(CHEDDAR, TUNA);
        assertThat(kebab.validate(diet)).isTrue();
        verify(diet, times(1)).accept(foods);
    }

    @Test
    public void doubleCheese_should_add_the_same_cheese() {
        Kebab kebab = new Kebab(LETTUCE, PARMESAN).doubleCheese();
        assertThat(kebab.getIngredients()).containsExactly(LETTUCE, PARMESAN, PARMESAN);
    }

    @Test
    public void doubleCheese_do_nothing_when_no_cheese() {
        Kebab kebab = new Kebab(LETTUCE, TOMATO).doubleCheese();
        assertThat(kebab.getIngredients()).containsExactly(LETTUCE, TOMATO);
    }

    @Test
    public void without_should_remove_ingredients() {
        Kebab kebab = new Kebab(Ingredient.LAMB, Ingredient.ONION).without(LAMB);
        assertThat(kebab.getIngredients())
                .containsExactly(Ingredient.ONION);
    }

    @Test
    public void without_should_remove_ingredients_but_this_ingredient_is_not_present() {
        Kebab kebab = new Kebab(Ingredient.ONION).without(LAMB);
        assertThat(kebab.getIngredients())
                .containsExactly(Ingredient.ONION);
    }
}