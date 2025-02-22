package test

import org.example.test.Service
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
            등록
            몰라2
            사람임2
            등록
            몰라2
            사람임2
            등록
            몰라2
            사람임2
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

    }
    @Test
    fun t6(){

        val input = """
            삭제?id=1
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        assert(str.contains("1번 명언 삭제"))

    }

    @Test
    fun t7(){

        val input = """
            삭제?id=1123
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        assert(str.contains("1123번 명언은 존재하지 않습니다."))

    }
    @Test
    fun t8(){

        val input = """
            수정?id=2
            바뀐명언2
            바뀐이름2
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        val entity = org.example.test.Service.get(2)
        assert(entity!!.content.contains("바뀐명언"))



    }
    @Test
    fun t9(){

        val input = """
            빌드
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        assert(str.contains("data.json 파일의 내용이 갱신되었습니다."))

    }
    @Test
    fun t10(){

        val input = """
            목록?keywordType=author&keyword=바뀐
            종료
                """.trimIndent()
        val str: String = TestUtil.run(input)
        println(str)
        assert(str.contains("바뀐명언"))
        assert(!str.contains("몰라"))

    }




}