package org.example

object Service {

    fun craete(content:String,author:String){
        Repository.create(content,author)
    }
}