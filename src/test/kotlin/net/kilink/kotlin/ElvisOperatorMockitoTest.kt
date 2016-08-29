package net.kilink.kotlin

import org.junit.Test
import org.mockito.Mockito.any
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as whenever

interface Foo {
    fun getBar(baz: String): String
}

class ElvisOperatorMockitoTest {
    val foo: Foo = mock(Foo::class.java)

    @Test
    fun testGetBar() {
        // this fails because any() returns null
        // whenever(foo.getBar(any())).thenReturn("ok")

        // this produces a spurious warning
        whenever(foo.getBar(any() ?: "")).thenReturn("ok")
    }
}
