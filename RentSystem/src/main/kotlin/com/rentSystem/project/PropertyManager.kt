package com.rentSystem.project

import java.util.*

class PropertyManager : IPropertyManager {
    private val properties = mutableListOf<Property>()

    override fun addProperty(property: Property): UUID {
        properties.add(property)
        return property.id
    }

    override fun getPropertyByID(propertyID: UUID): Property? {
        return properties.find { it.id == propertyID }
    }

    override fun getPropertiesByOwner(ownerID: UUID): List<Property> {
        return properties // Для простоты, все объявления для владельца
    }
}
