package lat.pam.mystudy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import lat.pam.mystudy.domain.model.Session
import lat.pam.mystudy.domain.model.Subject
import lat.pam.mystudy.domain.model.Task

@Database(
    entities = [Subject::class, Session::class, Task::class],
    version = 1
)

@TypeConverters(ColorListConverter::class)
abstract class AppDatabase:RoomDatabase(){
    abstract fun subjectDao(): SubjectDao

    abstract fun taskDao(): TaskDao

    abstract fun sessionDao(): SessionDao
}