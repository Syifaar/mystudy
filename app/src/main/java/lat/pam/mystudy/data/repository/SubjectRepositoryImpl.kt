package lat.pam.mystudy.data.repository

import kotlinx.coroutines.flow.Flow
import lat.pam.mystudy.data.local.SessionDao
import lat.pam.mystudy.data.local.SubjectDao
import lat.pam.mystudy.data.local.TaskDao
import lat.pam.mystudy.domain.model.Subject
import lat.pam.mystudy.domain.repository.SubjectRepository
import javax.inject.Inject

class SubjectRepositoryImpl @Inject constructor(
    private val subjectDao: SubjectDao,
    private val taskDao: TaskDao,
    private val sessionDao: SessionDao
): SubjectRepository {
    override suspend fun deleteSubject(subjectId: Int) {
        taskDao.deleteTaskBySubjectId(subjectId)
        sessionDao.deleteSessionsBySubjectId(subjectId)
        subjectDao.deleteSubject(subjectId)
    }

    override suspend fun upsertSubject(subject: Subject) {
        subjectDao.upsertSubject(subject)
    }

    override fun getTotalSubjectCount(): Flow<Int> {
        return subjectDao.getTotalSubjectCount()
    }

    override fun getTotalGoalHours(): Flow<Float> {
        return subjectDao.getTotalGoalHours()
    }

    override suspend fun getSubjectById(subjectId: Int): Subject? {
        return subjectDao.getSubjectById(subjectId)
    }

    override fun getAllSubjects(): Flow<List<Subject>> {
        return  subjectDao.getAllSubjects()
    }
}