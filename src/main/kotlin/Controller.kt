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
            val id = util.split(input)
            Controller::class.members.find {
                it.annotations.any { anno -> anno is handler && input.contains( anno.value) }
            }?.let{ m ->
                if(m.parameters.size == 1)
                    m.call(this)
                if(m.parameters.size == 2) {
                    m.call(this, id)
                }

            }
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
    @handler("삭제")
    fun delete(id:Int){
        val id = Service.delete(id)
        println("${id}번 명언 삭제")
    }
}

