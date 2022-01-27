package net.neonlotus.kotlinaquarium.book

//4-8 quiz
open class Book(val title: String, val author: String) {
    var currentPage = 1

    open fun readPage() {
        currentPage++
    }
}

class eBook(title: String, author: String, var format: String = "text") : Book(title, author) {
    private var wordCount = 0

    override fun readPage() {
        wordCount += 250
    }
}
//got it right but answer had extra parameters, I'll add them anyway