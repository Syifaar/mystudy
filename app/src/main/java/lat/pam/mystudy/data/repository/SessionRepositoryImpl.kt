package lat.pam.mystudy.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import lat.pam.mystudy.data.local.SessionDao
import lat.pam.mystudy.domain.model.Session
import lat.pam.mystudy.domain.repository.SessionRepository
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val sessionDao: SessionDao
): SessionRepository{
    override suspend fun deleteSession(session: Session) {
        sessionDao.deleteSession(session)
    }

    override suspend fun insertSession(session: Session) {
        sessionDao.insertSession(session)
    }

    override fun getAllSession(): Flow<List<Session>> {
        return sessionDao.getAllSessions()
            .map { sessions -> sessions.sortedByDescending { it.date } }
    }

    override fun getRecentFiveSessions(): Flow<List<Session>> {
        return sessionDao.getAllSessions()
            .map { sessions -> sessions.sortedByDescending { it.date } }
            .take(count = 5)
    }

    override fun getRecentTenSessionsForSubject(subjectId: Int): Flow<List<Session>> {
        return sessionDao.getRecentSessionsForSubject(subjectId).take(count = 10)
    }

    override fun getTotalSessionsDuration(): Flow<Long> {
        return sessionDao.getTotalSessionsDuration()
    }

    override fun getTotalSessionsDurationBySubject(subjectId: Int): Flow<Long> {
        return sessionDao.getTotalSessionsDurationBySubject(subjectId)
    }
}