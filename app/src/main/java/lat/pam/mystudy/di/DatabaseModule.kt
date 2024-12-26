package lat.pam.mystudy.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lat.pam.mystudy.data.local.AppDatabase
import lat.pam.mystudy.data.local.SessionDao
import lat.pam.mystudy.data.local.SubjectDao
import lat.pam.mystudy.data.local.TaskDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        application: Application
    ): AppDatabase{
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "mystudy.db"
            )
            .build()
    }
    @Provides
    @Singleton
    fun provideSubjectDao(database: AppDatabase):SubjectDao {
        return database.subjectDao()
    }

    @Provides
    @Singleton
    fun provideTaskDao(database: AppDatabase):TaskDao {
        return database.taskDao()
    }

    @Provides
    @Singleton
    fun provideSessionDao(database: AppDatabase):SessionDao {
        return database.sessionDao()
    }
}