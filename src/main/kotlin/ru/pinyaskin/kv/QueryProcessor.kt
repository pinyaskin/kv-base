package ru.pinyaskin.kv

class QueryProcessor(
  private val queryParser: QueryParser,
) {

  fun process(query: String): Unit {
    println(queryParser.parse(query))
  }
}
