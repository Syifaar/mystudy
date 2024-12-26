package lat.pam.mystudy.ui.dashboard

import androidx.compose.ui.graphics.Color
import lat.pam.mystudy.domain.model.Session
import lat.pam.mystudy.domain.model.Subject

data class DashboardState(
    val totalSubjectCount: Int = 0,
    val totalStudiedHours: Float = 0f,
    val totalGoalStudyHours: Float = 0f,
    val subjects: List<Subject> = emptyList(),
    val subjectName: String = "",
    val goalStudyHours: String = "",
    val subjectCardColors: List<Color> = Subject.subjectCardColor.random(),
    val session: Session? = null
)