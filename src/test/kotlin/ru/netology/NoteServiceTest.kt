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
            1,2,3,1,1,1,"asd",1,1,1,
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
            1,1,3,1,1,1,"asd",1,1,1,
            1,1,1
        ))
    }

    @Test
    fun TruedeleteNote() {
        val service=NoteService()
        val added=service.addNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,12,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        val delete=service.deleteNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,1,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))

    }
    @Test
    fun FalseDeleteNote() {
        val service=NoteService()
        val added=service.addNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,12,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        val delete=service.deleteNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,2,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))

    }

    @Test
    fun deleteCommentNote() {
        val service=NoteService()
        val added=service.addNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,1,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        val comment=service.deleteCommentNote(Comment(
            1,1,3,1,1,1,"asd",1,1,1,
            1,1,1
        ))
    }
    @Test(expected = NoteNotFoundException::class)
    fun deleteThrowNote() {
        val service=NoteService()
        val added=service.addNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,1,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        val comment=service.createCommentNote(Comment(
            1,2,3,1,1,1,"asd",1,1,1,
            1,1,1
        ))

    }

    @Test
    fun TrueEditNote() {
        val service=NoteService()
        service.addNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,12,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        service.addNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,12,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        val update =(Note("a","b", listOf("a","b"), listOf("a","b","c") ,2,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true))
        val result = service.editNote(update)

        assertTrue(result)

    }
    @Test
    fun FalseEditNote() {
        val service=NoteService()
        service.addNote(Note(
            "a","b", listOf("a","b"), listOf("a","b","c") ,12,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true
        ))
        val update =(Note("a","b", listOf("a","b"), listOf("a","b","c") ,2,2,3,"non",
            "not",5, ArrayList(1,),1,1,
            1,2,true))
        val result = service.editNote(update)
        assertFalse(result)
    }

    @Test
    fun NoEditComment() {
        val service=NoteService()
        service.addComment(Comment(
            1,2,3,1,1,1,"asd",1,1,1,
            1,1,1
        ))
        val update =(Comment(1,2,3,2,1,1,"asd",1,1,1,
            1,1,1))
        val result = service.editComment(update)

        assertFalse(result)

    }
    @Test
    fun YesEditComment() {
        val service=NoteService()
        service.addComment(Comment(
            1,2,3,1,1,1,"asd",1,1,1,
            1,1,1
        ))
        service.addComment(Comment(
            1,2,3,1,1,1,"asd",1,1,1,
            1,1,1
        ))
        val update =(Comment(1,2,3,1,1,1,"asd",1,1,1,
            1,1,1))
        val result = service.editComment(update)

        assertTrue(result)

    }
    @Test(expected = NoteNotFoundException::class)
    fun FalseRestoreComment() {
        val service=NoteService()
        val comment=service.restoreComment(Comment(1,2,3,1,1,1,"asd",1,1,1,
            1,1,1))
    }
    @Test
    fun TrueRestoreComment() {

    }
}