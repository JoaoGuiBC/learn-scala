package lectures.fp

object TuplesAndMaps extends App {
  val aTuple = new Tuple2(2, "Hello Scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1)
  println(aTuple.copy(_2 = "Goodbye Java"))
  println(aTuple.swap)

  // Maps - chaves -> valores
  val aMap: Map[String, Int] = Map()
  val phonebook = Map(("John", 123), "Jane" -> 101, "JOHN" -> 897).withDefaultValue(-1)
  // a -> b é syntactic sugar pra (a, b)
  println(phonebook)

  // Map ops
  println(phonebook.contains("John"))
  println(phonebook("John"))
  println(phonebook("Joe"))

  // adicionar emparelhamento
  val newPairing = "Mary" -> 159
  val newPhonebok = phonebook + newPairing

  println(newPhonebok)

  // Funções em Maps
  println(phonebook.map(pair => pair._1.toLowerCase() -> pair._2))

  // filterKeys
  println(phonebook.filterKeys(_.startsWith("Jo")).toMap)

  // mapValues
  println(phonebook.mapValues(number => number * 2).toMap)

  // conversões
  println(phonebook.toList)
  println(List(("David", 100)).toMap)
  
  val names = List("Bob", "James", "Mandy", "Mary", "Joe", "Muse")
  println(names.groupBy(_.charAt(0)))

  val socialNetwork: Map[String, Set[String]] = Map("John" -> Set("Mary"), "Mary" -> Set("John"))

  def addUser(username: String, map: Map[String, Set[String]]): Map[String, Set[String]] =
    map + ("Mary" -> Set())
  
  def removeUser(username: String, map: Map[String, Set[String]]): Map[String, Set[String]] =
    if !map.contains(username) then map
    else 
      val newMap = for m <- map yield
        if m._2.contains(username) then (m._1 -> m._2.filter(_ != username))
        else m
  
      newMap.filter(person => person._1 != username)

  def friend(user1: String, user2: String, map: Map[String, Set[String]]): Map[String, Set[String]] =
    if map.contains(user1) || map.contains(user2) then
      val user1Friends = map(user1)
      val user2Friends = map(user2)

      map + (user1 -> (user1Friends + user2)) + (user2 -> (user2Friends + user1))
    else map

  def unfriend(user1: String, user2: String, map: Map[String, Set[String]]): Map[String, Set[String]] =
    if map.contains(user1) || map.contains(user2) then
      val user1Friends = map(user1).filter(_ != user2)
      val user2Friends = map(user2).filter(_ != user1)

      map + (user1 -> user1Friends) + (user2 -> user2Friends)
    else map

  def numberOfFriends(user: String, map: Map[String, Set[String]]): Int = 
    if !map.contains(user) then 0
    else map(user).size
    
  def usersWithNoFriends(map: Map[String, Set[String]]): Int =
    map.filter(user => user._2.size == 0).size
}
