package org.example.test

import java.io.File

class util {
    companion object {
        val url: String = "./data.txt"
        fun split(content: String): Int {
            val result = content.split("?")
            if (result.size < 2) return 0
            return result[1].split("=")[1].toInt()

        }

        fun save(content: String) {
            File(url).printWriter().use { it.println(content) }
        }

    }
}