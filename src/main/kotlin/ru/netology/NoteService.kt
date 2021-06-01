package ru.netology

class NoteService : CrudService<Note> {
    var notes = emptyArray<Note>()
    private var comments = emptyArray<Comment>()
    fun getAll() = notes

    override fun add(note: Note): Note {
        notes += note.copy(noteId = if (notes.isEmpty()) 1 else notes.last().noteId + 1)
        return notes.last()
    }

    override fun delete(note: Note): List<Note> {
        for ((index, deleteNote) in notes.withIndex()) {
            if (notes[index].noteId == deleteNote.noteId) {
                notes = notes.filterNot { it == note }
                    .toTypedArray()
            }
        }
        return notes.toList()
    }

    override fun edit(note: Note): Boolean {
        for ((index, currentNote) in notes.withIndex()) {
            if (note.noteId == currentNote.noteId) {
                notes[index] = note.copy(ownerId = currentNote.ownerId)
                return true
            }
        }
        return false
    }

    fun get(note: Note) {
        notes
    }

    override fun getById(id: Int): Note =
        notes.first { it.noteId == id }
}




