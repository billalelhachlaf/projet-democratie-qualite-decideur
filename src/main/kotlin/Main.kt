import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.ui.zIndex
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import composants.ComposantProposition
import composants.ComposantTheme
import composants.GroupeCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import modele.*
import modele.DTO.*


@Composable
@Preview
fun App() {

    //modifiez l'idGroupe pour afficher un autre groupe ici

    val idGroupe = 1

    val jsonResponse = Groupe.getGroupeFromApi(idGroupe);

    val gson = Gson()

    val jsonObject = gson.fromJson(jsonResponse, JsonObject::class.java)

    var groupe : GroupeDTO = gson.fromJson(jsonObject["groupe"], GroupeDTO::class.java)

    val themeListType = object : TypeToken<List<ThemeDTO?>?>() {}.type
    val themes = gson.fromJson<ArrayList<ThemeDTO>>(jsonObject["themes"], themeListType)

    val propositionListType = object : TypeToken<List<PropositionDTO?>?>() {}.type
    val propositions = gson.fromJson<ArrayList<PropositionDTO>>(jsonObject["propositions"], propositionListType)

    val scrutinListType = object : TypeToken<List<ScrutinDTO?>?>() {}.type
    val scrutins = gson.fromJson<ArrayList<ScrutinDTO>>(jsonObject["scrutins"], scrutinListType)

    val optionsScrutinListType = object : TypeToken<List<OptionScrutinDTO?>?>() {}.type
    val optionScrutins = gson.fromJson<ArrayList<OptionScrutinDTO>>(jsonObject["optionsScrutin"], optionsScrutinListType)

    val choixUtilisateursListType = object : TypeToken<List<ChoixUtilisateurDTO?>?>() {}.type
    val choixUtilisateurs =
        gson.fromJson<ArrayList<ChoixUtilisateurDTO>>(jsonObject["choixUtilisateurs"], choixUtilisateursListType)


    val groupeMap: MutableMap<Int, GroupeDTO> = HashMap()
    val themeMap: MutableMap<Int, ThemeDTO> = HashMap()
    val propositionMap: MutableMap<Int, PropositionDTO> = HashMap()
    val scrutinMap: MutableMap<Int, ScrutinDTO> = HashMap()
    val optionScrutinMap: MutableMap<Int, OptionScrutinDTO> = HashMap()
    val choixUtilisateurMap: MutableMap<Int, ChoixUtilisateurDTO> = HashMap()

    groupeMap[groupe.getIdGroupe()] = groupe
    for (theme in themes) themeMap[theme.getIdTheme()] = theme
    for (proposition in propositions) propositionMap[proposition.getIdProposition()] = proposition
    for (scrutin in scrutins) scrutinMap[scrutin.getIdScrutin()] = scrutin
    for (optionScrutin in optionScrutins) optionScrutinMap[optionScrutin.getIdOptionScrutin()] =
        optionScrutin
    for (choixUtilisateur in choixUtilisateurs) choixUtilisateurMap[choixUtilisateur.getIdChoixUtilisateur()] =
        choixUtilisateur

    for (proposition in propositions) {
        proposition.setGroupe(groupeMap[proposition.getIdGroupe()]) // proposition: 1 groupe
        proposition.setTheme(themeMap[proposition.getIdTheme()]) //proposition : 1 theme

        proposition.getTheme().getPropositions().add(proposition) // theme: * propositions

        proposition.getGroupe().getPropositions().add(proposition) // groupe: * propositions
    }

    for (theme in themes) {
        theme.setGroupe(groupeMap[theme.getIdGroupe()]) //theme : 1 groupe
        theme.getGroupe().getThemes().add(theme) //groupe : * themes
    }

    for (scrutin in scrutins) {
        scrutin.setProposition(propositionMap[scrutin.getIdProposition()]) // scrutin : 1 proposition
        scrutin.getProposition().getScrutins().add(scrutin) // proposition : * scrutins
    }

    for (optionScrutin in optionScrutins) {
        optionScrutin.setScrutin(scrutinMap[optionScrutin.getIdScrutin()]) // optionScrutin : 1 scrutin
        optionScrutin.getScrutin().getOptionsScrutin().add(optionScrutin) // scrutin : * optionScrutin
    }

    for (choixUtilisateur in choixUtilisateurs) {
        choixUtilisateur.setOptionScrutin(optionScrutinMap[choixUtilisateur.getIdOptionScrutin()]) // modele.ChoixUtilisateur : 1 optionScrutin
        choixUtilisateur.getOptionScrutin().getChoixUtilisateurs()
            .add(choixUtilisateur) // optionScrutin : * modele.ChoixUtilisateur

        choixUtilisateur.setScrutin(scrutinMap[choixUtilisateur.getIdScrutin()])
        choixUtilisateur.getScrutin().getChoixUtilisateurs().add(choixUtilisateur)
    }


    Groupe.groupe = groupe
    Theme.themes = themes as ArrayList<*> as ArrayList<Theme?>
    Proposition.propositions = propositions as ArrayList<*> as ArrayList<Proposition?>
    Scrutin.scrutins = scrutins as ArrayList<*> as ArrayList<Scrutin?>
    OptionScrutin.optionScrutins = optionScrutins as ArrayList<*> as ArrayList<OptionScrutin?>
    ChoixUtilisateur.choixUtilisateurs = choixUtilisateurs as ArrayList<*> as ArrayList<ChoixUtilisateur?>


    //Tests pour afficher les données si besoin
    /*
    System.out.println("modele.Groupe: " + Groupe.groupe.getNom())
    for (theme in Groupe.groupe.getThemes()) {
        System.out.println("\tmodele.Theme: " + theme.getNom())
        for (proposition in theme.getPropositions()) {
            System.out.println("\t\tmodele.Proposition: " + proposition.getTitre())
            for (scrutin in proposition.getScrutins()) {
                System.out.println(("\t\t\tmodele.Scrutin: " + scrutin.getTitre()).toString() + " : " + scrutin.getType())
                for (optionScrutin in scrutin.getOptionsScrutin()) {
                    System.out.println("\t\t\t\tmodele.OptionScrutin: " + optionScrutin.getOptionScrutin())
                    for (choixUtilisateur in optionScrutin.getChoixUtilisateurs()) {
                        System.out.println(("\t\t\t\t\tidUtilisateur: " + choixUtilisateur.getIdUtilisateur()).toString() + " : " + choixUtilisateur.getClassement())
                    }
                }
            }
        }
    }*/

    val scrollState = rememberScrollState();

    Row(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {


            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxSize()
                    .padding(50.dp, 10.dp),
                ) {

                GroupeCard(Groupe.groupe)

                Text("Thèmes", fontSize = 30.sp, fontWeight = FontWeight.W600)
                Column (
                    verticalArrangement = Arrangement.spacedBy(40.dp),
                ){
                    for (theme in Groupe.getGroupe().getThemes())
                        ComposantTheme(theme)
                }

                Text("Propositions", fontSize = 30.sp, fontWeight = FontWeight.W600)
                Column (
                    verticalArrangement = Arrangement.spacedBy(40.dp),
                ){
                    for (proposition in Groupe.getGroupe().getPropositions())
                        ComposantProposition(proposition)
                }

            }

        }
        VerticalScrollbar(
            modifier = Modifier.fillMaxHeight(),
            adapter = rememberScrollbarAdapter(scrollState)
        )
    }

}



fun main() = application {
    Window(title = "Votely - Décideurs",
        onCloseRequest = ::exitApplication, state = rememberWindowState(
        width = 1200.dp,
        height = 800.dp,
    )) {
        App()
    }
}
