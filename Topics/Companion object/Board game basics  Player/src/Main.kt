class Player(val id: Int, val name: String, val hp: Int) {
    companion object Properties {
        var id = 0
        const val hp = 100

        fun create(name: String): Player {
            id++
            return Player(id, name, hp)
        }

    }
}