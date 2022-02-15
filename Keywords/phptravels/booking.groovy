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
import com.kms.katalon.core.logging.KeywordLogger
import internal.GlobalVariable

public class booking {
	@Keyword
	def static void searchTicket(
			String url,
			String departure,
			String destination,
			String date_departure,
			String f_class,
			int amount_adult = 1,
			int amount_child = 0,
			int amount_infant = 0
	) {
		WebUI.click(findTestObject('Object Repository/Page_Search_Flights/input_one-way'))
		WebUI.setText(findTestObject('Object Repository/Page_Search_Flights/input_Flying_From'), departure)
		WebUI.setText(findTestObject('Object Repository/Page_Search_Flights/input_To_Destination'), destination)
		WebUI.setText(findTestObject('Object Repository/Page_Search_Flights/input_Departure Date_depart'), date_departure)
		WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_passengers'))

		if(amount_adult > 1) {
			for (int i = 1; i < amount_adult; i++) {
				WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_plusAdult'))
			}
			WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_minAdult'))
		}

		if(amount_child > 0) {
			for (int i = 0; i < amount_child+1; i++) {
				WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_plusChild'))
			}
			WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_minChild'))
		}

		if(amount_infant > 0) {
			for (int i = 0; i < amount_infant+1; i++) {
				WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_plusInfant'))
			}
			WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_minInfant'))
		}

		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Search_Flights/select_class'), f_class, true)
		WebUI.click(findTestObject('Page_Search_Flights/button_Search'))
	}

	@Keyword
	def static void searchTicketWithGlobalVariable(
			int amount_adult = 1,
			int amount_child = 0,
			int amount_infant = 0
	) {
		WebUI.navigateToUrl('https://www.phptravels.net/flights')
		WebUI.waitForPageLoad(GlobalVariable.presentTimeout)

		WebUI.click(findTestObject('Object Repository/Page_Search_Flights/input_one-way'))
		WebUI.setText(findTestObject('Object Repository/Page_Search_Flights/input_Flying_From'), GlobalVariable.departure)
		WebUI.setText(findTestObject('Object Repository/Page_Search_Flights/input_To_Destination'), GlobalVariable.destination)
		WebUI.setText(findTestObject('Object Repository/Page_Search_Flights/input_Departure Date_depart'), GlobalVariable.date_departure)
		WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_passengers'))

		if(amount_adult > 1) {
			for (int i = 1; i < amount_adult; i++) {
				WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_plusAdult'))
			}
			WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_minAdult'))
		}

		if(amount_child > 0) {
			for (int i = 0; i < amount_child+1; i++) {
				WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_plusChild'))
			}
			WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_minChild'))
		}

		if(amount_infant > 0) {
			for (int i = 0; i < amount_infant+1; i++) {
				WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_plusInfant'))
			}
			WebUI.click(findTestObject('Object Repository/Page_Search_Flights/button_minInfant'))
		}

		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Search_Flights/select_class'), GlobalVariable.f_class, true)
		WebUI.click(findTestObject('Page_Search_Flights/button_Search'))
	}

