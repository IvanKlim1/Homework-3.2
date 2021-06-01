package ru.netology

data class Note(
    val title:String,
    val text:String,
    val privacyView:List<String>,
    val privacyComment:List<String>,
    val noteId:Int,
    val ownerId:Int,
    val replyTo:Int,
    val message:String,
    val guid:String,
    val commentId:Int,
    val noteIds:ArrayList<Int>,
    val userId:Int,
    val offset:Int,
    val count:Int,
    val sort:Int,
    val needWiki:Boolean
)