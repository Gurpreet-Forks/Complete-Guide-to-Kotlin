package structure

import model.Dish

@MenuBuilderDsl
class DishBuilder(val name: String) {
    enum class Size {
        small,
        large
    }

    enum class Topping {
        pepperoni,
        mushrooms,
        onions
    }

    operator fun Topping.unaryPlus() {
        ingredients.add(this.name)
    }

    operator fun invoke(ingredient: String) {
        add(ingredient)
    }

    var size: Size = Size.small
    val ingredients = mutableListOf<String>()

    val bacon: Boolean
        get() {
            ingredients.add("bacon")
            return true
        }

    val lettuce: Boolean
        get() {
            ingredients.add("lettuce")
            return true
        }

    val tomato: Boolean
        get() {
            ingredients.add("tomato")
            return true
        }

    fun add(ingredient: String): DishBuilder {
        ingredients.add(ingredient)
        return this
    }

    operator fun String.unaryPlus() {
        ingredients.add(this)
    }

    fun build(): Dish {
        return Dish(name, ingredients)
    }
}

