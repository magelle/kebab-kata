package magelle.kebab;

import org.junit.Test;

import static java.util.Arrays.asList;
import static magelle.kebab.Ingredient.*;
import static org.assertj.core.api.Assertions.assertThat;

public class VegetarianDietTest {

    private VegetarianDiet vegetarianDiet = new VegetarianDiet();

    @Test
    public void should_return_false_when_ingredients_contains_lamb() {
        assertThat(vegetarianDiet.isVegetarian(asList(LETTUCE, LAMB))).isFalse();
    }

    @Test
    public void should_return_false_when_ingredients_contains_beef() {
        assertThat(vegetarianDiet.isVegetarian(asList(TOMATO, BEEF))).isFalse();
    }

    @Test
    public void should_return_true_when_ingredients_does_not_contain_beef_or_lamb() {
        assertThat(vegetarianDiet.isVegetarian(asList(LETTUCE, CHEDDAR))).isTrue();
    }

}