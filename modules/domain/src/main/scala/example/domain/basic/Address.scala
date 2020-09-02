package example.domain.basic

case class Address(
    zipCode: ZipCode,
    prefecture: Prefecture,
    city: City,
    town: Town,
    coordinate: Coordinate
)
