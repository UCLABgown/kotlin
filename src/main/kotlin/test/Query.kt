package test

data class Query(
    var id: Int? = null,
    var keywordType: String? = null,
    var keyword: String? = null,
    var size: Int = 0,
    var page: Int = 1
) {
    fun set(content: String) {
        var result = content.split("=")
        when (result[0]) {
            "id" -> {
                this.id = result[1].toInt()
                size++
            }

            "keywordType" -> {
                this.keywordType = result[1]
                size++
            }

            "keyword" -> {
                this.keyword = result[1]
                size++
            }
            "page" -> {
                this.page = result[1].toInt()
                size++
            }
        }
    }
}