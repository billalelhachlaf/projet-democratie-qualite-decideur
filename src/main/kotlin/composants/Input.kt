package composants

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import reduireNb


fun SnackbarHostState.showSnackbar(message: String, scope: CoroutineScope) {
    if (currentSnackbarData != null)
        currentSnackbarData?.dismiss()

    scope.launch {
        showSnackbar(message, duration =
            SnackbarDuration.Short)
    }
}

@Composable
@Preview
fun Input(titre:String, valeurDefaut:Float, onClick: (Float) -> Number){
    val scope = rememberCoroutineScope()
    val textState = remember { mutableStateOf(valeurDefaut.reduireNb()) }
    val snackbarHostState = remember { SnackbarHostState() }
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .zIndex(2f)
        )
        Text(titre,
            fontSize = 18.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedTextField(
                modifier = Modifier.height(55.dp),
                shape = RoundedCornerShape(12.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                value = textState.value,
                onValueChange =
                {
                    textState.value = it
                },
            )
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF14AE5C)),
                onClick = {
                    val text = textState.value
                    scope.launch() {
                        if(text.isNotEmpty() && text.toFloatOrNull() !=null){
                            val codeResultat = onClick(text.toFloat())
                            if(codeResultat==200) snackbarHostState.showSnackbar("Modifié avec succès", scope);
                            else snackbarHostState.showSnackbar("Erreur lors de la modification", scope);
                        }
                        else{
                            snackbarHostState.showSnackbar("Veuillez renseigner un nombre valide", scope);
                        }
                    }
                }) {
                Text("Valider", color = Color.White)
            }
        }
    }
}
