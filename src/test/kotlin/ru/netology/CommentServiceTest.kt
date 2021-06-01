package ru.netology

import org.junit.Test

import org.junit.Assert.*

class CommentServiceTest {
    @Test
    fun NoEditComment() {
        val service = NoteService()
        val comment = CommentService(service)
        comment.add(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val update = (Comment(1, 2, 3, 2, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
        val result = comment.edit(update)

        assertFalse(result)

    }

    @Test
    fun YesEditComment() {
        val service = NoteService()
        val comment = CommentService(service)
        comment.add(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1,
            1, 1, 1, 1, 1
        ))
        comment.add(Comment(
            1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1
        ))
        val update = (Comment(1, 2, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
        val result = comment.edit(update)
        assertTrue(result)

    }

    @Test
    fun TrueGetComment() {
        val service = NoteService()
        val comment = CommentService(service)
        service.add(Note(
            "a", "b", listOf("a", "b"), listOf("a", "b", "c"), 1, 1, 3, "non",
            "not", 5, ArrayList(1), 1, 1,
            1, 2, true
        ))
        val update = comment.add(Comment(1, 1, 3, 1, 1, 1, "asd", 1, 1, 1,
            1, 1, 1))
        val result = comment.getById(id=1)
    }

    @Test
    fun deleteCommentNote() {
        val service = NoteService()
        val comments = CommentService(service)
        val comment = comments.add(Comment(
            ownerId = 232, noteId = 1, postId = 3, id = 1, fromId = 1,
            date = 1, text = "asd", donut = 1, replyToUser = 1, replyToComment = 1, attachments = 1,
            parentsStack = 1, thread = 1,
        ))
        val note = Note(title = "a", text = "b", privacyView = listOf("a", "b"), privacyComment = listOf("a", "b", "c"),
            noteId = 1, ownerId = 2, replyTo = 3, message = "non", guid = "not", commentId = 1,
            noteIds = ArrayList(1), userId = 1, offset = 1, count = 1, sort = 2, needWiki = true
        )
        service.add(note)
        comments.delete(comment)

    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteCommentFromNonExistentNote_Exception() {
        val service = NoteService()
        val comments = CommentService(service)
        val comment = Comment(
            ownerId = 232, noteId = 2, postId = 3, id = 1, fromId = 1, date = 1, text = "asd",
            donut = 1, replyToUser = 1, replyToComment = 1, attachments = 1, parentsStack = 1, thread = 1,
        )
        val note = Note(title = "a", text = "b", privacyView = listOf("a", "b"), privacyComment = listOf("a", "b", "c"),
            noteId = 12, ownerId = 2, replyTo = 3, message = "non", guid = "not", commentId = 5,
            noteIds = ArrayList(1), userId = 1, offset = 1, count = 1, sort = 2, needWiki = true
        )
        service.add(note)
        comments.delete(comment)
    }
    @Test(expected = NoteNotFoundException::class)
    fun CommentThrow() {
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
    fun createCommentNote() {
        val service = NoteService()
        val comments = CommentService(service)
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
        val service = NoteService()
        val comments = CommentService(service)
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
        val service = NoteService()
        val comments = CommentService(service)
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