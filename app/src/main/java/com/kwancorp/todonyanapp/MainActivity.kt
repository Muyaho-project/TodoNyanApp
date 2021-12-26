package com.kwancorp.todonyanapp

import android.os.Bundle
import android.service.autofill.UserData
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.kwancorp.todonyanapp.ui.*
import com.kwancorp.todonyanapp.ui.theme.TodoNyanAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoNyanAppTheme {
                TodoNyanApp()
            }
        }
    }
}

@Composable
fun TodoNyanApp() {
    TodoNyanAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            val allScreens = TodoScreen.values().toList()
            val navController = rememberNavController()
            val backstackEntry = navController.currentBackStackEntryAsState()
            var currentScreen = TodoScreen.fromRoute (
                backstackEntry.value?.destination?.route
            )
            Scaffold(
                topBar = {
                    TodoTabRow(
                        allScreens = allScreens,
                        onTabSelected = { screen ->
                            navController.navigate(screen.name)
                        },
                        currentScreen = currentScreen,
                    )
                }
            ) { innerPadding ->
                TodoNavHost(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
fun TodoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = TodoScreen.Home.name,
        modifier = modifier
    ) {
        composable(TodoScreen.Home.name) {
            HomeBody()
        }
        composable(TodoScreen.Cat.name) {
            CatBody()
        }
        composable(TodoScreen.My.name) {
            MyBody()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoNyanApp()
}