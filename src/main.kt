fun main(args: Array<String>) {
    val b = Circle(Vector2(-15.0, 0.0), 25.0)
    val a = Circle(Vector2(0.0, 28.0), 20.0)
    val c = Circle(Vector2(30.0, 0.0), 25.0)
    println(tribleIntersection(a, b, c))
}

fun tribleIntersection(c1: Circle, c2: Circle, c3: Circle): Vector2 {
    val interSections = arrayOf(
        CircleCircleIntersection(c1, c2),
        CircleCircleIntersection(c2, c3),
        CircleCircleIntersection(c3, c1)
    )
    val vectorList1 = mutableListOf<Vector2>()
    val vectorList2 = mutableListOf<Vector2>()
    vectorList1.add(interSections[0].intersectionPoint1)
    vectorList2.add(interSections[0].intersectionPoint2)
    for (i in 1 until interSections.size) {
        if (interSections[0].intersectionPoint1.length(interSections[i].intersectionPoint1) < interSections[0].intersectionPoint1.length(
                interSections[i].intersectionPoint2
            )
        ) {
            vectorList1.add(interSections[i].intersectionPoint1)
        } else {
            vectorList1.add(interSections[i].intersectionPoint2)
        }

        if (interSections[0].intersectionPoint2.length(interSections[i].intersectionPoint1) < interSections[0].intersectionPoint2.length(
                interSections[i].intersectionPoint2
            )
        ) {
            vectorList2.add(interSections[i].intersectionPoint1)
        } else {
            vectorList2.add(interSections[i].intersectionPoint2)
        }
    }
    val vectorList =
        if (vectorList1.map { vectorList1[0].length(it) }.average() < vectorList2.map { vectorList2[0].length(it) }.average()) {
            vectorList1
        } else {
            vectorList2
        }
    return Vector2(vectorList.sumByDouble { it.x } / vectorList.size, vectorList.sumByDouble { it.y } / vectorList.size)
}