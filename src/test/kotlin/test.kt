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
        println(1)

    }
    @Test
    fun t3(){

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
        assert(str.contains("1번 명언이 등록되었습니다"))
    }
    @Test
    fun t4(){

        val input = """
            등록
            몰라1
            사람임1
            등록
            몰라2
            사람임2
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        assert(str.contains("종료"))
        assert(str.contains("등록"))
        assert(str.contains("작가"))
        assert(str.contains("명언"))
        assert(str.contains("2번 명언이 등록되었습니다"))
        assert(str.contains("3번 명언이 등록되었습니다"))

    }
    @Test
    fun t5(){

        val input = """
            목록
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        assert(str.contains("사람임1"))
        assert(str.contains("몰라1"))
        assert(str.contains("사람임2"))
        assert(str.contains("몰라2"))

    }
    @Test
    fun t6(){

        val input = """
            삭제?id=1
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        println(str)
        assert(str.contains("1번 명언 삭제"))

    }


}