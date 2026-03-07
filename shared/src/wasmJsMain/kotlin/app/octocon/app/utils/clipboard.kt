package app.octocon.app.utils

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.NativeClipboard
import androidx.compose.ui.text.AnnotatedString
import kotlinx.coroutines.DelicateCoroutinesApi

@OptIn(ExperimentalComposeUiApi::class)
val clipboard by lazy { NativeClipboard() }

@OptIn(DelicateCoroutinesApi::class, ExperimentalComposeUiApi::class,
  ExperimentalWasmJsInterop::class
)
actual fun NativeClipboard.setText(annotatedString: AnnotatedString) {
  clipboard.writeText(annotatedString.text)
}