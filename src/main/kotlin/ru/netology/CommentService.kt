package ru.netology

class CommentService(
    private val noteService: CrudService<Note>
) : CrudService<Comment> {
    private var comments = emptyArray<Comment>()
    override fun getAll() = comments
    fun get(comment: Comment): Boolean {
        val notes = noteService.getAll()
        for ((index) in comments.withIndex()) {
            if (notes[index].noteId == comments[index].noteId
                && notes[index].ownerId == comments[index].ownerId
            )
                comment
            return true
        }
        return false
    }

    override fun add(comment: Comment): Comment {
        comments += comment.copy(id = if (comments.isEmpty()) 1 else comments.last().id + 1)
        return comments.last()
    }


    override fun edit(comment: Comment): Boolean {
        for ((index, currentComment) in comments.withIndex()) {
            if (comment.id == currentComment.id) {
                comments[index] = comment.copy(id = currentComment.id)
                return true
            }
        }
        return false
    }
    override fun delete(comment: Comment): List<Comment> {
        if (comment !in comments) {
            // Бросаем исключение, если обошли весь список и ничего не нашли,
            throw NoteNotFoundException("error")
        }
        return comments.filterNot { it.id == comment.id }.also {
            comments = it.toTypedArray()
        }
    }

    fun restoreComment(comment: Comment): List<Comment> {
        val notes = noteService.getAll()
        for ((index, restoreComment) in comments.withIndex()) {
            if (notes[index].noteId == restoreComment.noteId && comment.id == restoreComment.id) {
                comments += restoreComment
                return comments.toList()
            }
        }
        throw NoteNotFoundException("error")
    }

    fun createCommentNote(comment: Comment) {
        val notes = noteService.getAll()
        if (notes.none { it.noteId == comment.noteId }) {
            throw NoteNotFoundException("no note with id")
        }
        comments + comment.copy(id = comments.lastOrNull()?.id ?: 0)
    }

    override fun getById(id: Int): Comment =
        comments.first { it.id == id }

}