package ru.netology

data class GraffitiAttachment(
    val GraffitiAttachment: GraffitiAttachment
) : Attachment {
    override val type: String = "Graffiti"
}