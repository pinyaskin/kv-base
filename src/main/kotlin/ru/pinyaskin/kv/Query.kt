package ru.pinyaskin.kv

sealed interface Query {
  sealed interface Operation : Query

  data class Select(val fields: List<String>, val query: Query) : Operation

  data class From(val source: String) : Query

  data object End : Query
}
