package ru.netology

interface CrudService<E> {
    fun add(entity: E): E
    fun delete(entity: E): List<E>
    fun edit(entity: E): Boolean
    fun getById(id: Int): E
}
