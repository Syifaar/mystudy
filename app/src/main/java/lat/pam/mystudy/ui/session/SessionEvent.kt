package lat.pam.mystudy.ui.session

import lat.pam.mystudy.domain.model.Session
import lat.pam.mystudy.domain.model.Subject

sealed class SessionEvent {
    data class OnRelatedSubjectChange(val subject: Subject) : SessionEvent()

    data class SaveSession(val duration: Long) : SessionEvent()

    data class OnDeleteSessionButtonClick(val session: Session) : SessionEvent()

    data object DeleteSession : SessionEvent()

    data object NotifiyToUpdateSubject: SessionEvent()

    data class UpdateSubjectIdAndRelatedSubject(
        val subjectId: Int?,
        val relatedToSubject: String?
    ) : SessionEvent()
}