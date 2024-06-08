package com.example.anothernoteapp.feature_note.data.repository

import com.example.anothernoteapp.feature_note.domain.repository.AuthRepository
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class AuthRepositoryImpl(
    private val db: FirebaseFirestore
): AuthRepository {

    override suspend fun createUser(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ) = withContext(Dispatchers.IO){
        Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    onComplete.invoke(true)
                } else {
                    onComplete.invoke(false)
                }
            }.await()

    }

    override suspend fun loginUser(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ) = withContext(Dispatchers.IO) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    onComplete.invoke(true)
                } else {
                    onComplete.invoke(false)
                }
            }.await()

    }

    override fun hasUser(): Boolean = Firebase.auth.currentUser != null
}