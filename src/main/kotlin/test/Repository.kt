package org.example.test

object Repository {
    fun create(content:String,author:String): Entity {
        return EntityManager.insert(content, author)
    }
    fun delete(id:Int):Int{
        return EntityManager.delete(id)
    }
    fun modify(id:Int,content: String,author: String): Entity {
        return EntityManager.modify(id, content, author)
    }
    fun get(id:Int): Entity?{
        return EntityManager.mutableMap[id]
    }

    fun gets():MutableMap<Int, Entity>{
        return EntityManager.mutableMap
    }
}