package com.rentSystem.project

import java.util.*

data class Agreement(
    val ID: UUID = UUID.randomUUID(),
    val bookingId: UUID,
    val tenantId: UUID,
    val ownerId: UUID,
    val propertyId: UUID,
    val agreementDate: Date = Date(),
    val terms: String
) {
    override fun toString(): String {
        return "Agreement(ID=$ID, bookingId=$bookingId, tenantId=$tenantId, ownerId=$ownerId, propertyId=$propertyId, agreementDate=$agreementDate, terms='$terms')"
    }
}