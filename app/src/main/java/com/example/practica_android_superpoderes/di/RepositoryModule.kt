package com.example.practica_android_superpoderes.di

import com.example.practica_android_superpoderes.data.Repository
import com.example.practica_android_superpoderes.data.RepositoryImpl
import com.example.practica_android_superpoderes.data.local.LocalDataSource
import com.example.practica_android_superpoderes.data.local.LocalDataSourceImpl
import com.example.practica_android_superpoderes.data.remote.RemoteDataSource
import com.example.practica_android_superpoderes.data.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindsLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource

}

