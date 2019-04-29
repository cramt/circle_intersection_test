fun main(args: Array<String>) {
    val b = Circle(Vector2(-15.0, 0.0), 25.0)
    val a = Circle(Vector2(0.0, 28.0), 20.0)
    val c = Circle(Vector2(30.0, 0.0), 25.0)
    println(Circle.tripleIntersection(a, b, c))
}
