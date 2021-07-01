package com.example.instagramclone

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(4.dp))
        TopBar(
            name = "Vishesh", modifier = Modifier
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighLightSection(
            highlight = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.android),
                    text="Android"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.azure),
                    text="Azure"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.figma),
                    text="Figma"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.tensorflow),
                    text="Tensor"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(imageWithTexts =
            listOf(
                ImageWithText(
                    painterResource(id = R.drawable.grid),
                    text = "Grid"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.movie),
                    text = "Movie"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.tv),
                    text = "TV"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.shop),
                    text = "Shop"
                )
            )
        ) {
            selectedIndex = it
        }
        when(selectedIndex){
            0-> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.artificals),
                    painterResource(id = R.drawable.development),
                    painterResource(id = R.drawable.fullstack),
                    painterResource(id = R.drawable.droids),
                    painterResource(id = R.drawable.coder),
                    painterResource(id = R.drawable.developer),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.yellowishbg), modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatsSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "Programming Enthusiast",
            description = "Second year computer Science student 💻. Wearing three 🎩 as " +
                    "a full stack developer, UI/UX Designer & Machine Learning Enthusiast",
            url = "https://vishesht27.github.io/#/",
            followedby = listOf("Late_Coder","Ruke"),
            otherCount = 14
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatsSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "12", text = "Posts")
        ProfileStat(numberText = "567", text = "Followers")
        ProfileStat(numberText = "371", text = "Following")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedby: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if(followedby.isNotEmpty()){
            Text(
                text =  buildAnnotatedString {
                    val boldStyle =SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    pushStyle(boldStyle)
                    followedby.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if(index<followedby.size-1) {
                            append(", ")
                        }
                    }
                    if(otherCount>2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth =95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButtons(
            text = "Following",
        icon = Icons.Default.KeyboardArrowDown,
        modifier = Modifier
            .defaultMinSize(minHeight = minWidth)
            .height(height)
        )
        ActionButtons(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minHeight = minWidth)
                .height(height)
        )
        ActionButtons(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minHeight = minWidth)
                .height(height)
        )
        ActionButtons(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )
    }
}

@Composable
fun ActionButtons(
    modifier: Modifier = Modifier,
    text: String?=null,
    icon : ImageVector ?=null
) {
     Row(
         horizontalArrangement = Arrangement.Center,
         verticalAlignment = Alignment.CenterVertically,
         modifier = Modifier
             .border(
                 width = 1.dp,
                 color = Color.LightGray,
                 shape = RoundedCornerShape(5.dp)
             )
             .padding(6.dp)
     ) {
         if(text!=null){
             Text(
                 text = text,
                 fontWeight = FontWeight.SemiBold,
                 fontSize = 14.sp
             )
         }
         if(icon!=null){
             Icon(
                 imageVector = icon,
                 contentDescription = null,
                 tint = Color.Black
             )
         }
     }
}

@Composable
fun HighLightSection(
    modifier: Modifier = Modifier,
    highlight: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlight.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ){
                RoundImage(
                    image = highlight[it].image,
                    modifier = Modifier.size(70.dp)
                    )
                Text(
                    text = highlight[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected:(selectedIndex:Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = Modifier
        )
    {
        imageWithTexts.forEachIndexed{index,item->
            Tab(
                selected = selectedTabIndex==index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex=index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription =item.text,
                    tint = if(selectedTabIndex==0) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
        
    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts : List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)

    ) {
        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}