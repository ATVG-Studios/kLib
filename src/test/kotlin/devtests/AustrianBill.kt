package devtests

import klib.parser.atbill.AustrianBill

fun main() {
    val bill = AustrianBill.parseString("_R1-AT0_0007759_0007759003000202001097592_2020-01-09T17:09:32_3,78_1,99_0,00_0,00_0,00_aGe0roWrPMk=_U:ATU59193205-001_z8qkXAkDVyo=_NTFazirbPJifH6BGKgeJnEQwUWenNQw+E2Am+brnBT1QIKGa3CZyOwVohhszQ0XqfSMtZOCsds5S3s53+xb8+g==")

    println(bill)
}