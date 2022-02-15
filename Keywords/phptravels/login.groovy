package phptravels

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class login {
	@Keyword
	def static void loginIntoApp(String url, String username, String password) {
		WebUI.navigateToUrl(url)
		WebUI.waitForPageLoad(10)
		WebUI.maximizeWindow()

		WebUI.setText(findTestObject('Page_Login/input_Email'), username)
		WebUI.setText(findTestObject('Page_Login/input_Password'), password)

		WebUI.click(findTestObject('Object Repository/Page_Login/button_Login'))
	}

	@Keyword
	def static void loginWithGlobalVariable() {
		WebUI.waitForElementPresent(findTestObject('Page_Login/input_Email'), GlobalVariable.presentTimeout)
		WebUI.setText(findTestObject('Page_Login/input_Email'), GlobalVariable.c_username)
		WebUI.setText(findTestObject('Page_Login/input_Password'), GlobalVariable.c_password)

		WebUI.click(findTestObject('Object Repository/Page_Login/button_Login'))
	}

	@Keyword
	def static void signup(
			String url,
			String username,
			String password,
			String phone,
			String firstname,
			String lastname) {
		WebUI.navigateToUrl(url)
		WebUI.waitForPageLoad(GlobalVariable.presentTimeout)
		WebUI.maximizeWindow()

		WebUI.setText(findTestObject('Page_Signup/input_First_Name'), firstname)
		WebUI.setText(findTestObject('Page_Signup/input_last_name'), lastname)
		WebUI.setText(findTestObject('Page_Signup/input_phone'), phone)
		WebUI.setText(findTestObject('Page_Signup/input_Email'), username)
		WebUI.setText(findTestObject('Page_Signup/input_password'), password )
		WebUI.click(findTestObject('Page_Signup/select_Customer'))
		WebUI.scrollToElement(findTestObject('Page_Signup/input_Email'), 0)

		WebUI.click(findTestObject('Page_Signup/button_Signup'))
	}

	@Keyword
	def static void signupWithGlobalVariable() {
		WebUI.maximizeWindow()
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Signup/input_first_name'), GlobalVariable.presentTimeout)
		WebUI.setText(findTestObject('Page_Signup/input_First_Name'), GlobalVariable.c_firstname)
		WebUI.setText(findTestObject('Page_Signup/input_last_name'), GlobalVariable.c_lastname)
		WebUI.setText(findTestObject('Page_Signup/input_phone'), GlobalVariable.c_phone)
		WebUI.setText(findTestObject('Page_Signup/input_Email'), GlobalVariable.c_username)
		WebUI.setText(findTestObject('Page_Signup/input_password'), GlobalVariable.c_password )
		WebUI.click(findTestObject('Page_Signup/select_Customer'))

		WebUI.scrollToElement(findTestObject('Page_Signup/input_Email'), 0)
		WebUI.click(findTestObject('Page_Signup/button_Signup'))
	}

	@Keyword
	def static void logout() {
		WebUI.navigateToUrl("https://www.phptravels.net/account/dashboard")
		WebUI.waitForPageLoad(GlobalVariable.presentTimeout)
		WebUI.click(findTestObject('Object Repository/Page_Dashboard/button_Logout'))
	}
}
