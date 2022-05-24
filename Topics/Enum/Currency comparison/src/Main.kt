import java.util.Scanner

enum class Country(val country: String, val currency: String) {
    GERMANY("Germany", "Euro"),
    MALI("Mali", "CFA franc"),
    DOMINICA("Dominica", "Eastern Caribbean dollar"),
    CANADA("Canada", "Canadian dollar"),
    SPAIN("Spain", "Euro"),
    AUSTRALIA("Australia", "Australian dollar"),
    BRAZIL("Brazil", "Brazilian real"),
    SENEGAL("Senegal", "CFA franc"),
    FRANCE("France", "Euro"),
    GRENADA("Grenada", "Eastern Caribbean dollar"),
    KIRIBATI("Kiribati", "Australian dollar")
}

fun main() {
    fun findCountry(input: String): Country? = Country.values().find { it.country == input }

    val scanner = Scanner(System.`in`)
    val country1 = findCountry(scanner.next())
    val country2 = findCountry(scanner.next())

    println(country1?.currency == country2?.currency)
}