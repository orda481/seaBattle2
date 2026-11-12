class Player {
    var name: String = ""
    var field: Array<CharArray> = Array(10){CharArray(10) {'.'} }
    var shots: Int =0
    var hits: Int =0
    var shipsLeft: Int = 20
    fun isAlive(): Boolean{
        return shipsLeft > 0
    }
    fun accuracy(): Double {
        if (shots == 0) return 0.0
        return hits * 100.0 / shots
    }
    fun status(): String {
        val acc = String.format("%.1f", accuracy())
        return "Игрок $name: палуб осталось $shipsLeft, выстрелов $shots, попаданий $hits, точность $acc%"
    }
    fun takeDamage(): Boolean {
        shipsLeft--
        return isAlive()
    }
    fun registerShot(hit: Boolean) {
        shots++
        if (hit) {
            hits++
        }
    }
    fun reset() {
        shots = 0
        hits = 0
        shipsLeft = 20
        for (r in field.indices) {
            for (c in field[r].indices) {
                field[r][c] = '.'
            }
        }
    }
    fun printField() {
        println("=== Поле игрока $name ===")
        print("   ")
        for (c in 0 ..9) print("$c ")
        println()
        for(r in 0..9) {
            print("$r ")
            for (c in 0 ..9) print("${field[r][c]} ")
            println()
        }
    }
    fun printStatus(){
        println("Player $name: shoots $shots, hits $hits ")
    }
}
fun printBothFields(player: Player, enemy: Player) {
    println("=== Поле игрока ${player.name} ===        === Поле игрока ${enemy.name} ===")
    print("  ")
    for (c in 0..9) print("$c ")
    print("      ")
    print("  ")
    for (c in 0..9) print("$c ")
    println()
    for (r in 0..9) {
        print("$r ")
        for (c in 0..9) print("${player.field[r][c]} ")
        print("      ")
        print("$r ")
        for (c in 0..9) print("${enemy.field[r][c]} ")
        println()
    }
}