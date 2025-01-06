package composants

import androidx.compose.runtime.Composable
import modele.Theme

@Composable
fun ComposantTheme(theme: Theme){
    CardCustom (
    ){
        PiluleTheme(theme)
        Input("Budget", theme.getLimiteBudget()){
                budget -> theme.modifierBudget(budget)
        }
    }
}