package com.example.anothernoteapp.di

import com.example.anothernoteapp.feature_note.domain.repository.AuthRepository
import com.example.anothernoteapp.feature_note.domain.repository.NoteRepository
import com.example.anothernoteapp.feature_note.domain.use_case.auth_use_cases.AuthUseCases
import com.example.anothernoteapp.feature_note.domain.use_case.auth_use_cases.CreateUser
import com.example.anothernoteapp.feature_note.domain.use_case.auth_use_cases.LoginUser
import com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases.AddNoteFirestore
import com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases.DeleteNoteFirestore
import com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases.FirestoreUseCases
import com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases.GetNoteFirestore
import com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases.GetUserNotes
import com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases.SignOutFirestore
import com.example.anothernoteapp.feature_note.domain.use_case.firestore_use_cases.UpdateNoteFirestore
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object FirebaseModule {
    @Provides
    @Singleton
    fun provideFirestoreInstance(): FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

//    @Provides
//    @Singleton
//    fun provideAuthRepository(auth: FirebaseFirestore): AuthRepository1{
//        return AuthRepositoryImpl(auth)
//    }

    @Provides
    @Singleton
    fun provideAuthUseCases(repository: AuthRepository): AuthUseCases {
        return AuthUseCases(
            createUser = CreateUser(repository),
            loginUser = LoginUser(repository)
        )
    }

    @Provides
    @Singleton
    fun provideNoteFirestoreUseCases(repository: NoteRepository): FirestoreUseCases {
        return FirestoreUseCases(
            addNoteFirestore = AddNoteFirestore(repository),
            deleteNoteFirestore = DeleteNoteFirestore(repository),
            getNoteFirestore = GetNoteFirestore(repository),
            getUserNotes = GetUserNotes(repository),
            signOutFirestore = SignOutFirestore(repository),
            updateNoteFirestore = UpdateNoteFirestore(repository)
        )
    }
}