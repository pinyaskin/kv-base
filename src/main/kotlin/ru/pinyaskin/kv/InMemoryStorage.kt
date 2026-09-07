package ru.pinyaskin.kv

class InMemoryStorage : Storage {
  private val impl = hashMapOf<String, String>()

  override fun processQuery(query: Query): List<Field> {
    return when (query) {
      is Query.Select -> select(query)
      else -> listOf()
    }
  }

  private fun select(query: Query.Select): List<Field> {
    impl[query.query]
  }
}
