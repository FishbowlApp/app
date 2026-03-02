package app.octocon.app.utils

import androidx.compose.runtime.Composable
import app.octocon.app.ScreenTransitionType
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.PredictiveBackParams
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.StackAnimator
import com.arkivanov.decompose.extensions.compose.experimental.stack.animation.stackAnimation
import com.arkivanov.essenty.backhandler.BackHandler

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun <C : Any, T : Any> backAnimation(
  screenTransitionType: ScreenTransitionType,
  reduceMotion: Boolean,
  backHandler: BackHandler,
  onBack: () -> Unit
): StackAnimation<C, T> {
  if(screenTransitionType == ScreenTransitionType.NATIVE) {
    return stackAnimation(
      animator = platformStackAnimator(reduceMotion),
      predictiveBackParams = { predictiveBackParams(backHandler, onBack) }
    )
  }

  return stackAnimation(animator = screenTransitionType.animator)
}

@OptIn(ExperimentalDecomposeApi::class)
expect fun predictiveBackParams(
  backHandler: BackHandler,
  onBack: () -> Unit
): PredictiveBackParams?

@OptIn(ExperimentalDecomposeApi::class)
@Composable
expect fun platformStackAnimator(reduceMotion: Boolean): StackAnimator