package com.compose.msg.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.compose.domain.entity.ListCommentsEntity
import com.compose.domain.entity.ListDetailEntity
import com.compose.msg.ui.theme.MSGTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListDetailActivity : ComponentActivity() {

    private val viewModel by viewModels<ListDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MSGTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val id = intent.getIntExtra("id", 1)

                    viewModel.getDetail(id)
                    viewModel.getComments(id)

                    val detailListState = viewModel.detailList.collectAsState()
                    val detailList = detailListState.value

                    val commentListState = viewModel.commentList.collectAsState()
                    val commentList = commentListState.value

                    ListDetailScreen(detailList, commentList)
                }
            }
        }
    }

    @Composable
    fun ListDetailScreen(detailList: ListDetailEntity?, commentList: List<ListCommentsEntity?>) {
        Column {
            if (detailList != null) {
                WritingDetailList(detailList)
            }

            Spacer(modifier = Modifier.size(16.dp))

            if (commentList.isNotEmpty()) {
                WritingCommentsList(commentList.filterNotNull())
            }
        }
    }

    @Composable
    fun WritingDetailList(writeDetail: ListDetailEntity) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(MaterialTheme.shapes.large)
                .clickable {},
            shape = MaterialTheme.shapes.large
        ) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = writeDetail.title)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = writeDetail.body)
            }
        }
    }

    @Composable
    fun WritingCommentsList(commentsList: List<ListCommentsEntity>) {
        Text(
            text = "comment",
            modifier = Modifier.padding(start = 8.dp)
        )
        LazyColumn {
            items(commentsList) { list ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(MaterialTheme.shapes.large),
                    shape = MaterialTheme.shapes.large
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = list.name)
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(text = list.body)
                    }
                }
            }
        }
    }
}