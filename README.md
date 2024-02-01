# Cocktail App

Welcome to the Cocktail App! This Android app allows users to search for cocktails and view details about each cocktail.

## Features

- Search for cocktails based on user input.
- View a grid of search results with drink names and thumbnails.
- Tap on a row to see detailed information about a specific cocktail.
- Static UI elements like "Let's eat quality food" and "Near restaurant" are hardcoded.

## Screenshots
![App Demo](screenshot/cocktaildb.gif)

## Libraries Used
- Jetpack Compose
- Dagger Hilt
- Coil
- KTOR Client
- Kotlinx serialization

## App Structure
```bash
└───dev
    └───sohair
        └───cocktaildb
            │   TCDBApplication.kt
            │
            ├───data
            │   ├───local
            │   │       Drink.kt
            │   │
            │   └───remote
            │           DrinkDto.kt
            │           DrinkResultDto.kt
            │           DrinksApi.kt
            │           DrinksApiImpl.kt
            │
            ├───di
            │       AppModule.kt
            │
            ├───domain
            │       Constants.kt
            │       NetworkResult.kt
            │       Utils.kt
            │
            └───presentation
                │   MainActivity.kt
                │
                └───ui
                    ├───cocktail_detail
                    │       CocktailDetailsScreen.kt
                    │       CocktailDetailViewModel.kt
                    │
                    ├───common
                    │   │   Screen.kt
                    │   │
                    │   └───components
                    │           AppNavigation.kt
                    │
                    ├───home
                    │       DrinkItem.kt
                    │       HomeScreen.kt
                    │       HomeScreenUiState.kt
                    │       HomeScreenViewModel.kt
                    │       RowItem.kt
                    │
                    └───theme
                            Color.kt
                            Theme.kt
                            Type.kt

```