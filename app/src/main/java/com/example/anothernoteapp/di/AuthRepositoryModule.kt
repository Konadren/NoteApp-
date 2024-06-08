package com.example.anothernoteapp.di

import com.example.anothernoteapp.feature_note.data.repository.AuthRepositoryImpl
import com.example.anothernoteapp.feature_note.domain.repository.AuthRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AuthRepositoryModule {
    @Provides
    @Singleton
    fun provideAuthRepository(db: FirebaseFirestore): AuthRepository {
        return AuthRepositoryImpl(db)
    }
}