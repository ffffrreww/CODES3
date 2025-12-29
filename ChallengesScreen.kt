package com.appsdevs.popit

import android.content. Intent
import androidx.compose.animation.core.EaseInOutSine
import androidx.compose.animation.core.RepeatMode
import androidx.compose. animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx. compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core. spring
import androidx.compose.animation. core.tween
import androidx. compose.foundation. Image
import androidx.compose.foundation. background
import androidx.compose.foundation.border
import androidx.compose.foundation. clickable
import androidx.compose. foundation.layout. Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation. layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation. layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose. foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation. layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout. width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation. rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose. foundation.shape.RoundedCornerShape
import androidx.compose. foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx. compose.runtime.collectAsState
import androidx.compose. runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx. compose.runtime.mutableStateOf
import androidx.compose.runtime. remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui. Alignment
import androidx.compose. ui.Modifier
import androidx. compose.ui.draw.alpha
import androidx.compose.ui. draw.clip
import androidx.compose.ui. draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics. Brush
import androidx.compose.ui.graphics.Color
import androidx. compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose. ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx. compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui. unit.sp
import kotlinx.coroutines.launch

// ==================== CHALLENGES LIST ====================

@Composable
fun ChallengesList(
    ds: DataStoreManager,
    onChallengeAction: (challengeId: Int) -> Unit = {}
) {
    val recordBubbleKing by ds.highScoreBubbleKingFlow().collectAsState(initial = 0)
    val recordPerfectStreak by ds.highScorePerfectStreakFlow().collectAsState(initial = 0)
    val recordTimeMaster by ds.highScoreTimeMasterFlow().collectAsState(initial = 0)

    val claimed30_1 by ds.isChallengeRewardClaimedFlow(1, 30).collectAsState(initial = false)
    val claimed60_1 by ds.isChallengeRewardClaimedFlow(1, 60).collectAsState(initial = false)
    val claimed100_1 by ds.isChallengeRewardClaimedFlow(1, 100).collectAsState(initial = false)

    val claimed30_2 by ds.isChallengeRewardClaimedFlow(2, 30).collectAsState(initial = false)
    val claimed60_2 by ds.isChallengeRewardClaimedFlow(2, 60).collectAsState(initial = false)
    val claimed100_2 by ds.isChallengeRewardClaimedFlow(2, 100).collectAsState(initial = false)

    val claimed30_3 by ds.isChallengeRewardClaimedFlow(3, 30).collectAsState(initial = false)
    val claimed60_3 by ds.isChallengeRewardClaimedFlow(3, 60).collectAsState(initial = false)
    val claimed100_3 by ds.isChallengeRewardClaimedFlow(3, 100).collectAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement. spacedBy(16.dp)
    ) {
        // Header with Tournament Button
        ChallengesHeader()

        Spacer(modifier = Modifier. height(4.dp))

        // Challenge Cards
        ChallengeCard(
            challengeId = 1,
            title = "Bubble King",
            subtitle = "Reach 5000 points",
            icon = "👑",
            record = recordBubbleKing,
            target = 5000,
            accentColor = Color(0xFFFF6D00),
            secondaryColor = Color(0xFFFFD700),
            claimed30 = claimed30_1,
            claimed60 = claimed60_1,
            claimed100 = claimed100_1,
            finalRewardDrawable = R.drawable.background6,
            finalRewardName = "Aurora Sky Background",
            ds = ds,
            onPlay = { onChallengeAction(1) }
        )

        ChallengeCard(
            challengeId = 2,
            title = "Perfect Streak",
            subtitle = "100 perfect pops in a row",
            icon = "🎯",
            record = recordPerfectStreak,
            target = 100,
            accentColor = Color(0xFF4CAF50),
            secondaryColor = Color(0xFF81C784),
            claimed30 = claimed30_2,
            claimed60 = claimed60_2,
            claimed100 = claimed100_2,
            finalRewardDrawable = R.drawable. mainmenu5,
            finalRewardName = "Galaxy Core Menu",
            ds = ds,
            onPlay = { onChallengeAction(2) }
        )

        ChallengeCard(
            challengeId = 3,
            title = "Time Master",
            subtitle = "Pop 140 bubbles in 60s",
            icon = "⏱️",
            record = recordTimeMaster,
            target = 140,
            accentColor = Color(0xFF2196F3),
            secondaryColor = Color(0xFF64B5F6),
            claimed30 = claimed30_3,
            claimed60 = claimed60_3,
            claimed100 = claimed100_3,
            finalRewardDrawable = R. drawable.cyberpunkbubble,
            finalRewardName = "Cyberpunk Bubble",
            ds = ds,
            onPlay = { onChallengeAction(3) }
        )

        Spacer(modifier = Modifier. height(60.dp))
    }
}

