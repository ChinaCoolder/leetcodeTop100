package GenerateParentheses

fun main() {
    println(generateParenthesis(4))
}

fun generateParenthesis(n: Int): List<String> {
    if (n == 1) {
        return listOf("()")
    }
    val res = mutableListOf<String>()

    fun findAll(current: String, op: Int , cl: Int, length: Int){
        if(current.length == 2 * length){
            res.add(current)
            return
        }
        if(op < length) {
            findAll("$current(", op + 1, cl, length)
        }
        if(cl < op) {
            findAll("$current)", op, cl + 1, length)
        }
    }

    findAll("(", 1, 0, n)

    return res
}