	@Keyword
	def static void bookTicket(int buyer_nationality) {
		WebUI.click(findTestObject('Object Repository/Page_Flights/button_Book'))
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_Buyer_nationality'),
				'ID', true)
	}

	@Keyword
	def static void fillForm_n(
			int i,
			String first_name,
			String last_name,
			String traveller_nationality,
			String month_of_birth,
			String day_of_birth,
			String year_of_birth,
			String passport_number,
			String month_of_passport_iss,
			String day_of_passport_iss,
			String year_of_passport_iss,
			String month_of_passport_exp,
			String day_of_passport_exp,
			String year_of_pasport_exp) {

		WebUI.setText(findTestObject('Page_Flight Booking/input_Traveler_First_Name'),
				first_name)

		WebUI.setText(findTestObject('Page_Flight Booking/input_Traveler_First_Name'),
				first_name)

		WebUI.setText(findTestObject('Page_Flight Booking/input_Traveler_Last_Name'),
				last_name)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_Traveller_nationality'),
				traveller_nationality,true)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_month_of_birth'),
				month_of_birth,true)

		WebUI.setText(findTestObject('Page_Flight Booking/input_day_of_birth'),
				day_of_birth)

		WebUI.setText(findTestObject('Page_Flight Booking/input_year_of_birth'),
				year_of_birth)

		WebUI.setText(findTestObject('Page_Flight Booking/input_Passport_number'),
				passport_number)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_month_of_passport_iss'),
				month_of_passport_iss,true)

		WebUI.setText(findTestObject('Page_Flight Booking/input_day_of_passport_iss'),
				day_of_passport_iss)

		WebUI.setText(findTestObject('Page_Flight Booking/input_year_of_passport_iss'),
				year_of_passport_iss)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_month_of_passport_exp'),
				month_of_passport_exp,true)

		WebUI.setText(findTestObject('Page_Flight Booking/input_day_of_passport_exp'),
				day_of_passport_exp)

		WebUI.setText(findTestObject('Page_Flight Booking/input_year_of_pasport_exp'),
				year_of_pasport_exp)
	}

	@Keyword
	def static void fillForm_1(
			String first_name,
			String last_name,
			String traveller_nationality,
			String month_of_birth,
			String day_of_birth,
			String year_of_birth,
			String passport_number,
			String month_of_passport_iss,
			String day_of_passport_iss,
			String year_of_passport_iss,
			String month_of_passport_exp,
			String day_of_passport_exp,
			String year_of_pasport_exp) {

		WebUI.setText(findTestObject('Page_Flight Booking/input_Traveler_First_Name'),
				first_name)

		WebUI.setText(findTestObject('Page_Flight Booking/input_Traveler_Last_Name'),
				last_name)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_Traveller_nationality'),
				traveller_nationality,true)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_month_of_birth'),
				month_of_birth,true)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_day_of_birth'),
				day_of_birth,true)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_year_of_birth'),
				year_of_birth,true)

		WebUI.setText(findTestObject('Page_Flight Booking/input_Passport_number'),
				passport_number)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_month_of_passport_iss'),
				month_of_passport_iss,true)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_day_of_passport_iss'),
				day_of_passport_iss,true)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_year_of_passport_iss'),
				year_of_passport_iss,true)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_month_of_passport_exp'),
				month_of_passport_exp,true)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_day_of_passport_exp'),
				day_of_passport_exp,true)

		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_year_of_pasport_exp'),
				year_of_pasport_exp,true)
	}

	@Keyword
	def static void bookTicketWithGlobalVariable() {
		WebUI.click(findTestObject('Object Repository/Page_Flights/button_Book'))
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_Buyer_nationality'),
				'ID', true)
		WebUI.setText(findTestObject('Page_Flight Booking/input_Traveler_First_Name'),
				'udin')
		WebUI.setText(findTestObject('Page_Flight Booking/input_Traveler_Last_Name'),
				'alaudin')
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_Traveller_nationality'),
				'ID', true)
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_month_of_birth'),
				'01', true)
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_day_of_birth'),
				'1', true)
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_year_of_birth'),
				'2001', true)
		WebUI.setText(findTestObject('Page_Flight Booking/input_Passport_number'),
				'123190123')
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_month_of_passport_iss'),
				'01', true)
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_day_of_passport_iss'),
				'23', true)
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_year_of_passport_iss'),
				'2021', true)
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_month_of_passport_exp'),
				'01', true)
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_day_of_passport_exp'),
				'23', true)
		WebUI.selectOptionByValue(findTestObject('Page_Flight Booking/select_year_of_pasport_exp'),
				'2025', true)

		WebUI.scrollToElement(findTestObject('Page_Flight Booking/select_year_of_pasport_exp'), 0)
		WebUI.click(findTestObject('Page_Flight Booking/input_payment_gateway_paypal'))

		WebUI.scrollToElement(findTestObject('Page_Flight Booking/input_payment_gateway_paypal'), 0)
		WebUI.click(findTestObject('Page_Flight Booking/label_agreement'))
		WebUI.click(findTestObject('Page_Flight Booking/button_Confirm_Booking'))
	}

	@Keyword
	def static void checkoutTicket() {
		WebUI.selectOptionByValue(findTestObject('Page_Flight Invoice/select_payment_gateway'),
				'wallet-balance', true)
		WebUI.click(findTestObject('Page_Flight Invoice/input_Payment_button'))
		WebUI.click(findTestObject('Object Repository/Page_Payment with wallet balance/button_Payment_button'))

		if(WebUI.verifyElementText(findTestObject('Object Repository/Page_Flight Invoice/strong_Confirmed'), "Confirmed")) {
			WebUI.comment("payment gateway is OK")
		} else {
			WebUI.comment("Something Wrong with payment gateway")
		}
		
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Flight Invoice/button_Download Invoice'),0)
		WebUI.click(findTestObject('Object Repository/Page_Flight Invoice/button_Download Invoice'))
	}
}