// ==================== HEADER WITH TOURNAMENT BUTTON ====================

@Composable
private fun ChallengesHeader() {
    val ctx = LocalContext.current

    val infiniteTransition = rememberInfiniteTransition(label = "headerEffects")

    val headerPulse by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.03f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "headerPulse"
    )

    val tournamentGlow by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "tournamentGlow"
    )

    val tournamentFloat by infiniteTransition.animateFloat(
        initialValue = -3f,
        targetValue = 3f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "tournamentFloat"
    )

    val trophyRotation by infiniteTransition.animateFloat(
        initialValue = -5f,
        targetValue = 5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "trophyRotation"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title Section
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.scale(headerPulse)
        ) {
            Text(text = "🏆", fontSize = 40.sp)
            Spacer(modifier = Modifier. height(8.dp))
            Text(
                text = "CHALLENGES",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color. White,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color(0xFFFFD700).copy(alpha = 0.5f),
                        offset = Offset(0f, 0f),
                        blurRadius = 16f
                    )
                )
            )
            Text(
                text = "Complete challenges to earn rewards!",
                fontSize = 13.sp,
                color = Color.White.copy(alpha = 0.6f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Tournament Button - Premium Design
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .offset(y = tournamentFloat. dp)
                .clickable {
                    ctx.startActivity(Intent(ctx, TournamentActivity::class.java))
                },
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color. Transparent),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF7B1FA2),
                                Color(0xFF9C27B0),
                                Color(0xFFAB47BC)
                            )
                        )
                    )
                    .border(
                        width = 2.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFFFD700).copy(alpha = tournamentGlow),
                                Color(0xFFFF6D00).copy(alpha = tournamentGlow * 0.7f),
                                Color(0xFFFFD700).copy(alpha = tournamentGlow)
                            )
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                // Background decorations
                Box(modifier = Modifier.fillMaxSize().alpha(0.1f)) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .offset(x = (-20).dp, y = (-20).dp)
                            .clip(CircleShape)
                            .background(Color. White)
                    )
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment. BottomEnd)
                            .offset(x = 20.dp, y = 20.dp)
                            . clip(CircleShape)
                            .background(Color.White)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Left side - Trophy and text
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Animated Trophy
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .background(
                                    brush = Brush. radialGradient(
                                        colors = listOf(
                                            Color(0xFFFFD700).copy(alpha = 0.3f),
                                            Color. Transparent
                                        )
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "🏆",
                                fontSize = 36.sp,
                                modifier = Modifier.graphicsLayer { rotationZ = trophyRotation }
                            )
                        }

                        Spacer(modifier = Modifier. width(14.dp))

                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "TOURNAMENT",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
                                    style = TextStyle(
                                        shadow = Shadow(
                                            color = Color. Black.copy(alpha = 0.5f),
                                            offset = Offset(2f, 2f),
                                            blurRadius = 4f
                                        )
                                    )
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                // LIVE badge
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        . background(Color(0xFF4CAF50))
                                        .padding(horizontal = 8.dp, vertical = 2.dp)
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Box(
                                            modifier = Modifier
                                                .size(6.dp)
                                                . clip(CircleShape)
                                                .background(Color.White)
                                                .alpha(tournamentGlow)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "LIVE",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier. height(2.dp))
                            Text(
                                text = "Compete for amazing prizes!",
                                fontSize = 12.sp,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                        }
                    }

                    // Right side - Arrow
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(Color.White. copy(alpha = 0.2f))
                            .border(1.dp, Color.White. copy(alpha = 0.3f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "→",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color. White
                        )
                    }
                }

                // Shine effect
                Box(
                    modifier = Modifier
                        . fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color. White.copy(alpha = 0.1f * tournamentGlow),
                                    Color. Transparent,
                                    Color. Transparent
                                ),
                                start = Offset(0f, 0f),
                                end = Offset(500f, 500f)
                            )
                        )
                )
            }
        }

        // Rewards preview
        Spacer(modifier = Modifier. height(10.dp))
        Card(
            modifier = Modifier. fillMaxWidth(0.9f),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF0F0F1A).copy(alpha = 0.6f)
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement. Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "🎁", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Prizes:  ",
                    fontSize = 12.sp,
                    color = Color.White.copy(alpha = 0.6f)
                )
                Image(
                    painter = painterResource(id = R.drawable.coin),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = " 100K ",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFD700)
                )
                Text(text = "+", fontSize = 12.sp, color = Color. White. copy(alpha = 0.4f))
                Spacer(modifier = Modifier. width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable. gemgame),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = " 500 LUX",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B1FA2)
                )
            }
        }
    }
}

