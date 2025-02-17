package org.example

object EntityManager {
    val mutableMap:MutableMap<Int,Entity> = mutableMapOf()
    var number = 0
    fun insert(entity: Entity){
        mutableMap[number++] = entity
    }
}