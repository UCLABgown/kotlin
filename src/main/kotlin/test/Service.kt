package org.example.test

import test.Query
import kotlin.math.min

object Service {

    fun craete(content:String,author:String): Entity?{
        return Repository.create(content, author)
    }
    fun delete(id:Int):Int{
        return Repository.delete(id)
    }
    fun modify(id:Int,content: String,author: String): Entity {
        return Repository.modify(id, content, author)
    }
    fun get(id:Int): Entity?{
        return Repository.get(id)
    }

    fun gets(query:Query): List<Entity> {
        val list = Repository.gets()
            .filter { (key,value) ->
                value.author.contains(query.keyword.toString()) || !query.keywordType.equals("author")
            }
            .filter { (key, value) ->
                value.content.contains(query.keyword.toString()) || !query.keywordType.equals("content")
            }
            .map{ (key,value)->
                value
            }
        return list
                .subList((query.page-1)*3,min(query.page*3,list.size))
    }
    fun build(){
        Repository.build()
    }
}