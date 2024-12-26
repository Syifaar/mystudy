package lat.pam.mystudy.ui.subject

import androidx.compose.ui.graphics.Color
import lat.pam.mystudy.domain.model.Session
import lat.pam.mystudy.domain.model.Subject
import lat.pam.mystudy.domain.model.Task

data class SubjectState(
    val currentSubjectId: Int? = null,
    val subjectName: String = "",
    val goalStudyHours: String = "",
    val studiedHours: Float = 0f,
    val subjectCardColors: List<Color> = Subject.subjectCardColor.random(),
    val recentSessions: List<Session> = emptyList(),
    val upcomingTasks: List<Task> = emptyList(),
    val completedTask: List<Task> = emptyList(),
    val session: Session? = null,
    val progress: Float = 0f,
)