// ==================== CHALLENGE CARD ====================

@Composable
private fun ChallengeCard(
    challengeId: Int,
    title: String,
    subtitle: String,
    icon: String,
    record: Int,
    target: Int,
    accentColor: Color,
    secondaryColor: Color,
    claimed30: Boolean,
    claimed60: Boolean,
    claimed100: Boolean,
    finalRewardDrawable: Int,
    finalRewardName: String,
    ds: DataStoreManager,
    onPlay: () -> Unit
) {
    val scope = rememberCoroutineScope()

    val progress by remember(record, target) {
        derivedStateOf {
            if (target <= 0) 0f else (record. coerceAtMost(target).toFloat() / target.toFloat())
        }
    }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(1000, easing = EaseInOutSine),
        label = "progressAnim"
    )

    var showRewardPreview by remember { mutableStateOf(false) }
    var previewRewardData by remember { mutableStateOf<RewardPreviewData?>(null) }

    val infiniteTransition = rememberInfiniteTransition(label = "cardGlow")
    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 0.6f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glow"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A2E)),
        elevation = CardDefaults. cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            accentColor.copy(alpha = 0.15f),
                            Color(0xFF1A1A2E)
                        )
                    )
                )
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            accentColor.copy(alpha = glowAlpha),
                            secondaryColor.copy(alpha = glowAlpha * 0.5f)
                        )
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Header row
                Row(
                    modifier = Modifier. fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment. CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    brush = Brush. linearGradient(
                                        colors = listOf(accentColor, secondaryColor)
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = icon, fontSize = 28.sp)
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Text(
                                text = title,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                style = TextStyle(
                                    shadow = Shadow(
                                        color = Color.Black.copy(alpha = 0.3f),
                                        offset = Offset(1f, 1f),
                                        blurRadius = 2f
                                    )
                                )
                            )
                            Text(
                                text = subtitle,
                                fontSize = 12.sp,
                                color = Color.White.copy(alpha = 0.6f)
                            )
                        }
                    }

                    Button(
                        onClick = onPlay,
                        modifier = Modifier
                            .width(90.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = accentColor),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                    ) {
                        Text(text = "PLAY", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Spacer(modifier = Modifier. height(16.dp))

                // Progress section
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Progress",
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.6f)
                        )
                        Text(
                            text = "$record / $target",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = accentColor
                        )
                    }

                    Spacer(modifier = Modifier. height(8.dp))

                    // Progress bar
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(24.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .align(Alignment.Center)
                                .clip(RoundedCornerShape(10.dp))
                                . background(Color.White.copy(alpha = 0.1f))
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth(animatedProgress)
                                . height(20.dp)
                                .align(Alignment.CenterStart)
                                .clip(RoundedCornerShape(10.dp))
                                . background(
                                    brush = Brush. horizontalGradient(
                                        colors = listOf(accentColor, secondaryColor)
                                    )
                                )
                        )

                        Box(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color.Black.copy(alpha = 0.4f))
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "${(animatedProgress * 100).toInt()}%",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Rewards section
                RewardsRow(
                    challengeId = challengeId,
                    progress = progress,
                    accentColor = accentColor,
                    claimed30 = claimed30,
                    claimed60 = claimed60,
                    claimed100 = claimed100,
                    finalRewardDrawable = finalRewardDrawable,
                    finalRewardName = finalRewardName,
                    ds = ds,
                    scope = scope,
                    onPreviewReward = { data ->
                        previewRewardData = data
                        showRewardPreview = true
                    }
                )
            }
        }
    }

    if (showRewardPreview && previewRewardData != null) {
        RewardPreviewDialog(
            data = previewRewardData!! ,
            onDismiss = { showRewardPreview = false }
        )
    }
}

// ==================== REWARDS ROW ====================

