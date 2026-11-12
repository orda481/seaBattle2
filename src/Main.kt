fun main() {
    val player = Player()
    player.name = "Вы"
    player.registerShot(true)
    player.registerShot(false)
    player.registerShot(true)
    println(player.status())
    player.takeDamage()
    player.takeDamage()
    println(player.shipsLeft)
    println(player.isAlive())
    player.reset()
    println(player.status())
    //1. Метод нужен, чтобы объект сам управлял своим состоянием
    //2. Метод находится внутри класса и работает с полем своего объекта. Функция глобальна, для ее вызова потребовался бы параметр
    //3. Благодаря нему не нужно вручную обновлять данные
}