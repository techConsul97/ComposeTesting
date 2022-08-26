package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {
 private var allScreens: List<RallyScreen>? = null

    @get:Rule

    val composeTestRule = createComposeRule()


    @Before
    fun setup() {
        //Create dummy data for 'allScreens'
        allScreens = RallyScreen.values().toList()
    }

    @After
    fun tearDown() {
        allScreens = null
    }


    @Test
    fun testRallyTopAppBar_hasContentDescriptionCorrect() {


        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens!!,
                onTabSelected = {},
                currentScreen = RallyScreen.Accounts
            )
        }
        composeTestRule.onNodeWithContentDescription(RallyScreen.Accounts.name).assertIsSelected()
    }




        @Test
        fun rallyTopAppBarTest_currentLabelExists() {

            composeTestRule.setContent {
                RallyTopAppBar(
                    allScreens = allScreens!!,
                    onTabSelected = { },
                    currentScreen = RallyScreen.Accounts
                )
            }

            //Used to check the "semantic tree"
            composeTestRule.onRoot().printToLog("currentLabelExists")

            composeTestRule
                .onNodeWithContentDescription(RallyScreen.Accounts.name)
                .assertExists()
        }

    @Test
    fun rallyTopAppBarTest_currentTabHasCorrectText(){
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens!!,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        //Used to check the "semantic tree"
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

        composeTestRule.onNode(
            hasText(RallyScreen.Accounts.name.uppercase()) and
                    hasParent(hasContentDescription(RallyScreen.Accounts.name)),
            useUnmergedTree = true

        ).assertExists()

    }

    @Test
    fun rallyTopAppBarTest_performClicks_checkStateChanges() {
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens!!,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        //Method
//        composeTestRule.onNodeWithContentDescription("Bills").assertIsDisplayed().
//        performClick()
//        Thread.sleep(5000)
//
//        composeTestRule.onNode(isSelected()).assertContentDescriptionEquals(RallyScreen.Bills.name)
//        composeTestRule.onNode(isSelected()).printToLog("dada")


        //Method

        //composeTestRule.onNodeWithContentDescription("Bills").performClick().assertIsSelected()


        //Method

       // composeTestRule.onNodeWithContentDescription("Bills").performClick().printToLog("method")







    }


}