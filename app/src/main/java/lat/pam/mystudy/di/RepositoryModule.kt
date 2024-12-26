package lat.pam.mystudy.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lat.pam.mystudy.data.repository.SessionRepositoryImpl
import lat.pam.mystudy.data.repository.SubjectRepositoryImpl
import lat.pam.mystudy.data.repository.TaskRepositoryImpl
import lat.pam.mystudy.domain.repository.SessionRepository
import lat.pam.mystudy.domain.repository.SubjectRepository
import lat.pam.mystudy.domain.repository.TaskRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindSubjectRepository(
        impl: SubjectRepositoryImpl
    ): SubjectRepository

    @Singleton
    @Binds
    abstract fun bindTaskRepository(
        impl: TaskRepositoryImpl
    ): TaskRepository

    @Singleton
    @Binds
    abstract fun bindSessionRepository(
        impl: SessionRepositoryImpl
    ): SessionRepository
}