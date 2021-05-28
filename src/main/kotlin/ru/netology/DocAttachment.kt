package ru.netology

data class DocAttachment(
    val DocAttachment: DocAttachment
) : Attachment {
    override val type: String = "Doc"
}