@Composable
private fun RewardsRow(
    challengeId: Int,
    progress: Float,
    accentColor: Color,
    claimed30: Boolean,
    claimed60: Boolean,
    claimed100: Boolean,
    finalRewardDrawable: Int,
    finalRewardName: String,
    ds:  DataStoreManager,
    scope: kotlinx.coroutines.CoroutineScope,
    onPreviewReward: (RewardPreviewData) -> Unit
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "🎁", fontSize = 14.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Rewards",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White. copy(alpha = 0.8f)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier. fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RewardItem(
                percentage = 30,
                isClaimed = claimed30,
                canClaim = ! claimed30 && progress >= 0.30f,
                isLocked = progress < 0.30f,
                rewardIcon = R.drawable.coin,
                rewardText = "300",
                accentColor = accentColor,
                onClaim = { scope.launch { ds.claimChallengeReward(challengeId, 30) } },
                onPreview = {
                    onPreviewReward(RewardPreviewData(R.drawable.coin, "30% Reward", "300 Coins", 30, false))
                }
            )

            RewardConnector(isCompleted = progress >= 0.30f, accentColor = accentColor)

            RewardItem(
                percentage = 60,
                isClaimed = claimed60,
                canClaim = !claimed60 && progress >= 0.60f,
                isLocked = progress < 0.60f,
                rewardIcon = R.drawable. coin,
                rewardText = "700",
                accentColor = accentColor,
                onClaim = { scope.launch { ds. claimChallengeReward(challengeId, 60) } },
                onPreview = {
                    onPreviewReward(RewardPreviewData(R.drawable.coin, "60% Reward", "700 Coins", 60, false))
                }
            )

            RewardConnector(isCompleted = progress >= 0.60f, accentColor = accentColor)

            FinalRewardItem(
                isClaimed = claimed100,
                canClaim = !claimed100 && progress >= 1.0f,
                isLocked = progress < 1.0f,
                rewardDrawable = finalRewardDrawable,
                accentColor = accentColor,
                onClaim = { scope. launch { ds.claimChallengeReward(challengeId, 100) } },
                onPreview = {
                    onPreviewReward(RewardPreviewData(finalRewardDrawable, "🏆 Final Reward", finalRewardName, 100, true))
                }
            )
        }
    }
}

// ==================== REWARD ITEM ====================

@Composable
private fun RewardItem(
    percentage: Int,
    isClaimed: Boolean,
    canClaim: Boolean,
    isLocked: Boolean,
    rewardIcon: Int,
    rewardText: String,
    accentColor: Color,
    onClaim: () -> Unit,
    onPreview: () -> Unit
) {
    val scale by animateFloatAsState(
        targetValue = if (canClaim) 1.1f else 1f,
        animationSpec = spring(dampingRatio = 0.6f),
        label = "rewardScale"
    )

    val infiniteTransition = rememberInfiniteTransition(label = "rewardPulse")
    val pulseAlpha by infiniteTransition. animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = EaseInOutSine),
            repeatMode = RepeatMode. Reverse
        ),
        label = "pulse"
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "$percentage%",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = when {
                isClaimed -> Color(0xFF4CAF50)
                canClaim -> accentColor
                else -> Color. White. copy(alpha = 0.4f)
            }
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .size(52.dp)
                .scale(scale)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    when {
                        isClaimed -> Color(0xFF4CAF50).copy(alpha = 0.2f)
                        canClaim -> accentColor. copy(alpha = pulseAlpha * 0.3f)
                        else -> Color.White.copy(alpha = 0.05f)
                    }
                )
                .border(
                    width = 2.dp,
                    color = when {
                        isClaimed -> Color(0xFF4CAF50)
                        canClaim -> accentColor. copy(alpha = pulseAlpha)
                        else -> Color.White.copy(alpha = 0.2f)
                    },
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable { if (canClaim) onClaim() else onPreview() },
            contentAlignment = Alignment. Center
        ) {
            if (isClaimed) {
                Text(text = "✓", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4CAF50))
            } else {
                Column(horizontalAlignment = Alignment. CenterHorizontally) {
                    Image(
                        painter = painterResource(id = rewardIcon),
                        contentDescription = null,
                        modifier = Modifier. size(24.dp).alpha(if (isLocked) 0.4f else 1f)
                    )
                    Text(
                        text = rewardText,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isLocked) Color.White. copy(alpha = 0.4f) else Color(0xFFFFD700)
                    )
                }

                if (isLocked) {
                    Box(
                        modifier = Modifier. fillMaxSize().background(Color.Black.copy(alpha = 0.3f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🔒", fontSize = 16.sp, modifier = Modifier.alpha(0.8f))
                    }
                }
            }
        }

        if (canClaim) {
            Spacer(modifier = Modifier. height(4.dp))
            Text(
                text = "TAP! ",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = accentColor,
                modifier = Modifier.alpha(pulseAlpha)
            )
        }
    }
}

// ==================== FINAL REWARD ITEM ====================

