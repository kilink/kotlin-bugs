package net.kilink.kotlin

import org.junit.Assert.assertTrue
import org.junit.Test

class PairNullCheckTest {
    @Test
    fun testPairNullCheck() {
        val x: Pair<Int?, Int> = 5 to 10

        if (x.first == null) throw IllegalArgumentException()

        // This will not compile :
        // assertTrue(x.first < x.second)

        // This required non-null assertion causes the compiler warning:
        // "Unnecessary non-null assertion (!!) on a non-null receiver of type Int"
        assertTrue(x.first!! < x.second)

        // This gets highlighted as a syntax issue in IntelliJ, but compiles and runs fine
        assertTrue(x.first < x.second)
    }

    @Test
    fun testDataClass() {
        data class Foobar(val x: Int?, val y: Int)

        val foo: Foobar = Foobar(1, 2)

        if (foo.x == null) throw IllegalArgumentException()

        // No warning for data class
        assertTrue(foo.x < foo.y)
    }
}
