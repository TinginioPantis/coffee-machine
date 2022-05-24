class Task(val name: String)

object Manager {
    fun solveTask(task: Task) {
        println("Task ${task.name} solved!")
        solvedTask++
    }

    var solvedTask: Int = 0
}