package ru.netology

import java.lang.RuntimeException

class PostNotFoundException(message:String): RuntimeException(message)
class NoteNotFoundException(message:String): RuntimeException(message)
fun main() {

}

