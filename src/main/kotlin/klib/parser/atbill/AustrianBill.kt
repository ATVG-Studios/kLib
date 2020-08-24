package klib.parser.atbill

/*
 *  This is the complete bill spec that was found in research on Google
 *
 * Tax Normal includes 20%
 * Tax Red 1  includes 10%
 * Tax Red 2  includes 13%
 * Tax None   includes 0%
 * Tax Spec   includes 19%

Source (QR Code Data):

_R1-AT0_0007759_0007759003000202001097592_2020-01-09T17:09:32_3,78_1,99_0,00_0,00_0,00_aGe0roWrPMk=_U:ATU59193205-001_z8qkXAkDVyo=_NTFazirbPJifH6BGKgeJnEQwUWenNQw+E2Am+brnBT1QIKGa3CZyOwVohhszQ0XqfSMtZOCsds5S3s53+xb8+g==

Parsed:

    Algo:       _R1
    Trust:      AT0
    Cash ID:    0007759
    Bill ID:    0007759003000202001097592
    Timestamp:  2020-01-09T17:09:32
    Tax Normal: 3,78
    Tax Red 1:  1,99
    Tax Red 2:  0,00
    Tax None:   0,00
    Tax Spec:   0,00
    Turnover:   aGe0roWrPMk=
    Sig Serial: U:ATU59193205-001
    Link Value: z8qkXAkDVyo=
    Sig Value:  NTFazirbPJifH6BGKgeJnEQwUWenNQw+E2Am+brnBT1QIKGa3CZyOwVohhszQ0XqfSMtZOCsds5S3s53+xb8+g==
 */

typealias AustrianBill = RksvBill

/**
 * Parser for the content of a QR-Code on a Austrian Bill
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
data class RksvBill(
    var algorithm: String = "",
    var signTrust: String = "",
    var cashBoxId: String = "",
    var billId: String = "",
    var timestamp: String = "",
    var sumTaxNormal: Double = 0.0,
    var sumTaxReduced1: Double = 0.0,
    var sumTaxReduced2: Double = 0.0,
    var sumTaxNone: Double = 0.0,
    var sumTaxSpecial: Double = 0.0,
    var encryptedTurnover: String = "",
    var signSerial: String = "",
    var previousReceiptSign: String = "",
    var totalSum: Double = 0.0
) {
    companion object {
        /**
         * Parse the content of a QR-Code
         *
         * @param input The QR-Code data
         * @return RksvBill Object
         *
         * @since 4.1.0
         * @author Thomas Obernosterer
         */
        fun parseString(input: String) = RksvBillParser.parseStringForObject(input)
    }

    object Keys {
        final val algorithm = "algorithm"
        final val signTrust = "sign-trust"
        final val cashBoxId = "cash-box-id"
        final val billId = "bill-id"
        final val timestamp = "timestamp"
        final val sumTaxNormal = "sum-tax-normal"
        final val sumTaxReduced1 = "sum-tax-reduced-1"
        final val sumTaxReduced2 = "sum-tax-reduced-2"
        final val sumTaxNone = "sum-tax-none"
        final val sumTaxSpecial = "sum-tax-special"
        final val totalSum = "total-sum"
        final val encryptedTurnover = "encrypted-turnover"
        final val signSerial = "sign-serial"
        final val previousReceiptSign = "previous-receipt-sign"
    }
}

object RksvBillParser {
    /**
     * Parse the content of a QR-Code
     *
     * @param input The QR-Code data
     * @return RksvBill Object
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun parseStringForObject(input: String): RksvBill {
        val value = input.replaceFirst("_", " ").replace(",", ".").split("_")
        val bill = RksvBill()
        val algoTrust = value[0].split("-")

        var i = 0

        bill.algorithm = algoTrust[0]
        bill.signTrust = algoTrust[1]

        bill.cashBoxId = value[++i]
        bill.billId = value[++i]
        bill.timestamp = value[++i]

        bill.sumTaxNormal = value[++i].toDoubleOrNull() ?: 0.0
        bill.sumTaxReduced1 = value[++i].toDoubleOrNull() ?: 0.0
        bill.sumTaxReduced2 = value[++i].toDoubleOrNull() ?: 0.0
        bill.sumTaxNone = value[++i].toDoubleOrNull() ?: 0.0
        bill.sumTaxSpecial = value[++i].toDoubleOrNull() ?: 0.0

        bill.totalSum = bill.sumTaxNormal + bill.sumTaxReduced1 + bill.sumTaxReduced2 + bill.sumTaxNone + bill.sumTaxSpecial

        bill.encryptedTurnover = value[++i]
        bill.signSerial = value[++i]
        bill.previousReceiptSign = value[++i]

        return bill
    }

    /**
     * Parse the content of a QR-Code
     *
     * @param input The QR-Code data
     * @return Map<String, Any>
     *
     * @since 5.1.0
     * @author Thomas Obernosterer
     */
    fun parseStringForMap(input: String): Map<String, Any> {
        val value = input.replaceFirst("_", " ").replace(",", ".").split("_")
        val algoTrust = value[0].split("-")

        val map: MutableMap<String, Any> = HashMap()

        var i = 0

        map[RksvBill.Keys.algorithm] = algoTrust[0]
        map[RksvBill.Keys.signTrust] = algoTrust[1]

        map[RksvBill.Keys.cashBoxId] = value[++i]
        map[RksvBill.Keys.billId] = value[++i]
        map[RksvBill.Keys.timestamp] = value[++i]

        map[RksvBill.Keys.sumTaxNormal] = value[++i].toDoubleOrNull() ?: 0.0
        map[RksvBill.Keys.sumTaxReduced1] = value[++i].toDoubleOrNull() ?: 0.0
        map[RksvBill.Keys.sumTaxReduced2] = value[++i].toDoubleOrNull() ?: 0.0
        map[RksvBill.Keys.sumTaxNone] = value[++i].toDoubleOrNull() ?: 0.0
        map[RksvBill.Keys.sumTaxSpecial] = value[++i].toDoubleOrNull() ?: 0.0

        map[RksvBill.Keys.totalSum] = map[RksvBill.Keys.sumTaxNormal] as Double +
            map[RksvBill.Keys.sumTaxReduced1] as Double +
            map[RksvBill.Keys.sumTaxReduced2] as Double +
            map[RksvBill.Keys.sumTaxNone] as Double +
            map[RksvBill.Keys.sumTaxSpecial] as Double

        map[RksvBill.Keys.encryptedTurnover] = value[++i]
        map[RksvBill.Keys.signSerial] = value[++i]
        map[RksvBill.Keys.previousReceiptSign] = value[++i]

        return map
    }
}
