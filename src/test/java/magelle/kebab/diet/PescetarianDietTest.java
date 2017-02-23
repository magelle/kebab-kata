package magelle.kebab.diet;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static magelle.kebab.Ingredient.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PescetarianDietTest {

    private PescetarianDiet pescetarianDiet = new PescetarianDiet();

    @Test
    public void should_return_true_when_food_list_is_empty() {
        assertThat(pescetarianDiet.accept(emptyList())).isTrue();
    }

    @Test
    public void should_return_true_when_food_list_contains_fish() {
        assertThat(pescetarianDiet.accept(asList(TUNA, LETTUCE))).isTrue();
    }

    @Test
    public void should_return_false_when_food_list_contains_meat() {
        assertThat(pescetarianDiet.accept(asList(LAMB, LETTUCE))).isFalse();
    }

    @Test
    public void should_return_true_when_food_list_contains_only_other_food() {
        assertThat(pescetarianDiet.accept(asList(TOMATO, LETTUCE))).isTrue();
    }

}