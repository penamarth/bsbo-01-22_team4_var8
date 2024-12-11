package com.rentSystem.project

import java.util.*

class PropertyManager : IPropertyManager {
    private val properties: MutableList<Property> = mutableListOf()

    override fun addProperty(property: Property): UUID {
        properties.add(property)
        println("Property added: $property")
        return property.ID
    }

    override fun getPropertyByID(propertyID: UUID): Property {
        val property = properties.find { it.ID == propertyID }
        return if (property != null) {
            println("Retrieved Property: $property")
            property
        } else {
            println("Property with ID $propertyID not found")
            throw PropertyNotFoundException()
        }
    }

    override fun getPropertiesByOwner(ownerID: UUID): List<Property> {
        val ownerProperties = properties.filter { it.ownerId == ownerID }
        println("Retrieved ${ownerProperties.size} properties for Owner ID $ownerID")
        return ownerProperties
    }

    override fun updateProperty(propertyID: UUID, updatedProperty: Property) {
        val index = properties.indexOfFirst { it.ID == propertyID }
        if (index != -1) {
            properties[index] = updatedProperty
            println("Property with ID $propertyID updated to: $updatedProperty")
        } else {
            println("Cannot update. Property with ID $propertyID not found")
            throw PropertyNotFoundException()
        }
    }

    override fun removeProperty(propertyID: UUID) {
        val removed = properties.removeIf { it.ID == propertyID }
        if (removed) {
            println("Property with ID $propertyID removed successfully")
        } else {
            println("Cannot remove. Property with ID $propertyID not found")
            throw PropertyNotFoundException()
        }
    }
}
