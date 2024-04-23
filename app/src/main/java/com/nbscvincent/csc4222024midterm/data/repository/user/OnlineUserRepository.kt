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
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

class OnlineUserRepository (private val ktorClient: HttpClient = KtorClient() )

    suspend fun  getUsers(): List<User> {
        val response: UserProfile = KtorClient().request(HttpRoutes.USERS){
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
//override suspend fun getUserById(id: Int): User {
//    val response: User = ktorClient.request("${HttpRoutes.USERS}/$id") {
//        method = HttpMethod.Get
//        contentType(ContentType.Application.Json)
//        accept(ContentType.Application.Json)
//    }.body()
//    return response
//}
//
//override suspend fun addUser(user: User): User {
//    val response: User = ktorClient.request(HttpRoutes.USERS) {
//        method = HttpMethod.Post
//        contentType(ContentType.Application.Json)
//        accept(ContentType.Application.Json)
//        body = user
//    }.body()
//    return response
//}
//
//override suspend fun updateUser(user: User): User {
//    val response: User = ktorClient.request("${HttpRoutes.USERS}/${user.id}") {
//        method = HttpMethod.Put
//        contentType(ContentType.Application.Json)
//        accept(ContentType.Application.Json)
//        body = user
//    }.body()
//    return response
//}