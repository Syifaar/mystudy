package lat.pam.mystudy.ui.session

import lat.pam.mystudy.domain.model.Session
import lat.pam.mystudy.domain.model.Subject

data class SessionState(
    val subjects: List<Subject> = emptyList(),
    val sessions: List<Session> = emptyList(),
    val relatedToSubject: String? = null,
    val subjectId: Int? = null,
    val session: Session? = null
)