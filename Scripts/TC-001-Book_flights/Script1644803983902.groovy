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
	username,
	password,
	phone,
	first_name,
	last_name
	)

//WebUI.navigateToUrl('https://www.phptravels.net/login')

//CustomKeywords.'phptravels.login.loginWithGlobalVariable'()
CustomKeywords.'phptravels.login.loginIntoApp'(
	'https://www.phptravels.net/login',
	username,
	password,
)


WebUI.maximizeWindow()
CustomKeywords.'phptravels.booking.searchTicketWithGlobalVariable'(
	amount_adult,
	amount_child,
	amount_infant)

WebUI.click(findTestObject('Object Repository/Page_Flights/button_Book'))
WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_Buyer_nationality'),
		'ID', true)

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

WebUI.scrollToElement(findTestObject('Page_Flight Booking/select_year_of_pasport_exp'), 0)

WebUI.click(findTestObject('Object Repository/Page_Flight Booking/input_pay later_payment_gateway'))
WebUI.click(findTestObject('Page_Flight Booking/input_payment_gateway_paypal'))

WebUI.scrollToElement(findTestObject('Page_Flight Booking/input_payment_gateway_paypal'), 0)
WebUI.click(findTestObject('Page_Flight Booking/label_agreement'))
WebUI.click(findTestObject('Page_Flight Booking/button_Confirm_Booking'))

CustomKeywords.'phptravels.booking.checkoutTicket'()
WebUI.navigateToUrl("https://www.phptravels.net/account/dashboard")
CustomKeywords.'phptravels.login.logout'()
