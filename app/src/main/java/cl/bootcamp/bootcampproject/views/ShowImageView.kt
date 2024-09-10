package cl.bootcamp.bootcampproject.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.bootcamp.bootcampproject.components.NameText
import cl.bootcamp.bootcampproject.components.ShowImage
import cl.bootcamp.bootcampproject.components.ShowImageButton
import cl.bootcamp.bootcampproject.components.WelcomeText
import cl.bootcamp.bootcampproject.viewModels.ShowImageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowImageView(
    modifier: Modifier,
    viewModel: ShowImageViewModel
) {
    Scaffold ()
    {
        ContentShowImageView(it, viewModel)
    }
}

@Composable
fun ContentShowImageView(
    paddingValues: PaddingValues,
    viewModel: ShowImageViewModel
) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        WelcomeText(
            text = state.welcomeText
        )

        Spacer(modifier = Modifier.height(12.dp))

        NameText(
            text = state.name 
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (state.isPressed) {
            ShowImageButton(
                text = state.isPressedText
            ) {
                viewModel.buttonPressed()
            }
        } else {
            ShowImageButton(
                text = state.isNotPressedText
            ) {
                viewModel.buttonPressed()
            }
        }
    }

    if (state.isPressed) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center // Center content inside the Box
        ) {
            ShowImage(
                link = state.imageURL
            )
        }
    } else {
        Spacer(modifier = Modifier.height(0.dp))
    }


}