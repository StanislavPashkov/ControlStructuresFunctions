import kotlin.math.max

const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2
//const val MAX_TRANSFER_AMOUNT_VMMM = 150_000
//const val MAX_MONTHLY_TRANSFER_VMMM = 600_000
//const val MAX_TRANSFER_AMOUNT_VK = 15_000
//const val MAX_MONTHLY_TRANSFER_VK = 40_000

fun main() {
    println(commissionCalculate(cardType = "MasterCard", amount = 1000000))

}

fun commissionCalculate(cardType: String = "VK Pay", monthlyTransfers: Int = 0, amount: Int) =
    when (cardType) {
        "Visa", "Mir" -> if (amount <= 150_000 && amount + monthlyTransfers <= 600_000)
            max(35, (amount * 0.0075).toInt()) else ERROR_LIMIT


        "Maestro", "MasterCard" -> if (amount <= 150_000 && amount + monthlyTransfers <= 600_000)
            if (amount > 75000) (0.006 * amount + 20).toInt() else 0
        else ERROR_LIMIT


        "VK Pay" -> if (amount <= 15_000 && amount + monthlyTransfers <= 40_000) 0 else ERROR_LIMIT
        else -> ERROR_TYPE

    }

