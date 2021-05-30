package ru.netology

class NoteService {
    var notes = emptyArray<Note>()
    private var comments = emptyArray<Comment>()
    fun addComment(comment: Comment): Comment {
        comments += comment.copy(id = if (comments.isEmpty()) 1 else comments.last().id + 1)
        return comments.last()
    }

    fun addNote(note: Note): Note {
        notes += note.copy(noteId = if (notes.isEmpty()) 1 else notes.last().noteId + 1)
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
                notes = notes.filterNot { it == note }
                    .toTypedArray()
            }
        }
        return notes.toList()
    }

    fun deleteCommentNote(comment: Comment): List<Comment> {
        for ((index, deleteComment) in comments.withIndex()) {
            if (notes[index].noteId == deleteComment.noteId) {
                comments = comments.filterNot { it.id == comment.id }
                    .toTypedArray()
                return comments.toList()
            }
        }
        // Бросаем исключение, если обошли весь список и ничего не нашли,
        throw NoteNotFoundException("error")
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

    fun get(note: Note) {
        notes
    }

    fun getById(note: Note): Boolean {
        for ((index) in notes.withIndex()) {
            if (notes[index].noteId == note.noteId && notes[index].ownerId == note.ownerId) {
                note
            }
            return true
        }
        return false
    }

    fun getComment(comment: Comment): Boolean {
        for ((index) in comments.withIndex()) {
            if (notes[index].noteId == comments[index].noteId
                && notes[index].ownerId == comments[index].ownerId
            ) {
                comment
            }
            return true
        }
        return false
    }

    fun restoreComment(comment: Comment): List<Comment> {
        for ((index, restoreComment) in comments.withIndex()) {
            if (notes[index].noteId == restoreComment.noteId && comment.id == restoreComment.id) {
                comments += restoreComment
                return comments.toList()
            }
        }
        throw NoteNotFoundException("error")
    }
}




