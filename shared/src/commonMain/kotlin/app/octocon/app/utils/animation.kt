package app.octocon.app.utils

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

enum class AnimationSpeed {
  SLOW,
  DEFAULT,
  FAST
}

@Composable fun <T> spatialSpec(speed: AnimationSpeed = AnimationSpeed.DEFAULT): FiniteAnimationSpec<T> = when (speed) {
  AnimationSpeed.SLOW -> MaterialTheme.motionScheme.slowSpatialSpec()
  AnimationSpeed.DEFAULT -> MaterialTheme.motionScheme.defaultSpatialSpec()
  AnimationSpeed.FAST -> MaterialTheme.motionScheme.fastSpatialSpec()
}

@Composable fun <T> effectsSpec(speed: AnimationSpeed = AnimationSpeed.DEFAULT): FiniteAnimationSpec<T> = when (speed) {
  AnimationSpeed.SLOW -> MaterialTheme.motionScheme.slowEffectsSpec()
  AnimationSpeed.DEFAULT -> MaterialTheme.motionScheme.defaultEffectsSpec()
  AnimationSpeed.FAST -> MaterialTheme.motionScheme.fastEffectsSpec()
}