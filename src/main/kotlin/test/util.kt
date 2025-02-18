package org.example.test

import test.Query
import java.io.File

class util {
    companion object {
        val url: String = "./data.txt"
        fun split(content: String): Query {
            var query = Query()
            var result = content.split("?")
            if (result.size < 2) return query
            result = result[1].split("&")
            result.forEach{e -> query.set(e)}
            return query

        }

        fun save(content: String) {
            File(url).printWriter().use { it.println(content) }
        }

    }
}