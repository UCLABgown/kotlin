package org.example.test

data class Entity(var id: Int, var content: String, var author: String){
    override fun toString():String{
        return "${id} ${author} ${content}\n"
    }
}