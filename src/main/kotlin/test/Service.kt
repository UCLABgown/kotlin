package org.example.test

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

    fun gets():MutableMap<Int, Entity>{
        return Repository.gets()
    }
}