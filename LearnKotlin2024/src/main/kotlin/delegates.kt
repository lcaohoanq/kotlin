import models.Product
import models.User
import storage.MyDBRepository
import storage.MySQLRepository

fun main(){

    //now we talk about delegate, interface
    //var repository = IStorageRepository() //cannot init an object from interface !
    val connectionString = "Server=myServerAddress;Database=myDataBase;Uid=myUsername;Pwd=myPassword;"
    var repository: MySQLRepository = MySQLRepository(connectionString)
    //println(repository)
    var myDBRepository = MyDBRepository(connectionString)
    myDBRepository.makeConnection(connectionString)
    //Delegated properties = make a separated class which override getter/setter
    val user5 = User(11, "Ted", "ted@gmail.com")
    user5.age = 30
    println(user5.age)
    //some standard delegates: lazy, observable
    println(user5.description)
    //create object from key-value map
    val productA = Product(
        mapOf(
            "name" to "iphone 4",
            "price" to 2000
        )
    )
    println(productA)
    //observable property => when property's value changes => a function is run
    productA.description = "hehe"
    productA.description = "haha"
    //property's type is Int
    productA.count = 2
    productA.count = 3
    productA.count = -1 //count still 3 because -1 < 0
    println(productA.count)
    
}

