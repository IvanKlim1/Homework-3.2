package ru.netology

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import java.lang.RuntimeException
import java.lang.invoke.MethodHandles.throwException

class WallServiceTest {

    @Test
    fun update() {
        val service = WallService()
        service.add(Post(1,
            2,
            1,
            1,
            1,
            "as",
            1,
            1,
            2,
            "asd",
            "ads",
            1,
            1,
            1,
            "asd",
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            "asd",
            1,
        "VK",
        1,
            "yes"
        ))
        service.add(Post(1,
            11,
            2,
            3,
            1,
            "asss",
            3,
            2,
            5,
            "asssd",
            "adsss",
            1,
            1,
            1,
            "asssd",
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            "asssd",
            2,
            "VK",
            1,
            "yes"))
        service.add(Post(1,
            121,
            1,
            1,
            1,
            "as",
            1,
            1,
            2,
            "asqqd",
            "adqqqs",
            1,
            1,
            1,
            "asqqqd",
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            "asd",
            1,
            "VK",
            1,
            "yes"))
        val update = Post(1,
            0,
            0,
            0,
            1,
            "aaaas",
            2,
            5,
            5,
            "assssd",
            "adssss",
            12,
            13,
            11,
            "asdss",
            11,
            true,
            true,
            true,
            true,
            true,
            true,
            "asaad",
            14,
            "VK",
            1,
            "yes")

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun NonUpdate() {
        val service = WallService()
        service.add(Post(1,
            121,
            1,
            1,
            1,
            "as",
            1,
            1,
            2,
            "asqqd",
            "adqqqs",
            1,
            1,
            1,
            "asqqqd",
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            "asd",
            1,
            "VK",
            1,
            "yes"

        ))
        val update = Post(11,
            0,
            0,
            0,
            1,
            "aaaas",
            2,
            5,
            5,
            "assssd",
            "adssss",
            12,
            13,
            11,
            "asdss",
            11,
            true,
            true,
            true,
            true,
            true,
            true,
            "asaad",
            14,
            "VK",
            1,
            "yes")

        val result = service.update(update)

        assertFalse(result)
    }

    @Test
    fun addPost() {
        val service = WallService()
        val added = service.add(Post(
            0,
            1,
            1,
            1,
            1,
            "as",
            1,
            1,
            2,
            "asd",
            "ads",
            1,
            1,
            1,
            "asd",
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            "asd",
            1,
            "VK",
            1,
            "yes"
        ))
        val expected = Post(
            1,
            1,
            1,
            1,
            1,
            "as",
            1,
            1,
            2,
            "asd",
            "ads",
            1,
            1,
            1,
            "asd",
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            "asd",
            1,
            "VK",
            1,
            "yes"
        )
        assertEquals(expected, added)
    }
    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service=WallService()
        val added = service.add(Post(
                   0, 1, 1, 1, 1, "as", 1, 1,
                 2, "asd", "ads", 1, 1, 1, "asd",
                  1, true, true, true, true, true,
                  true, "asd", 1, "VK", 1, "yes"
               ))
        val comment=service.createComment(Comment(
                  1,3,1,1,1,"asd",1,1,1,
                  1,1,1
               ))
    }
    @Test
    fun createComment() {
        val result=WallService()
         val added = result.add(Post(
               0, 1, 1, 1, 1, "as", 1, 1,
              2, "asd", "ads", 1, 1, 1, "asd",
             1, true, true, true, true, true,
             true, "asd", 1, "VK", 1, "yes"
          ))
        val comment=result.createComment(Comment(
           1, 1,1,1,1,"asd",1,1,1,
            1,1,1
        ))
    }
}