@Composable
private fun FinalRewardItem(
    isClaimed: Boolean,
    canClaim: Boolean,
    isLocked: Boolean,
    rewardDrawable: Int,
    accentColor: Color,
    onClaim: () -> Unit,
    onPreview: () -> Unit
) {
    val scale by animateFloatAsState(
        targetValue = if (canClaim) 1.15f else 1f,
        animationSpec = spring(dampingRatio = 0.5f),
        label = "finalScale"
    )

    val infiniteTransition = rememberInfiniteTransition(label = "finalPulse")
    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glow"
    )

    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = -2f,
        targetValue = 2f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = EaseInOutSine),
            repeatMode = RepeatMode.Reverse
        ),
        label = "rotation"
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "🏆", fontSize = 12.sp)
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = "100%",
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = when {
                    isClaimed -> Color(0xFF4CAF50)
                    canClaim -> Color(0xFFFFD700)
                    else -> Color.White.copy(alpha = 0.4f)
                }
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .size(64.dp)
                .scale(scale)
                .then(if (canClaim) Modifier.offset(x = rotationAngle. dp) else Modifier)
                .clip(RoundedCornerShape(14.dp))
                .background(
                    brush = when {
                        isClaimed -> Brush.linearGradient(listOf(Color(0xFF4CAF50), Color(0xFF81C784)))
                        canClaim -> Brush.linearGradient(
                            listOf(Color(0xFFFFD700).copy(alpha = glowAlpha), accentColor.copy(alpha = glowAlpha))
                        )
                        else -> Brush.linearGradient(
                            listOf(Color. White.copy(alpha = 0.1f), Color.White.copy(alpha = 0.05f))
                        )
                    }
                )
                .border(
                    width = 3.dp,
                    brush = when {
                        isClaimed -> Brush.linearGradient(listOf(Color(0xFF4CAF50), Color(0xFF81C784)))
                        canClaim -> Brush. linearGradient(listOf(Color(0xFFFFD700), accentColor))
                        else -> Brush.linearGradient(
                            listOf(Color.White.copy(alpha = 0.3f), Color.White.copy(alpha = 0.1f))
                        )
                    },
                    shape = RoundedCornerShape(14.dp)
                )
                .clickable { if (canClaim) onClaim() else onPreview() },
            contentAlignment = Alignment.Center
        ) {
            if (isClaimed) {
                Text(text = "✓", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color. White)
            } else {
                Image(
                    painter = painterResource(id = rewardDrawable),
                    contentDescription = null,
                    modifier = Modifier.size(44.dp).clip(RoundedCornerShape(8.dp)).alpha(if (isLocked) 0.4f else 1f)
                )

                if (isLocked) {
                    Box(
                        modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.4f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🔒", fontSize = 20.sp)
                    }
                }
            }
        }

        if (canClaim) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "CLAIM! ",
                fontSize = 10.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFFFD700),
                modifier = Modifier.alpha(glowAlpha)
            )
        }
    }
}

// ==================== REWARD CONNECTOR ====================

@Composable
private fun RewardConnector(isCompleted: Boolean, accentColor: Color) {
    Box(
        modifier = Modifier
            .width(24.dp)
            .height(3.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(if (isCompleted) accentColor else Color.White.copy(alpha = 0.2f))
    )
}

// ==================== DATA CLASS ====================

private data class RewardPreviewData(
    val drawableRes: Int,
    val title: String,
    val description: String,
    val percentageRequired: Int,
    val isFinalReward: Boolean
)

// ==================== REWARD PREVIEW DIALOG ====================

@Composable
private fun RewardPreviewDialog(
    data: RewardPreviewData,
    onDismiss:  () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = Color(0xFF1A1A2E),
        shape = RoundedCornerShape(24.dp),
        title = {
            Column(
                modifier = Modifier. fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = if (data.isFinalReward) "🏆" else "🎁", fontSize = 40.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = data.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (data.isFinalReward) Color(0xFFFFD700) else Color.White
                )
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val imageSize = if (data.isFinalReward) 140.dp else 80.dp

                Box(
                    modifier = Modifier
                        .size(imageSize + 20.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    if (data.isFinalReward) Color(0xFFFFD700).copy(alpha = 0.2f)
                                    else Color(0xFFFF6D00).copy(alpha = 0.2f),
                                    Color. Transparent
                                )
                            )
                        )
                        .border(
                            width = 2.dp,
                            brush = Brush.linearGradient(
                                colors = if (data.isFinalReward) listOf(Color(0xFFFFD700), Color(0xFFFF6D00))
                                else listOf(Color(0xFFFF6D00), Color(0xFFFFD700))
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = data. drawableRes),
                        contentDescription = null,
                        modifier = Modifier.size(imageSize).clip(RoundedCornerShape(12.dp))
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = data.description,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color. White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0F0F1A).copy(alpha = 0.8f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "🎯", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Reach ${data.percentageRequired}% to claim",
                            fontSize = 13.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6D00))
            ) {
                Text(text = "OK", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    )
}