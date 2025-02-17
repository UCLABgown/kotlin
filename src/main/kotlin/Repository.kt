package org.example

object Repository {
    fun create(content:String,author:String): Entity? {
        return EntityManager.insert(content,author)
    }
    fun delete(id:Int):Int{
        return EntityManager.delete(id)
    }
}