package magelle.kebab;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KebabShopIT {

    @Test
    public void should_make_a_kebab() {
        Kebab kebab = new Kebab(Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.CHEDDAR, Ingredient.LAMB);
        assertThat(kebab).isNotNull();
        assertThat(kebab.getIngredients())
                .containsExactly(Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.CHEDDAR, Ingredient.LAMB);
    }

    @Test
    public void should_make_a_vegetarian_kebab() {
        Kebab kebab = new Kebab(Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.CHEDDAR);
        assertThat(kebab.isVegetarian()).isTrue();
    }

    @Test
    public void should_make_a_not_vegetarian_kebab() {
        Kebab kebab = new Kebab(Ingredient.LAMB, Ingredient.LETTUCE);
        assertThat(kebab.isVegetarian()).isFalse();
    }

}