package org.example.test

class util {
    companion object {
        fun split(content:String):Int{
            val result = content.split("?")
            if(result.size <2) return 0
            return result[1].split("=")[1].toInt()

        }
    }
}