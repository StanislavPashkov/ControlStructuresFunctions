fun main() {
    var amount = commissionCalculate("MasterCard", amount = 75000)
    amount = commissionCalculate("Maestro", amount = 75001)
    amount = commissionCalculate("MasterCard", 50000, amount = 25000)
    amount = commissionCalculate("Maestro", 40000, amount = 35001)
    amount = commissionCalculate(amount = 75001)
    amount = commissionCalculate(monthlyTransfers = 50000, amount = 30000)
}

fun commissionCalculate(cardType: String = "VK Pay", monthlyTransfers: Int = 0, amount: Int) {
    val commissionStart = when {
        monthlyTransfers > 75000 -> 0.0075 * amount
        monthlyTransfers + amount > 75000 -> 0.0075 * amount
        else -> 0.0
    }
    val card = when (cardType) {
        "Maestro", "MasterCard" -> commissionStart
        else -> 0.0
    }
    val commission = String.format("%.2f", card)
    println("Комиссия: $commission копеек ")
}

