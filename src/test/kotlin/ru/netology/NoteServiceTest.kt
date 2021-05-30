package ru.netology

import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun addNote() {
        val service = NoteService()
        val added = service.addNote(Note(
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

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrow() {
        val service = NoteService()
        val added = service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val comment = service.createCommentNote(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
    }

    @Test
    fun createCommentNote() {
        val service = NoteService()
        val added = service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val comment = service.createCommentNote(Comment(
            1, 1, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
    }

    @Test
    fun TruedeleteNote() {
        val service = NoteService()
        val added = service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val delete = service.deleteNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))

    }

    @Test
    fun FalseDeleteNote() {
        val service = NoteService()
        val added = service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val delete = service.deleteNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 2, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))

    }

    @Test
    fun deleteCommentNote() {
        val service = NoteService()
        val comment = service.addComment(Comment(
            ownerId = 232, noteId = 1, postId = 3, id = 1, fromId = 1,
            date = 1, text = "asd", donut = 1, replyToUser = 1, replyToComment = 1, attachments = 1,
            parentsStack = 1, thread = 1,
        ))
        val note = Note(title = "a", text = "b", privacyView = listOf("a", "b"), privacyComment = listOf("a", "b", "c"),
            noteId = 2, ownerId = 2, replyTo = 3, message = "non", guid = "not", commentId = 5,
            noteIds = ArrayList(1), userId = 1, offset = 1, count = 1, sort = 2, need_wiki = true
        )
        service.addNote(note)
        service.deleteCommentNote(comment)

    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteCommentFromNonExistentNote_Exception() {
        val service = NoteService()
        val comment = Comment(
            ownerId = 232, noteId = 2, postId = 3, id = 1, fromId = 1, date = 1, text = "asd",
            donut = 1, replyToUser = 1, replyToComment = 1, attachments = 1, parentsStack = 1, thread = 1,
        )
        val note = Note(title = "a",
            text = "b",
            privacyView = listOf("a", "b"),
            privacyComment = listOf("a", "b", "c"),
            noteId = 12,
            ownerId = 2,
            replyTo = 3,
            message = "non",
            guid = "not",
            commentId = 5,
            noteIds = ArrayList(1),
            userId = 1,
            offset = 1,
            count = 1,
            sort = 2,
            need_wiki = true
        )
        service.addNote(note)
        service.deleteCommentNote(comment)
    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteThrowNote() {
        val service = NoteService()
        val added = service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val comment = service.createCommentNote(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))

    }

    @Test
    fun TrueEditNote() {
        val service = NoteService()
        service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = (Note("a", "b", listOf("a", "b"), listOf("a", "b", "c"), 2, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true))
        val result = service.editNote(update)

        assertTrue(result)

    }

    @Test
    fun FalseEditNote() {
        val service = NoteService()
        service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = (Note("a", "b", listOf("a", "b"), listOf("a", "b", "c"), 2, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true))
        val result = service.editNote(update)
        assertFalse(result)
    }

    @Test
    fun NoEditComment() {
        val service = NoteService()
        service.addComment(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val update = (Comment(1, 2, 3, 2, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
        val result = service.editComment(update)

        assertFalse(result)

    }

    @Test
    fun YesEditComment() {
        val service = NoteService()
        service.addComment(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        service.addComment(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val update = (Comment(1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
        val result = service.editComment(update)

        assertTrue(result)

    }

    @Test
    fun getNote() {
        val service = NoteService()
        service.addNote(Note(
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
        service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 1, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = (Note("a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1,
            1, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true))
        val result = service.getById(update)
    }

    @Test
    fun TrueGetComment() {
        val service = NoteService()
        service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 1, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = service.addComment(Comment(1, 1, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
        val result = service.getComment(update)
    }

    @Test(expected = NoteNotFoundException::class)
    fun FalseRestoreComment() {
        val service = NoteService()
        service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        service.addComment(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val comment = service.restoreComment(Comment(1, 2, 3, 2, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
    }

    @Test
    fun TrueRestoreComment() {
        val service = NoteService()
        service.addNote(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        service.addComment(Comment(
            1, 1, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val comment = service.restoreComment(Comment(1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))

    }
}