// guided by Android Basics codelab: Intro to state in Compose.
package com.sgu.kampusgo

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgu.kampusgo.ui.theme.KampusGoTheme

private val majors = listOf(
    "Informatics",
    "Information Systems",
    "Computer Engineering",
)
@Composable
fun LabeledField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    supportingText: String? = null,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        isError = isError,
        supportingText = {
            if (supportingText != null) Text(supportingText)
        },
        modifier = modifier.fillMaxWidth(),
    )
}

@Composable
fun ProfileForm(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var npm by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var major by remember { mutableStateOf(majors.first()) }
    var angkatan by remember { mutableStateOf("") }

    val emailError = email.isNotEmpty() && !email.contains("@")
    val valid = name.isNotBlank() && email.contains("@")
    val context = LocalContext.current

    Column(modifier = modifier) {
        Text("KampusGo")
        LabeledField(value = name, onValueChange = { name = it }, label = "Name")
        LabeledField(value = npm, onValueChange = { npm = it }, label = "NPM")
        LabeledField(value = email, onValueChange = { email = it }, label = "Email",
            isError = emailError, supportingText = if (emailError) {
                "Email needs @"
            } else {
                null
            }
        )

        Text("Major", modifier = Modifier.padding(top = 12.dp))
        majors.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = major == option, onClick = { major = option })
                Text(option)
            }
        }

        LabeledField(value = angkatan, onValueChange = { angkatan = it }, label = "Angkatan")

        Button(
            onClick = {
                Toast.makeText(context, "Saved ($major)", Toast.LENGTH_SHORT).show()
            },
            enabled = valid,
            modifier = Modifier.padding(top = 16.dp),
        ) {
            Text("Save")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileFormPreview() {
    KampusGoTheme {
        ProfileForm(modifier = Modifier.padding(24.dp))
    }
}