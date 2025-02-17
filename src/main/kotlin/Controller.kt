package org.example

import java.util.*

@Target(AnnotationTarget.FUNCTION)
annotation class handler(val value: String)
class Controller {
    private lateinit var sc:Scanner
    lateinit var thread: Thread
    private var isThreadRun = true
    constructor(sc:Scanner) {
        this.sc = sc
        thread = Thread { repeat() }
        thread.start()
    }
    constructor() {
        this.sc = Scanner(System.`in`)
        thread = Thread { repeat() }
        thread.start()
    }
    private fun input(): String{
        print("입력하세요: ")
        if (!sc.hasNextLine()) return "종료"
        val result: String = sc.nextLine()
        println(result)
        return result
    }
    private fun repeat(){
        while (isThreadRun) {
            val input = input()
            Controller::class.members.find {
                it.annotations.any { anno -> anno is handler && anno.value == input }
            }?.call(this)
        }
    }
    @handler("종료")
    fun exit(){
        isThreadRun = false
    }
    @handler("등록")
    fun insert(){
        print("명언: ")
        val content: String = sc.nextLine()
        print("작가: ")
        val author: String = sc.nextLine()
        val entity = Service.craete(content, author)
        if (entity != null) {
            println("${entity.id}번 명언이 등록되었습니다.")
        }
    }
    @handler("목록")
    fun list(){
        EntityManager.mutableMap.forEach{
            key,value ->
            println("${value.id} / ${value.author} / ${value.content}")
        }
    }
}

