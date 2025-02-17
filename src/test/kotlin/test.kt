import kotlin.test.Test

class test {
    @Test
    fun t1(){

        val input = """
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        assert(str.contains("종료"))

    }


}