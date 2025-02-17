package org.example

object EntityManager {
    val mutableMap:MutableMap<Int,Entity> = mutableMapOf()
    var number = 0
    fun insert(content:String,author:String): Entity? {
        val entity = Entity(number,content,author)
        mutableMap[number] = Entity(number,content,author)
        number++
        return entity
    }
    fun delete(id:Int): Int{
        if(mutableMap.contains(id)){
            mutableMap.remove(id)
            return id;
        }
        return -1;
    }
}