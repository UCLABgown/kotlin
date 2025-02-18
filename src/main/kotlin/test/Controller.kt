package org.example.test

import test.Query
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
            val query = util.split(input)
            Controller::class.members.find {
                it.annotations.any { anno -> anno is handler && input.contains( anno.value) }
            }?.let{ m ->
                if(m.parameters.size == 1)
                    m.call(this)
                if(m.parameters.size == 2) {
                    m.call(this,query)
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
    fun list(query: Query){
        Service.gets()
            .filter { (key,value) ->
                value.author.contains(query.keyword.toString()) || !query.keywordType.equals("author")
            }
            .filter { (key,value) ->
                value.content.contains(query.keyword.toString()) || !query.keywordType.equals("content")
            }
            .forEach{
            key,value ->
            println("${value.id} / ${value.author} / ${value.content}")
        }
    }
    @handler("삭제")
    fun delete(query: Query){
        val id_ = query.id?.let { Service.delete(it) }
        if(id_ == -1)
            println("${query.id}번 명언은 존재하지 않습니다.")
        else
            println("${query.id}번 명언 삭제")
    }
    @handler("수정")
    fun modify(query: Query){
        val entity = query.id?.let { Service.get(it) }
        if (entity == null)
            println("${query.id}번 명언은 존재하지 않습니다.")
        else{
            print("명언(기존) : ${entity.content}")
            print("명언: ")
            val content: String = sc.nextLine()
            print("작가(기존) : ${entity.author}")
            print("작가: ")
            val author: String = sc.nextLine()
            Service.modify(query.id!!, content, author)
        }
    }
    @handler("빌드")
    fun build(){
        Service.build()
        println("data.json 파일의 내용이 갱신되었습니다.")
    }

}

