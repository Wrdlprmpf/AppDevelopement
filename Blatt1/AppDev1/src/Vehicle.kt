import java.lang.IllegalArgumentException

class Vehicle {

    constructor(
        id: Int,
        name: String,
        brand: Brand,
        workshops: ArrayList<Workshop>,
        weight: Int,
        maxPermissableWeight: Int,
        speed: Double,
        maxSpeed: Double
    ) {
        this.id = id
        this.name = name
        this.brand = brand
        this.workshops = workshops
        this.weight = weight
        this.maxPermissableWeight = maxPermissableWeight
        this.speed = speed
        this.maxSpeed = maxSpeed
    }

    var id: Int = 0
    var name: String = ""
    var brand: Brand = Brand("","","","")
    var workshops = ArrayList<Workshop>()
    var weight = 0
    var maxPermissableWeight = 0
    var speed: Double = 0.0
    var maxSpeed: Double = 0.0


    fun accelerate(): Double{
        if(this.speed + 10 < this.maxSpeed){
            this.speed = this.speed + 10
            return this.speed
        }else{
            throw IllegalArgumentException()
        }
    }

    fun brake(): Double{
        if(this.speed - 10 >= 0){
            this.speed = this.speed - 10
            return this.speed
        }else{
            throw IllegalArgumentException()
        }
    }

    fun drive(kilometers: Int){
        for(n in 1..kilometers){
            for(n in 0..2){
                accelerate()
                println(this.speed)
                brake()
                println(this.speed)
            }
        }
    }

    fun printInfo(){
        println(id)
        println(name)
        println(brand)
        println(workshops)
        println(weight)
        println(maxPermissableWeight)
        println(speed)
        println(maxSpeed)
    }

    fun getWorkshop(postCode : Int): Workshop{
        for(workshop in workshops){
            if(workshop.postcode == postCode){
                return workshop
                break
            }
        }

        throw IllegalArgumentException()

        /*
        for(n in workshops.indices){
            if(workshops[n].postcode == postCode){
                return workshops[n]
            }
        }
         */
    }

    override fun toString(): String {
        return "Vehicle(id=$id, name='$name', brand=$brand, workshops=$workshops, weight=$weight, maxPermissableWeight=$maxPermissableWeight, speed=$speed, maxSpeed=$maxSpeed)"
    }


}