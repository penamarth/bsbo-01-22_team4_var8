package com.rentSystem.project

import java.util.UUID

interface IPropertyManager {
    fun addProperty(property: Property): UUID
    fun getPropertyByID(propertyID: UUID): Property?
    fun getPropertiesByOwner(ownerID: UUID): List<Property>
}
