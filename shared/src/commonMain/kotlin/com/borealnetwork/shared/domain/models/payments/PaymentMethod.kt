package com.borealnetwork.shared.domain.models.payments

sealed class PaymentMethod(
    val iconRes: String = "",
    val text: String,
    val iconDescription: String? = null,
) {
    data object CreditDebitPayment : PaymentMethod(
        iconRes = "ic_cards_types.xml",
        iconDescription = "credit debit card",
        text = "Tarjeta de credito / debito"
    )

    data object CashPayment : PaymentMethod(
        iconRes = "ic_cash_payment.xml",
        iconDescription = "cash",
        text = "Contra entrega\nen efectivo"
    )

    data object TransferPayment : PaymentMethod(
        iconRes = "ic_transfer_payment.xml",
        iconDescription = "Transfer",
        text = "Contra entrega\npor tarjeta / transferencia"
    )

    data object PaypalPayment : PaymentMethod(
        iconRes = "ic_paypal.xml",
        iconDescription = "Paypal",
        text = "Pagar con Paypal"
    )

    data object MercadoPagoPayment : PaymentMethod(
        iconRes = "ic_mercado_pago.xml",
        iconDescription = "MercadoPago",
        text = "Pagar con MercadoPago"
    )

}

val paymentList = listOf(
    PaymentMethod.CreditDebitPayment,
    PaymentMethod.CashPayment,
    PaymentMethod.TransferPayment,
    PaymentMethod.PaypalPayment,
    PaymentMethod.MercadoPagoPayment
)