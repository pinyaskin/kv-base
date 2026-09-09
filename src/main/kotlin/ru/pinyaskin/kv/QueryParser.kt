package ru.pinyaskin.kv

class QueryParser {
  class ExpressionIsNotFullyDefined : RuntimeException("Expression is not fully defined")

  fun parse(query: String): Query {
    return parse(query.split(" "))
  }

  private fun parse(words: List<String>): Query {
    if (words.isEmpty()) return Query.End

    return when (words.first()) {
      "select" -> parseSelect(words.drop(1))
      else -> Query.End
    }
  }

  private fun parseSelect(words: List<String>): Query.Select {
    val fields = mutableListOf<String>()
    var subCount = 0

    for (word in words) {
      val norm = word.lowercase()
      subCount++

      when (norm) {
        "from" -> return Query.Select(fields, parseFrom(words.drop(subCount)))
        else -> fields.add(norm)
      }
    }

    throw ExpressionIsNotFullyDefined()
  }

  private fun parseFrom(words: List<String>): Query.From {
    return Query.From(words.first())
  }
}
