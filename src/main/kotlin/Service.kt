package org.example

object Service {

    fun craete(content:String,author:String):Entity?{
        return Repository.create(content,author)
    }
}