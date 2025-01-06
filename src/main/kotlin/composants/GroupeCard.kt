package composants

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import modele.Groupe

@Composable
@Preview
fun GroupeCard(groupe: Groupe){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(
            groupe.getNom(),
            modifier = Modifier
                .padding(40.dp, 0.dp),
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            fontSize = 60.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
        );
        Text(
            groupe.getDesc(),
            modifier = Modifier
                .padding(40.dp, 0.dp),
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Normal
        );
        Text(
            "${groupe.getNbMembres()} membres",
            modifier = Modifier
                .padding(40.dp, 0.dp),
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.SemiBold
        );
        Input("Budget", groupe.getLimiteBudgetAnnuel()) {
                budget -> groupe.modifierBudget(budget)
        };
    }
}
