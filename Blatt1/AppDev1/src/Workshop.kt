class Workshop {

    var name = ""
    var country = ""
    var postcode = 0
    var city = ""
    var street = ""
    var phone = ""

    constructor(name: String, country: String, postcode: Int, city: String, street: String, phone: String) {
        this.name = name
        this.country = country
        this.postcode = postcode
        this.city = city
        this.street = street
        this.phone = phone
    }

    override fun toString(): String {
        return "Workshop(name='$name', country='$country', postcode=$postcode, city='$city', street='$street', phone='$phone')"
    }


}