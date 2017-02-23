package magelle.kebab;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KebabShopIT {

    @Test
    public void should_make_a_kebab() {
        Kebab kebab = new Kebab(Ingredient.Lettuce, Ingredient.Tomato, Ingredient.cheddar, Ingredient.Lamb);
        assertThat(kebab).isNotNull();
    }

}