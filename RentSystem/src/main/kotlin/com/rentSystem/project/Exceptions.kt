package com.rentSystem.project
class UserNotFoundException(message: String = "User not found") : Exception(message)
class BookingNotFoundException(message: String = "Booking not found") : Exception(message)
class PropertyNotFoundException(message: String = "Property not found") : Exception(message)
class InvalidUserDataException(message: String = "Invalid user data") : Exception(message)
class AgreementFormationException(message: String = "Failed to form rental agreement") : Exception(message)
