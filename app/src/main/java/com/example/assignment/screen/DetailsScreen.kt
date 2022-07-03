package com.example.assignment.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.assignment.model.Items
import com.example.assignment.viewmodel.UserViewModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun DetailsScreen(navController: NavHostController,viewModel: UserViewModel = hiltViewModel()) {


    val data = navController.previousBackStackEntry
        ?.arguments?.getParcelable<Items>("info")

var date:String?=""

    try {

         date = SimpleDateFormat("dd/MM/yyyy").parse(data?.updatedAt).toString()
      //  date = format.parse(data?.updatedAt).toString()

    } catch (e: ParseException) {
        e.printStackTrace()
    }




    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = rememberAsyncImagePainter(data?.owner?.avatarUrl),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Text(
                text = data?.fullName.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = " ${data?.description}",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = " ${data?.gitUrl}",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = date.toString(),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun String?.dateChangeTo(inputType: String, outputType: String): String {
        val finalDate: String?
        val input = SimpleDateFormat(inputType, Locale.UK)
        val output = SimpleDateFormat(outputType, Locale.UK)

        finalDate = try {
            val inputDate = input.parse(this) // parse input
            output.format(inputDate)
        } catch (e: Exception) {
            ""
        }
        return finalDate ?: ""
    }

}