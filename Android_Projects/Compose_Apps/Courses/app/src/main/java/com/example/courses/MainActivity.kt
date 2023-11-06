package com.example.courses

import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courses.data.Datasource
import com.example.courses.model.CourseInfo
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			CoursesTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					CourseApp()
				}
			}
		}
	}
}

@Composable
fun CourseApp(modifier: Modifier = Modifier) {
	CourseList(courseList = Datasource().loadCourses())
}

@Composable
fun CourseCards(courseInfo: CourseInfo, modifier: Modifier= Modifier) {
	Card(
		modifier = modifier
			.height(100.dp)
//			.wrapContentSize()
	){
		Row(
			modifier = Modifier
//				.wrapContentSize()
		) {
			Image(
				painter = painterResource(id = courseInfo.courseImage),
				contentDescription = stringResource(id = courseInfo.courseName
				),
				modifier = Modifier
					.wrapContentSize()
					.size(68.dp, 100.dp)
			)
			Column(
				modifier = modifier
					.align(Alignment.Top)
					.fillMaxWidth(1f)
//					.wrapContentSize()
			) {
				Text(
					text = stringResource(id = courseInfo.courseName),
					modifier = modifier
//						.padding(start = 16.dp, top = 16.dp, end = 16.dp)
				)
				Row(
					horizontalArrangement = Arrangement.Start,
					modifier = modifier
//						.padding(top = 8.dp)
				) {
					Image(
						painter = painterResource(R.drawable.ic_grain), contentDescription = null,
						modifier = modifier
//							.padding(start = 16.dp)
					)
					Text(
						fontSize = 12.sp,
						text = stringResource(id = courseInfo.courseCount),
						modifier = modifier
//							.padding(start = 8.dp)
					)
				}
			}
		}
	}
}

@Composable
fun CourseList(courseList: List<CourseInfo>, modifier: Modifier = Modifier){
	LazyVerticalGrid(columns = GridCells.Fixed(2)){
		items(courseList){ courseInfo ->
			CourseCards(
				courseInfo = courseInfo,
				modifier = modifier
					.padding(8.dp)
				
			)
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CourseAppPreview() {
	CoursesTheme {
		CourseApp()
	}
}