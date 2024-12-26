package lat.pam.mystudy.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import lat.pam.mystudy.ui.theme.gradient1
import lat.pam.mystudy.ui.theme.gradient2
import lat.pam.mystudy.ui.theme.gradient3
import lat.pam.mystudy.ui.theme.gradient4
import lat.pam.mystudy.ui.theme.gradient5

@Entity
data class Subject(
    val name: String,
    val goalHours: Float,
    val colors: List<Int>,
    @PrimaryKey(autoGenerate = true)
    val subjectId: Int? = null
) {
    companion object{
        val subjectCardColor = listOf(gradient1, gradient2, gradient3, gradient4, gradient5)
    }
}