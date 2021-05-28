package ru.netology

data class PostedPhotoAttachment(
    val PostedPhoto: PostedPhoto
) : Attachment {
    override val type: String = "Posted Photo"
}