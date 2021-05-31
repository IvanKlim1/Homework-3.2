package ru.netology

import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun addNote() {
        val service = NoteService()
        val added = service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val expected = Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        )
        assertEquals(expected, added)

    }


    @Test
    fun TruedeleteNote() {
        val service = NoteService()
        val added = service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val delete = service.delete(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))

    }

    @Test
    fun FalseDeleteNote() {
        val service = NoteService()
        val added = service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val delete = service.delete(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 2, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))

    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteThrowNote() {
        val service = NoteService()
        val comments = CommentService(service)
        val added = service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val comment = comments.createCommentNote(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))

    }

    @Test
    fun TrueEditNote() {
        val service = NoteService()
        service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = (Note("a", "b", listOf("a", "b"), listOf("a", "b", "c"), 2, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true))
        val result = service.edit(update)

        assertTrue(result)

    }

    @Test
    fun FalseEditNote() {
        val service = NoteService()
        service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = (Note("a", "b", listOf("a", "b"), listOf("a", "b", "c"), 2, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true))
        val result = service.edit(update)
        assertFalse(result)
    }

    @Test
    fun getNote() {
        val service = NoteService()
        service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 1, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = (Note("a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1,
            1, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true))
        val result = service.get(update)
    }

    @Test
    fun TrueGetById() {
        val service = NoteService()
        service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 1, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = (Note("a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1,
            1, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true))
        val result = service.getById(id =1)
    }
}