package magelle.kebab;

import magelle.kebab.diet.PescetarianDiet;
import magelle.kebab.diet.VegetarianDiet;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KebabShopIT {

    @Test
    public void make_a_kebab() {
        Kebab kebab = new Kebab(Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.CHEDDAR, Ingredient.LAMB);
        assertThat(kebab).isNotNull();
        assertThat(kebab.getIngredients())
                .containsExactly(Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.CHEDDAR, Ingredient.LAMB);
    }

    @Test
    public void kebab_without_fish_and_meat_is_vegetarian() {
        Kebab kebab = new Kebab(Ingredient.LETTUCE, Ingredient.TOMATO, Ingredient.CHEDDAR);
        assertThat(kebab.validate(new VegetarianDiet())).isTrue();
    }

    @Test
    public void kebab_with_meat_is_not_vegetarian() {
        Kebab kebab = new Kebab(Ingredient.LAMB, Ingredient.LETTUCE);
        assertThat(kebab.validate(new VegetarianDiet())).isFalse();
    }

    @Test
    public void kebab_with_fish_is_not_vegetarian() {
        Kebab kebab = new Kebab(Ingredient.TUNA, Ingredient.LETTUCE);
        assertThat(kebab.validate(new VegetarianDiet())).isFalse();
    }

    @Test
    public void kebab_without_fish_or_meat_is_pescetarian() {
        Kebab kebab = new Kebab(Ingredient.LETTUCE, Ingredient.CHEDDAR);
        assertThat(kebab.validate(new PescetarianDiet())).isTrue();
    }

    @Test
    public void kebab_with_meat_is_not_pescetarian() {
        Kebab kebab = new Kebab(Ingredient.LAMB, Ingredient.LETTUCE);
        assertThat(kebab.validate(new PescetarianDiet())).isFalse();
    }

    @Test
    public void kebab_with_fish_is_pescetarian() {
        Kebab kebab = new Kebab(Ingredient.TUNA, Ingredient.LETTUCE);
        assertThat(kebab.validate(new PescetarianDiet())).isTrue();
    }

}