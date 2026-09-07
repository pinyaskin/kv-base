package ru.pinyaskin.kv

class QueryProcessor(
  private val queryParser: QueryParser,
  private val storage: Storage,
) {

  fun process(query: String) {
    val query = queryParser.parse(query)
    println(storage.processQuery(query))
  }
}
