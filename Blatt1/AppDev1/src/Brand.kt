class Brand {

    var name = ""
    var country = ""
    var phone = ""
    var email = ""

    constructor(name: String, country: String, phone: String, email: String) {
        this.name = name
        this.country = country
        this.phone = phone
        this.email = email
    }

    override fun toString(): String {
        return "Brand(name='$name', country='$country', phone='$phone', email='$email')"
    }


}