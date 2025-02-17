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
    @Test
    fun t2(){

        val input = """
            등록
            몰라
            사람임
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        assert(str.contains("종료"))
        assert(str.contains("등록"))
        assert(str.contains("작가"))
        assert(str.contains("명언"))

    }


}