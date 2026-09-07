package ru.pinyaskin.kv

interface Storage {
  fun processQuery(query: Query): List<Field>
}
