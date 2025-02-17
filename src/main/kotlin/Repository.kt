package org.example

object Repository {
    fun create(content:String,author:String) {
        EntityManager.insert(Entity(content,author))
    }
}