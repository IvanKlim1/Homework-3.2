package ru.netology

import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun addNote() {
        val service=NoteService()
        val added=service.addNote(Note(
          "a","b", listOf("a","b"), listOf("a","b","c") ,1,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        val expected = Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,1,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        )
        assertEquals(expected, added)

    }
    @Test(expected = NoteNotFoundException::class)
    fun shouldThrow() {
        val service=NoteService()
        val added=service.addNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,1,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        val comment=service.createCommentNote(Comment(
            2,3,1,1,1,"asd",1,1,1,
            1,1,1
        ))
    }

    @Test
    fun createCommentNote() {
        val service=NoteService()
        val added=service.addNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,1,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        val comment=service.createCommentNote(Comment(
            1,3,1,1,1,"asd",1,1,1,
            1,1,1
        ))
    }

    @Test
    fun deleteNote() {
    }

    @Test
    fun deleteCommentNote() {
    }

    @Test
    fun editNote() {
    }

    @Test
    fun editComment() {
    }

    @Test
    fun restoreComment() {
    }
}