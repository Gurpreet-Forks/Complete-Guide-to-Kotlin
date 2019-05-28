package builder

import assertk.assertThat
import assertk.assertions.isEqualTo
import model.Dish
import model.Menu
import org.junit.jupiter.api.Test

class NonDslTest {
    @Test
    fun `create menu`() {
        val dishes = mutableListOf<Dish>()

        val ingredientsForBlt = listOf("bacon", "lettuce", "tomato")
        val blt = Dish("blt", ingredientsForBlt)
        dishes.add(blt)

        val ingredientsForPizza = listOf("pepperoni", "mushrooms")
        val pizza = Dish("pizza", ingredientsForPizza)
        dishes.add(pizza)

        val menu = Menu("Sunshine", dishes)

        assertThat(menu.name).isEqualTo("Sunshine")
        assertThat(menu.dishes.size).isEqualTo(3)
    }
}