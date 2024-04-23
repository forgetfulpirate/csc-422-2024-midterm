@file:OptIn(InternalAPI::class)

package com.nbscvincent.csc4222024midterm.data.repository.user

import com.nbscvincent.csc4222024midterm.data.model.user.User
import com.nbscvincent.csc4222024midterm.data.model.user.UserProfile
import com.nbscvincent.csc4222024midterm.network.HttpRoutes
import com.nbscvincent.csc4222024midterm.network.KtorClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.util.InternalAPI


@OptIn(InternalAPI::class)
class OnlineUserRepository (private val ktorClient: HttpClient = KtorClient())

val ktorClient: HttpClient = KtorClient()
     suspend fun  getUsers(): List<User> {
        val response: UserProfile = ktorClient.request(HttpRoutes.USERS){
            method = HttpMethod.Get
            url(HttpRoutes.USERS)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }.body()
        return response.users
    }

//override suspend fun getUsers(): List<User> {
//    val response: UserResponse = ktorClient.request(HttpRoutes.USERS) {
//        method = HttpMethod.Get
//        url(HttpRoutes.USERS)
//        contentType(ContentType.Application.Json)
//        accept(ContentType.Application.Json)
//    }.body()
//    return response.users
//}
//
 suspend fun getUserById(id: Int): User {
    val response: User = ktorClient.request("${HttpRoutes.USERS}/$id") {
        method = HttpMethod.Get
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
    }.body()
    return response
//}
//
 suspend fun addUser(user: User): User {
    val response: User = ktorClient.request(HttpRoutes.USERS) {
        method = HttpMethod.Post
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
        body = user
    }.body()
    return response
}
//
 suspend fun updateUser(user: User): User {
    val response: User = ktorClient.request("${HttpRoutes.USERS}/${user.id}") {
        method = HttpMethod.Put
        contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
        body = user
    }.body()
    return response
}
 suspend fun getUserByUsernameAndPassword(username: String, password: String): User? {
    val response: HttpResponse = KtorClient().request(HttpRoutes.USERS)
    val userResponse: UserProfile = response.body<UserProfile>()

    return userResponse.users.find { it.username == username && it.password == password }
}
    }