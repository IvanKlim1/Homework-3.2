package ru.netology

import java.util.*

data class Comment(
    val noteId:Int,
    val postId:Int,
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Int,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Int,
    val parentsStack: Int,
    val thread: Int,
)