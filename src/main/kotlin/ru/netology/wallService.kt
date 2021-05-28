package ru.netology

class WallService {
    var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        var post = post.copy(id = if (posts.isEmpty()) 1 else posts.last().id + 1)
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[index] = post.copy(ownerId = currentPost.ownerId, date = currentPost.date)
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment) {
        if (posts.none { it.id == comment.postId }) {
            throw PostNotFoundException("no post with id")
        }
        comments + comment.copy(id = comments.lastOrNull()?.id ?: 0)
    }
}
