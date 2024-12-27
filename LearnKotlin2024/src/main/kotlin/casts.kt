/*
    Unsafe cast operator: as
    - A nullable type can be cast to a non-nullable type using the unsafe cast operator as,
     but throw a ClassCastException if the nullable type is null. To avoid the exception, the source and target must be the same type.
    
    Safe cast operator: as?
    - Return null if the cast is not possible instead of throwing an exception.
*/