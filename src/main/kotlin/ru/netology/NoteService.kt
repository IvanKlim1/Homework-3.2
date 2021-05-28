package ru.netology

import java.lang.RuntimeException

class NoteService {
    var notes = emptyArray<Note>()
    private var comments = emptyArray<Comment>()
    fun addNote(note: Note): Note {
        var note = note.copy(noteId = if (notes.isEmpty()) 1 else notes.last().noteId + 1)
        notes += note
        return notes.last()
    }

    fun createCommentNote(comment: Comment) {
        if (notes.none { it.noteId == comment.noteId }) {
            throw NoteNotFoundException("no note with id")
        }
        comments + comment.copy(id = comments.lastOrNull()?.id ?: 0)
    }

    fun deleteNote(note: Note): List<Note> {
        for ((index, deleteNote) in notes.withIndex()) {

            if (notes[index].noteId == deleteNote.noteId) {
                notes -= note

            }
        }
        return notes.toList()
    }

    fun deleteCommentNote(comment: Comment): List<Comment> {
        for ((index, deleteComment) in notes.withIndex()) {

            if (notes[index].ownerId == deleteComment.ownerId) {
                comments -= comment
            } else {
                throw NoteNotFoundException("error")
            }
        }
        return comments.toList()
    }

    fun editNote(note: Note): Boolean {
        for ((index, currentNote) in notes.withIndex()) {
            if (note.noteId == currentNote.noteId) {
                notes[index] = note.copy(ownerId = currentNote.ownerId)
                return true
            }
        }
        return false
    }

    fun editComment(comment: Comment): Boolean {
        for ((index, currentComment) in comments.withIndex()) {
            if (comment.id == currentComment.id) {
                comments[index] = comment.copy(id = currentComment.id)
                return true
            }
        }
        return false
    }

    fun restoreComment(comment: Comment) {
        val deleteComment = deleteCommentNote(comment)
        if (deleteComment.indexOf(comment) == comment.id) {
            comments += deleteComment
        } else {
            throw NoteNotFoundException("error")
        }

    }

}

private operator fun <T> Array<T>.minusAssign(note: T) {

}



