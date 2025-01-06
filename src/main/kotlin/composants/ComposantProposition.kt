package composants

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import modele.Proposition

@Composable
fun ComposantProposition(proposition: Proposition){
    CardCustom (
    ){  Text(
        proposition.getTitre(),
        style = MaterialTheme.typography.h6,
        color = Color.Black,
        fontSize = 25.sp,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight.SemiBold
    );
        PiluleTheme(proposition.getTheme())
        Input("Budget", proposition.getEvaluation()){
                evaluation -> proposition.modifierEvaluation(evaluation)
        }
    }
}