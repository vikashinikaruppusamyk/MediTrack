# Design Decisions

## 1. Why Person is Abstract
Person is abstract because no plain "Person" object exists in a clinic.
Every person is either a Doctor or a Patient. Making it abstract prevents
accidental instantiation and forces subclasses to implement displayInfo().

## 2. Why MedicalEntity is Separate from Person
Appointment and Bill are not people — they cannot extend Person.
MedicalEntity provides a common id field for non-person entities
without breaking Java's single inheritance rule.

## 3. Why DataStore<T> is Generic
Instead of creating separate storage classes for each entity,
DataStore<T> provides one reusable storage solution for any type.
This follows the DRY principle and reduces code duplication.

## 4. Why Validator is Centralized
Validation logic is kept in one place so any changes to rules
only need to be made once. It also ensures consistent validation
across all services and prevents invalid data from entering the system.

## 5. Why BillSummary is Immutable
Once a bill is generated and given to a patient, it should never
be modified. Immutability ensures data integrity and makes
BillSummary thread-safe by design.