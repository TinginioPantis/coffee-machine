package machine

data class MachineState(val water: Int, val milk: Int, val beans: Int, val cups: Int, val money: Int) {
    companion object {
        val Initial = MachineState(water = 400, milk = 540, beans = 120, cups = 9, money = 550)
    }

    fun makeOrder(orderableRecipe: OrderableRecipe): MachineState = copy(
        water = water - orderableRecipe.recipe.water,
        milk = milk - orderableRecipe.recipe.milk,
        beans = beans - orderableRecipe.recipe.beans,
        money = money + orderableRecipe.cost,
        cups = cups - 1
    )
}

data class Recipe(val water: Int, val milk: Int, val beans: Int)
data class OrderableRecipe(val recipe: Recipe, val cost: Int)

val cappuccinoRecipe = OrderableRecipe(Recipe(water = 200, milk = 100, beans = 12), cost = 6)
val latteRecipe = OrderableRecipe(Recipe(water = 350, milk = 75, beans = 20), cost = 7)
val espressoRecipe = OrderableRecipe(Recipe(water = 250, milk = 0, beans = 16), cost = 4)

fun main() {
  runUntilUserExits()
}

fun runUntilUserExits() {
    var userWantsToExit = false
    var machine = MachineState.Initial
    while (!userWantsToExit) {
        val selection = menu()
        println()
        when (selection) {
            MenuSelection.Buy -> {
                machine = buy(machine)
                println()
            }
            MenuSelection.Fill -> {
                machine = fill(machine)
                println()
            }
            MenuSelection.Take -> {
                machine = take(machine)
                println()
            }
            MenuSelection.Remaining -> {
                println(coffeeMachineState(machine))
                println()
            }
            MenuSelection.Exit -> userWantsToExit = true
            else -> println("Choose from provided actions!")
        }
    }
}

fun coffeeMachineState(m: MachineState): String =
    """The coffee machine has:
      |${m.water} ml of water
      |${m.milk} ml of milk
      |${m.beans} g of coffee beans
      |${m.cups} disposable cups
      |$${m.money} of money
      |""".trimMargin().trim()

fun menu(): MenuSelection? {
    print("Write action (buy, fill, take, remaining, exit): ")
    val answer = readLine()!!
    return when (answer) {
        "buy" -> MenuSelection.Buy
        "fill" -> MenuSelection.Fill
        "take" -> MenuSelection.Take
        "remaining" -> MenuSelection.Remaining
        "exit" -> MenuSelection.Exit
        else -> null
    }
}

enum class MenuSelection {
    Buy, Fill, Take, Remaining, Exit
}

fun buy(m: MachineState): MachineState {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    val variety = readLine()!!

    when (val selection = parseSelection(variety)) {
        SelectedBack -> {
            println()
            return m
        }
        null -> {
            println("You entered unknown command!")
            return m
        }
        is SelectedRecipe -> {
            val error = enoughResourcesFor(selection.orderableRecipe.recipe, m)
            return if (error != null) {
                println(render(error))
                m
            } else {
                println("I have enough resources, making you a coffee!")
                m.makeOrder(selection.orderableRecipe)
            }
        }
    }
}

sealed interface BuyUserSelection
data class SelectedRecipe(val orderableRecipe: OrderableRecipe) : BuyUserSelection
object SelectedBack : BuyUserSelection

fun parseSelection(str: String): BuyUserSelection? =
    when (str) {
        "1" -> SelectedRecipe(espressoRecipe)
        "2" -> SelectedRecipe(latteRecipe)
        "3" -> SelectedRecipe(cappuccinoRecipe)
        "back" -> SelectedBack
        else -> null
    }

enum class ResourcesError {
    NotEnoughWater, NotEnoughMilk, NotEnoughCoffeeBeans, NotEnoughCups
}
fun render(error: ResourcesError): String = when (error) {
    ResourcesError.NotEnoughWater -> "Sorry, not enough water!"
    ResourcesError.NotEnoughMilk -> "Sorry, not enough milk!"
    ResourcesError.NotEnoughCoffeeBeans -> "Sorry, not enough coffee beans!"
    ResourcesError.NotEnoughCups -> "Sorry, not enough disposable cups!"
}

fun enoughResourcesFor(recipe: Recipe, m: MachineState): ResourcesError? =
    if (m.water < recipe.water) ResourcesError.NotEnoughWater
    else if (m.milk < recipe.milk) ResourcesError.NotEnoughMilk
    else if (m.beans < recipe.beans) ResourcesError.NotEnoughCoffeeBeans
    else if (m.cups < 0) ResourcesError.NotEnoughCups
    else null

fun fill(m: MachineState): MachineState {
    print("Write how many ml of water do you want to add: ")
    val addedWater = readLine()!!.toInt()
    print("Write how many ml of milk do you want to add: ")
    val addedMilk = readLine()!!.toInt()
    print("Write how many grams of coffee beans do you want to add: ")
    val addedBeans = readLine()!!.toInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    val addedDispCups = readLine()!!.toInt()
    return m.copy(
        water = m.water + addedWater, milk = m.milk + addedMilk, beans = m.beans + addedBeans,
        cups = m.cups + addedDispCups
    )
}

fun take(m: MachineState): MachineState {
    println("I gave you $${m.money}")
    return m.copy(money = 0)
}