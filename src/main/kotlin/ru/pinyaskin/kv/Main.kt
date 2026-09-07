package ru.pinyaskin.kv

fun main() {
  val queryParser = QueryParser()
  val queryProcessor = QueryProcessor(queryParser)

  while (true) {
    val query = readln()
    try {
      queryProcessor.process(query)
    } catch (e: Exception) {
      println(e.message)
    }
  }
}
