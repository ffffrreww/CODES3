package com.appsdevs.popit

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import kotlin.math.*

// ==================== GENERATED BUBBLES (CODE-BASED) ====================

// ==================== BUBBLE 11: FIRE ====================
@Composable
fun FireBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "fire")
    val flame by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "flame"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFFFD700),
                        Color(0xFFFF8C00),
                        Color(0xFFFF4500),
                        Color(0xFFDC143C).copy(alpha = 0.8f * flame)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 12: ICE ====================
@Composable
fun IceBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "ice")
    val shimmer by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF).copy(alpha = 0.9f),
                        Color(0xFFE0FFFF),
                        Color(0xFF87CEEB),
                        Color(0xFF4682B4).copy(alpha = 0.7f + 0.3f * shimmer)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 13: ELECTRIC ====================
@Composable
fun ElectricBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "electric")
    val spark by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "spark"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFFFFF00).copy(alpha = spark),
                        Color(0xFF00FFFF),
                        Color(0xFF0000FF).copy(alpha = 0.6f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 14: NATURE ====================
@Composable
fun NatureBubble(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFE0FFE0),
                        Color(0xFF90EE90),
                        Color(0xFF32CD32),
                        Color(0xFF228B22).copy(alpha = 0.7f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 15: GALAXY ====================
@Composable
fun GalaxyBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "galaxy")
    val rotate by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotate"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFF000033),
                        Color(0xFF4B0082),
                        Color(0xFF8A2BE2),
                        Color(0xFFFF1493),
                        Color(0xFF000033)
                    ),
                    center = Offset(centerX, centerY)
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 16: LAVA ====================
@Composable
fun LavaBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "lava")
    val flow by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "flow"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFF00),
                        Color(0xFFFF8C00).copy(alpha = 0.8f + 0.2f * flow),
                        Color(0xFFFF4500),
                        Color(0xFF8B0000).copy(alpha = 0.7f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 17: CRYSTAL ====================
@Composable
fun CrystalBubble(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFE6E6FA),
                        Color(0xFFDA70D6),
                        Color(0xFF9370DB).copy(alpha = 0.8f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 18: SUNSET ====================
@Composable
fun SunsetBubble(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFD700),
                        Color(0xFFFF8C00),
                        Color(0xFFFF6347),
                        Color(0xFFFF1493),
                        Color(0xFF8B008B)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 19: MIDNIGHT ====================
@Composable
fun MidnightBubble(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF4B0082),
                        Color(0xFF191970),
                        Color(0xFF000080),
                        Color(0xFF000033).copy(alpha = 0.9f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 20: CHERRY BLOSSOM ====================
@Composable
fun CherryBlossomBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "blossom")
    val petals by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "petals"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFFFB6C1).copy(alpha = 0.7f + 0.3f * petals),
                        Color(0xFFFF69B4),
                        Color(0xFFFF1493).copy(alpha = 0.6f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 21: TOXIC ====================
@Composable
fun ToxicBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "toxic")
    val pulse by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFCCFF00).copy(alpha = 0.9f + 0.1f * pulse),
                        Color(0xFF9ACD32),
                        Color(0xFF32CD32),
                        Color(0xFF228B22).copy(alpha = 0.7f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 22: WATER ====================
@Composable
fun WaterBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "water")
    val wave by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "wave"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFE0FFFF).copy(alpha = 0.8f + 0.2f * wave),
                        Color(0xFF87CEEB),
                        Color(0xFF4682B4),
                        Color(0xFF0000CD).copy(alpha = 0.7f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 23: DIAMOND ====================
@Composable
fun DiamondBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "diamond")
    val sparkle by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "sparkle"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFE0E0E0).copy(alpha = 0.7f + 0.3f * sparkle),
                        Color(0xFFC0C0C0),
                        Color(0xFFA9A9A9).copy(alpha = 0.8f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 24: NEON ====================
@Composable
fun NeonBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "neon")
    val glow by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glow"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFF00FFFF).copy(alpha = 0.7f + 0.3f * glow),
                        Color(0xFFFF00FF),
                        Color(0xFF8B00FF).copy(alpha = 0.8f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 25: AURORA ====================
@Composable
fun AuroraBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "aurora")
    val shift by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "shift"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF00FF00).copy(alpha = 0.6f + 0.4f * shift),
                        Color(0xFF00FFFF),
                        Color(0xFF0000FF),
                        Color(0xFF8B00FF).copy(alpha = 0.7f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 26: RAINBOW SWIRL ====================
@Composable
fun RainbowSwirlBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "rainbow")
    val rotate by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotate"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFFF0000),
                        Color(0xFFFF7F00),
                        Color(0xFFFFFF00),
                        Color(0xFF00FF00),
                        Color(0xFF0000FF),
                        Color(0xFF8B00FF),
                        Color(0xFFFF0000)
                    ),
                    center = Offset(centerX, centerY)
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 27: SMOKE ====================
@Composable
fun SmokeBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "smoke")
    val drift by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "drift"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF).copy(alpha = 0.4f),
                        Color(0xFFD3D3D3).copy(alpha = 0.5f + 0.3f * drift),
                        Color(0xFFA9A9A9).copy(alpha = 0.6f),
                        Color(0xFF696969).copy(alpha = 0.7f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 28: CANDY ====================
@Composable
fun CandyBubble(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFFFB6C1),
                        Color(0xFFFF69B4),
                        Color(0xFFFF1493).copy(alpha = 0.8f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 29: METAL ====================
@Composable
fun MetalBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "metal")
    val shine by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "shine"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF).copy(alpha = 0.8f + 0.2f * shine),
                        Color(0xFFE0E0E0),
                        Color(0xFF808080),
                        Color(0xFF404040).copy(alpha = 0.9f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}

// ==================== BUBBLE 30: PLASMA ====================
@Composable
fun PlasmaBubble(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "plasma")
    val energy by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "energy"
    )

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = min(size.width, size.height) / 2.5f

            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFFF00FF).copy(alpha = 0.6f + 0.4f * energy),
                        Color(0xFF00FFFF),
                        Color(0xFF0000FF).copy(alpha = 0.8f)
                    )
                ),
                center = Offset(centerX, centerY),
                radius = radius
            )
        }
    }
}
