package lat.pam.mystudy.domain.repository

import kotlinx.coroutines.flow.Flow
import lat.pam.mystudy.domain.model.Session

interface SessionRepository {

    suspend fun insertSession(session: Session)

    suspend fun deleteSession(session: Session)

    fun getAllSession(): Flow<List<Session>>

    fun getRecentFiveSessions(): Flow<List<Session>>

    fun getRecentTenSessionsForSubject(subjectId: Int): Flow<List<Session>>

    fun getTotalSessionsDuration(): Flow<Long>

    fun getTotalSessionsDurationBySubject(subjectId: Int): Flow<Long>
}