package ru.netology

import org.junit.Test

import org.junit.Assert.*

class CommentServiceTest {
    @Test
    fun NoEditComment() {
        val service = CommentService()
        service.add(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val update = (Comment(1, 2, 3, 2, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
        val result = service.edit(update)

        assertFalse(result)

    }

    @Test
    fun YesEditComment() {
        val service = CommentService()
        service.add(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        service.add(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val update = (Comment(1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
        val result = service.edit(update)

        assertTrue(result)

    }

    @Test
    fun TrueGetComment() {
        val comment = CommentService()
        val service = NoteService()
        service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 1, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = comment.add(Comment(1, 1, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
        val result = comment.get(update)
    }

    @Test
    fun deleteCommentNote() {
        val comments = CommentService()
        val service = NoteService()
        val comment = comments.add(Comment(
            ownerId = 232, noteId = 1, postId = 3, id = 1, fromId = 1,
            date = 1, text = "asd", donut = 1, replyToUser = 1, replyToComment = 1, attachments = 1,
            parentsStack = 1, thread = 1,
        ))
        val note = Note(title = "a", text = "b", privacyView = listOf("a", "b"), privacyComment = listOf("a", "b", "c"),
            noteId = 1, ownerId = 2, replyTo = 3, message = "non", guid = "not", commentId = 1,
            noteIds = ArrayList(1), userId = 1, offset = 1, count = 1, sort = 2, need_wiki = true
        )
        service.add(note)
        comments.delete(comment)

    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteCommentFromNonExistentNote_Exception() {
        val comments = CommentService()
        val service = NoteService()
        val comment = Comment(
            ownerId = 232, noteId = 2, postId = 3, id = 1, fromId = 1, date = 1, text = "asd",
            donut = 1, replyToUser = 1, replyToComment = 1, attachments = 1, parentsStack = 1, thread = 1,
        )
        val note = Note(title = "a", text = "b", privacyView = listOf("a", "b"), privacyComment = listOf("a", "b", "c"),
            noteId = 12, ownerId = 2, replyTo = 3, message = "non", guid = "not", commentId = 5,
            noteIds = ArrayList(1), userId = 1, offset = 1, count = 1, sort = 2, need_wiki = true
        )
        service.add(note)
        comments.delete(comment)
    }

    @Test
    fun createCommentNote() {
        val comments = CommentService()
        val service = NoteService()
        val added = service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val comment = comments.createCommentNote(Comment(
            1, 1, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
    }
    @Test(expected = NoteNotFoundException::class)
    fun FalseRestoreComment() {
        val comments = CommentService()
        val service = NoteService()
        service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 12, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        comments.add(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val comment = comments.restoreComment(Comment(1, 2, 3, 2, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
    }

    @Test
    fun TrueRestoreComment() {
        val comments = CommentService()
        val service = NoteService()
        service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 2, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        comments.add(Comment(
            1, 1, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val comment = comments.restoreComment(Comment(1, 1, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))

    }
}