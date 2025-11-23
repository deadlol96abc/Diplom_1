import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

    @RunWith(MockitoJUnitRunner.class)

        public class BurgerTest {

        @Mock

        private Bun bun;

        @Mock

        private Ingredient ingredient;
        private Burger burger;

    @Before

        public void setUp() {
            burger = new Burger();

        }

    @Test
    public void setBuns() {
        burger.setBuns(bun);

        assertEquals("Булочка", bun, burger.bun);
    }

    @Test
    public void addIngredient() {

        burger.addIngredient(ingredient);

        assertEquals("Ингредиент не добавился", 1, burger.ingredients.size());
        assertEquals("Неверный ингредиент", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient() {

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertEquals("Ингредиент не получилось уудалить", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {

        Ingredient secondIngredient = Mockito.mock(Ingredient.class);

        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);

        assertEquals("Ингредиент не переместился", ingredient, burger.ingredients.get(1));
    }

    @Test
    public void getReceipt() {


        Mockito.when(bun.getName()).thenReturn("original");
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili");
        Mockito.when(ingredient.getPrice()).thenReturn(20.0f);


        burger.setBuns(bun);
        burger.addIngredient(ingredient);


        String receipt = burger.getReceipt();

        assertEquals("Чек должен содержать название булочки", true, receipt.contains("original"));
        assertEquals("Чек должен содержать ингредиент", true, receipt.contains("chili"));
    }
}