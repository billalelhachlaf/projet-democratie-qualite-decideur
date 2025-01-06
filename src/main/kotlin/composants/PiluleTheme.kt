package composants

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import modele.Theme

@Composable
@Preview
fun PiluleTheme(theme: Theme){
    Column(
        modifier = Modifier
            .background(Color(0xFF206A55), RoundedCornerShape(50.dp))
            .padding(15.dp, 8.dp)
    ){
        Text(
            theme.getNom(),
            style = MaterialTheme.typography.h6,
            color = Color.White,
            fontSize = 15.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Normal,
        );

    }
}