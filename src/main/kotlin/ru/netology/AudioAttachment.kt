package ru.netology

import java.util.*

data class  AudioAttachment(
    val AudioAttachment: AudioAttachment,
) : Attachment {
    override val type: String = "Audio"
}