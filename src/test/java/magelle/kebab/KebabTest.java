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

}