fun main(){

    var adac = ArrayList<Workshop>()

    var marke1 = Brand("BMW","Deutschland","0003030","bmw@bmw.de")
    var werkstatt1 = Workshop("Klagenfurts Werkstatt","Österreich",9020,"Klagenfurt","Klagenfurterstraße","04631112")
    adac.add(werkstatt1)
    var car1 = Vehicle(1,"135i",marke1,adac,1350,2100,20.0,250.0)

    println(car1.toString())
    car1.printInfo()
    car1.drive(2)
    println(car1.getWorkshop(9020))
}