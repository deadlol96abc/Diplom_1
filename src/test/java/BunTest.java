import org.junit.Test;
import org.junit.Before;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest  {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("original", 200.0f);  // Убрать тип Bun!
    }

    @Test
    public void getName() {
        String expectedNameBun = "original";
        String actualNameBun = bun.getName();

        assertEquals("Ошибка в названии булочки", expectedNameBun, actualNameBun);
    }

    @Test
    public void getPrice() {
        float expectedBunPrice = 200.0f;
        float actualBunPrice = bun.getPrice();

        assertEquals("Ошибка в цене на булочку", expectedBunPrice, actualBunPrice, 0);
    }
}