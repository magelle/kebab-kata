package magelle.kebab.diet;

import magelle.kebab.Food;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static magelle.kebab.FoodType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VegetarianDietTest {

    private VegetarianDiet vegetarianDiet = new VegetarianDiet();

    @Test
    public void should_return_true_when_food_list_is_empty() {
        assertThat(vegetarianDiet.accept(emptyList())).isTrue();
    }

    @Test
    public void should_return_false_when_food_list_contains_meat() {
        Food food = mock(Food.class);
        when(food.getFoodType()).thenReturn(MEAT);
        assertThat(vegetarianDiet.accept(singletonList(food))).isFalse();
    }

    @Test
    public void should_return_false_when_food_list_contains_fish() {
        Food food = mock(Food.class);
        when(food.getFoodType()).thenReturn(FISH);
        assertThat(vegetarianDiet.accept(singletonList(food))).isFalse();
    }

    @Test
    public void should_return_true_when_food_list_contains_nether_fish_or_meat() {
        Food food = mock(Food.class);
        when(food.getFoodType()).thenReturn(OTHER);
        assertThat(vegetarianDiet.accept(singletonList(food))).isTrue();
    }

}