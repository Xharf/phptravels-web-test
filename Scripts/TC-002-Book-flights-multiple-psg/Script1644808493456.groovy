import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser("")

CustomKeywords.'phptravels.login.signup'(
	'https://phptravels.net/signup',
	GlobalVariable.c_username,
	GlobalVariable.c_password,
	GlobalVariable.c_phone,
	GlobalVariable.c_firstname,
	GlobalVariable.c_lastname
	)

WebUI.navigateToUrl('https://www.phptravels.net/login')
CustomKeywords.'phptravels.login.loginWithGlobalVariable'()

WebUI.maximizeWindow()
CustomKeywords.'phptravels.booking.searchTicketWithGlobalVariable'(
	amount_adult,
	amount_child,
	amount_infant)

WebUI.click(findTestObject('Object Repository/Page_Flights/button_Book'))
WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_Buyer_nationality'),
		'ID', true)

int count = 1; // id

CustomKeywords.'phptravels.booking.fillForm_1'(
	first_name,
	last_name,
	traveller_nationality,
	month_of_birth,
	day_of_birth,
	year_of_birth,
	passport_number,
	month_of_passport_iss,
	day_of_passport_iss,
	year_of_passport_iss,
	month_of_passport_exp,
	day_of_passport_exp,
	year_of_pasport_exp)
count++

if((amount_adult+amount_child+amount_infant) > 1) {
	for (int i = 1; i < amount_adult+amount_child+amount_infant; i++) {
		CustomKeywords.'phptravels.booking.fillForm_n'(
			count,
			first_name,
			last_name,
			traveller_nationality,
			month_of_birth,
			day_of_birth,
			year_of_birth,
			passport_number,
			month_of_passport_iss,
			day_of_passport_iss,
			year_of_passport_iss,
			month_of_passport_exp,
			day_of_passport_exp,
			year_of_pasport_exp)
		count++
	}
}

//		
//CustomKeywords.'phptravels.booking.bookTicketWithGlobalVariable'()
//CustomKeywords.'phptravels.booking.checkoutTicket'()
//WebUI.navigateToUrl("https://www.phptravels.net/account/dashboard")
//CustomKeywords.'phptravels.login.logout'()
