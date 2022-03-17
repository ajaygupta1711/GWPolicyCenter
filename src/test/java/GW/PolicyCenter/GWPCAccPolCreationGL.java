package GW.PolicyCenter;

import org.openqa.selenium.By;
//import org.apache.commons.io.FileUtils;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
// import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class GWPCAccPolCreationGL {

		public static void main(String[] args) throws InterruptedException, IOException {
		
		// Invoke the browser and open the link
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://pc-qa1-corecon.emc.dev-1.us-east-1.guidewire.net/PolicyCenter.do");
		
		// Maximize the browser window and wait for populating all web elements
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));
				
		// Enter the username & password and click on Login button
		 
		driver.findElement(By.name("Login-LoginScreen-LoginDV-username")).sendKeys("su");
		driver.findElement(By.name("Login-LoginScreen-LoginDV-password")).sendKeys("gw");
		driver.findElement(By.id("Login-LoginScreen-LoginDV-submit")).click();
		
// Account Creation		
		
		// Select the New Account option under Account toolbar
		
		driver.findElement(By.cssSelector("div[id='TabBar-AccountTab'] div[class='gw-icon gw-icon--expand']")).click();
		driver.findElement(By.xpath("//div[@id='TabBar-AccountTab-AccountTab_NewAccount']//div[text()='New Account']")).click();
		driver.findElement(By.name("NewAccount-NewAccountScreen-NewAccountSearchDV-GlobalContactNameInputSet-Name")).sendKeys("EMCACCOUNT010");  // EMCBIL969TEST
		driver.findElement(By.id("NewAccount-NewAccountScreen-NewAccountSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='NewAccount-NewAccountScreen-NewAccountButton']//div[text()='te New Account']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='NewAccount-NewAccountScreen-NewAccountButton-NewAccount_Company']//div[text()='Company']")).click();
		Thread.sleep(1000);
		
		// Enter/Select the value on mandatory fields on New Account screen 
		
		driver.findElement(By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-ApplicationReceivedDate_Ext")).sendKeys("02/05/2024");
		driver.findElement(By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-ClearanceDate_Ext")).sendKeys("02/05/2024");
		driver.findElement(By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-Nickname")).sendKeys("EMCACCOUNT010");
		
		driver.findElement(By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-AddressLine1")).sendKeys("1101 Hennepin Ave");
		driver.findElement(By.xpath("//div[@id='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-City']//input[@name='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-City']")).sendKeys("Minneapolis");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class='gw-vw--value'] [name='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-State']")).click();
		
		driver.findElement(By.xpath("//div[@id='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-City']//input[@name='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-City']")).sendKeys("Minneapolis");
		driver.findElement(By.cssSelector("[class='gw-vw--value'] [name='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-State']")).click();
		Thread.sleep(2000);
		WebElement selectStateDropdown = driver.findElement(By.xpath("//select[@name='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-State']"));
		Select dropdown = new Select(selectStateDropdown);
		Thread.sleep(2000);
		dropdown.selectByVisibleText("Minnesota"); 
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='CreateAccount-CreateAccountScreen-CreateAccountDV-AddressInputSet-globalAddressContainer-GlobalAddressInputSet-PostalCode']")).sendKeys("55403-1705");
		driver.findElement(By.xpath("//div[contains(text(), 'Verify Address')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-OfficialIDInputSet-OfficialIDDV_Input")).sendKeys("123456789");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"CreateAccount-CreateAccountScreen-CreateAccountDV-IndustryCode-SelectIndustryCode\"]/span")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"CreateAccount-CreateAccountScreen-CreateAccountDV-IndustryCode-SelectIndustryCode\"]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("IndustryCodeSearchPopup-IndustryCodeSearchScreen-IndustryCodeSearchDV-Code")).sendKeys("1629");
		driver.findElement(By.id("IndustryCodeSearchPopup-IndustryCodeSearchScreen-IndustryCodeSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(), 'Select')]")).click();
		
		
		WebElement selectNAICSCodeDropdown = driver.findElement(By.name("CreateAccount-CreateAccountScreen-CreateAccountDV-NAICSCode_Ext"));
		Select dropdown1 = new Select(selectNAICSCodeDropdown);
		Thread.sleep(2000);
		dropdown1.selectByVisibleText("236210 - Industrial Building Construction");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[name='CreateAccount-CreateAccountScreen-CreateAccountDV-ProducerSelectionInputSet-Producer']")).sendKeys("C0010");
		driver.findElement(By.cssSelector("*[id='CreateAccount-CreateAccountScreen-CreateAccountDV-ProducerSelectionInputSet-Producer-SelectOrganization'] span")).click();
		driver.findElement(By.xpath("//*[@id='CreateAccount-CreateAccountScreen-CreateAccountDV-ProducerSelectionInputSet-IndividualProducer_Ext-SelectIndividualProducer_Ext']/span")).click();
		driver.findElement(By.name("UserSearchPopup-UserSearchPopupScreen-UserSearchDV-Username")).sendKeys("c-00100065");
		Thread.sleep(1000);
		driver.findElement(By.id("UserSearchPopup-UserSearchPopupScreen-UserSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search")).click();
		
//		driver.findElement(By.id("UserSearchPopup-UserSearchPopupScreen-UserSearchResultsLV-2-DisplayName_button")).getText();
		driver.findElement(By.xpath("//*[@id='UserSearchPopup-UserSearchPopupScreen-UserSearchResultsLV-0-_Select']")).click();
		
		driver.findElement(By.xpath("//div[@class='gw-label']//div[contains(text(), 'U')]")).click();
		driver.findElement(By.cssSelector("div[id='DuplicateContactsPopup-__crumb__']")).click();
		driver.findElement(By.xpath("//div[@class='gw-label']//div[contains(text(), 'U')]")).click();

		Thread.sleep(10000);
		System.out.println("Account Number " + driver.findElement(By.cssSelector("div[id='AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile-AccountDetailsDetailViewTile_DV-1'] [id='AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile-AccountDetailsDetailViewTile_DV-AccountNumber']")).getText());
		System.out.println("Account Holder " + driver.findElement(By.cssSelector("div[id='AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile-AccountDetailsDetailViewTile_DV-AccountHolder_Input'] [id='AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile-AccountDetailsDetailViewTile_DV-AccountHolder']")).getText()); 

// Submission Creation			
		
		// Select action and click on new submission option
		
		driver.findElement(By.cssSelector("div[id='AccountFile-AccountFileMenuActions'] div[role='button']")).click();
		driver.findElement(By.xpath("//div[@id='AccountFile-AccountFileMenuActions-AccountFileMenuActions_Create-AccountFileMenuActions_NewSubmission']//div[contains(text(), 'New Su')]")).click();
		driver.findElement(By.cssSelector("div[id='NewSubmission-NewSubmissionScreen-ProductOffersDV-ProductSelectionLV-0-addSubmission']")).click();
		Thread.sleep(7000);
		// Enter/Select the value in mandatory fields on Policy Info Screen 
		
		WebElement selectPackModDropdown = driver.findElement(By.name("SubmissionWizard-LOBWizardStepGroup-SubmissionWizard_PolicyInfoScreen-SubmissionWizard_PolicyInfoDV-PolicyInfoInputSet-PackageModification_Ext"));
		Select dropdown2 = new Select(selectPackModDropdown);
		dropdown2.selectByVisibleText("Yes");
		WebElement selectRiskDropdown = driver.findElement(By.name("SubmissionWizard-LOBWizardStepGroup-SubmissionWizard_PolicyInfoScreen-SubmissionWizard_PolicyInfoDV-PolicyInfoInputSet-TypeOfRisk_Ext"));
		Select dropdown3 = new Select(selectRiskDropdown);
		dropdown3.selectByVisibleText("01 - Hotel");
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'Next')]")).click();
		Thread.sleep(5000);
		
		// Enter/Select the value in mandatory fields on Subline Selection Screen and navigate to the next page
		
		driver.findElement(By.cssSelector("input[name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GL7SublineSelectionScreen-GL7SublineSelectionDV-0-subline']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GL7SublineSelectionScreen-GL7SublineSelectionDV-0-Jurisdictions_button")).click();	
		driver.findElement(By.cssSelector("input[name='GL7SublineJurisdictionsPopup-21-_Checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'OK')]")).click();
		Thread.sleep(2000);
		
		// From Subline Selection Screen, navigate to the next page
		
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'Next')]")).click();
		Thread.sleep(4000);
		
		// From General Liability Screen, Select Extentions, Flat Charge fields and navigate to the next page
		
		WebElement extentions = driver.findElement(By.name("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GL7GeneralLiabilityCoveragesScreen-GL7GeneralLiabilitySublines_ExtCV-0-LobEntityDV-39-LobInputSet-LobInternalInputSet-Input"));
		Select dropdownextentions = new Select(extentions);
		dropdownextentions.selectByVisibleText("General Liability Elite Extension");
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("[name='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GL7GeneralLiabilityCoveragesScreen-GL7GeneralLiabilitySublines_ExtCV-0-LobClausesDV-3-LobCoverageInputSet-CovPatternInputGroup-1-CovTermInputSet-CovTermDirectInputSet-DirectTermInput']")).sendKeys("30000");
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		
		// From State Specific Information Screen, navigate to the next page
		
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'Next')]")).click();
		Thread.sleep(2000);
		
		// Enter/Select the value in mandatory fields on Location screen and navigate to the next page
		
		driver.findElement(By.id("SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GL7LocationsScreen-GL7LocationsPanelSet-LocationsEdit_DP-LocationsEdit_LV-0-Loc_button")).click();
		Thread.sleep(2000);
		WebElement selectPremopscodeDropdown = driver.findElement(By.name("GL7LocationPopup-LocationScreen-GL7LocationDetailCV-SublinePropertiesPanel-0-LobEntityDV-16-LobInputSet-LobInternalInputSet-Input"));
		Select dropdown5 = new Select(selectPremopscodeDropdown);
		dropdown5.selectByVisibleText("501");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"GL7LocationPopup-LocationScreen-Update\"]/div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'Next')]")).click();
		Thread.sleep(4000);
		
		// Enter/Select the value in mandatory fields on Exposure screen and navigate to the next page
		
		driver.findElement(By.xpath("//div[@id='SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-GL7ExposuresScreen-GL7ExposuresPanelSet-ExposureLDV_tb-AddExposureBtn']/div[@role='button']")).click();
		driver.findElement(By.xpath("//div[contains(text(), 'Premises/Operations and Products/Completed Operations')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id='GL7ExposurePopup-GL7ExposureCV-LobEntityDV-1-LobInputSet-LobInternalInputSet-ClassCode-SelectClassCode']/span")).click();
		driver.findElement(By.xpath("//div[@id='GL7ClassCodeSearchPopup-GL7ClassCodeSearchScreen-ClassCodeSearchResultsLV-0-_Select']/div/div[contains(text(), 'Select')]")).click();
		driver.findElement(By.xpath("//div[@id='GL7ExposurePopup-Update']/div/div[2]")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@id='WebMessageWorksheet-WebMessageWorksheetScreen-WebMessageWorksheet_ClearButton']/div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("GL7ExposurePopup-GL7ExposureCV-LobEntityDV-54-LobInputSet-LobInternalInputSet-Input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("GL7ExposurePopup-GL7ExposureCV-LobEntityDV-54-LobInputSet-LobInternalInputSet-Input")).sendKeys("100000");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='GL7ExposurePopup-Update']/div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'Next')]")).click();
		Thread.sleep(3000);
		
		// From State Supplemental Questions Screen, navigate to the next page
		
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'Next')]")).click();
		Thread.sleep(4000);
				
		// From State Modifiers Screen, navigate to the next page
				
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'Next')]")).click();
		Thread.sleep(4000);
		
		// Click on Quote button on Risk Analysis screen
		
		driver.findElement(By.xpath("//div[@class='gw-label']/div[contains(text(), 'Q')]")).click();
		Thread.sleep(50000);
		
		// Print the submission number and total premium amount on console
		
		System.out.println("Submission Number " + driver.findElement(By.cssSelector("div[id='SubmissionWizard-SubmissionWizard_QuoteScreen-Quote_SummaryDV-JobNumber_Input'] div[id='SubmissionWizard-SubmissionWizard_QuoteScreen-Quote_SummaryDV-JobNumber']")).getText());
		System.out.println("Total Premium " + driver.findElement(By.cssSelector("div[id='SubmissionWizard-SubmissionWizard_QuoteScreen-Quote_SummaryDV-TotalPremium'] div[class='gw-value-readonly-wrapper']")).getText());
		
		// Click on Risk Analysis screen from side bar from Quote screen
		
		driver.findElement(By.xpath("//div[@id='SubmissionWizard-RiskAnalysis']/div/div[contains(text(), 'Risk Analysis')]")).click();
		Thread.sleep(2000);
		
		// Approve the underwrite messages from Risk Analysis screen
		
		driver.findElement(By.id("SubmissionWizard-Job_RiskAnalysisScreen-RiskAnalysisCV-RiskEvaluationPanelSet-1-UWIssueRowSet-SpecialApprove")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'OK')]")).click();
		Thread.sleep(3000);
		
// Policy Issuance
		
		driver.findElement(By.cssSelector("div[id='SubmissionWizard-Job_RiskAnalysisScreen-JobWizardToolbarButtonSet-BindOptions'] div[role='button']")).click();
		driver.findElement(By.xpath("//div[contains(text(), 'Issue Policy')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		// Print the policy number on console
		
//		System.out.println(driver.findElement(By.cssSelector("div[id='JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy_Input'] div[role='link']")).getText());
//		Thread.sleep(2000);		
		
		// Save the policy issued screenshot on targeted location
			
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("D:\\GWBC - Daily Task Tracker\\Sprint #28\\Selenium Backup_19Feb2022\\Policy.jpg"));
		
		// Click on Policy issued link
		
//		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[id='JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy_Input'] div[role='link']")).click();
		Thread.sleep(3000);
		
		// Print the policy number on console
		
		System.out.println("Policy Number " +driver.findElement(By.cssSelector("div[id=\"PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-PolicyDetailsDetailViewTile_DV-PolicyNumber\"] div[class='gw-value-readonly-wrapper']")).getText()); 
		
// Policy Change Transaction
 
		// Click on New Transaction dropdown button and Select Policy Change option
		
/*		driver.findElement(By.cssSelector("div[id='PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(), 'Change Policy')]")).click();
		Thread.sleep(2000);
		
		// Click on Next button on Start Policy Change screen
		
		driver.findElement(By.xpath("//div[contains(text(), 'ext')]")).click();
		Thread.sleep(2000);
		
		// Click on Exposures option from side bar
		
		driver.findElement(By.xpath("//div[contains(text(), 'Exposures')]")).click();
		
		// Click on Effective Date link to edit the details on Exposures screen and Click on OK button
		
		driver.findElement(By.cssSelector("[id='PolicyChangeWizard-LOBWizardStepGroup-LineWizardStepSet-GL7ExposuresScreen-GL7ExposuresPanelSet-ExposureLDV-ExposureLV-0-EffectiveDate_button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[name='GL7ExposurePopup-GL7ExposureCV-LobEntityDV-54-LobInputSet-LobInternalInputSet-Input']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[name='GL7ExposurePopup-GL7ExposureCV-LobEntityDV-54-LobInputSet-LobInternalInputSet-Input']")).sendKeys("500000");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[id='GL7ExposurePopup-Update'] div[role='button']")).click();
		Thread.sleep(4000);
		
		// Navigate to the Modifiers screen
		
		driver.findElement(By.xpath("//div[contains(text(), 'Modifiers')]")).click();
		
		// Click on Quote button from Modifiers screen
		
		driver.findElement(By.xpath("//div[@id='PolicyChangeWizard-LOBWizardStepGroup-LineWizardStepSet-GL7ModifiersScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-Quote']//div[contains(text(), 'uote')]")).click();
		Thread.sleep(2000);
		
		// Grab the changes in cost text
		
		System.out.println("Change in Cost " + driver.findElement(By.cssSelector("[id='PolicyChangeWizard-PolicyChangeWizard_QuoteScreen-Quote_SummaryDV-ChangeInCost'] [class='gw-value-readonly-wrapper']")).getText());
		Thread.sleep(1000);
		
		// Click on Issue Change button on Quote screen
		
		driver.findElement(By.xpath("//div[@id='PolicyChangeWizard-PolicyChangeWizard_QuoteScreen-JobWizardToolbarButtonSet-BindPolicyChange']//div[contains(text(), 'ssue Change')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		// Grab the transaction text and Click on policy link
		
		System.out.println(driver.findElement(By.xpath("//div[@id='JobComplete-JobCompleteScreen-Message']/div")).getText());
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[id='JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy'] [role='link']")).click();
		
// Cancel Policy Transaction		 
 
				// Click on New Transaction dropdown button and Select Cancel Policy option
				
				driver.findElement(By.cssSelector("div[id='PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-0']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[contains(text(), 'Cancel Policy')]")).click();
				Thread.sleep(2000);
				
				// Select the value in mandatory dropdowns and Click on Next button on Start Cancellation For Policy screen
				
				WebElement sourceDropdown = driver.findElement(By.cssSelector("[name='StartCancellation-StartCancellationScreen-CancelPolicyDV-Source']"));
				Select dropdown6 = new Select(sourceDropdown);
				dropdown6.selectByVisibleText("Insured");
				Thread.sleep(2000);
				WebElement reasonDropdown = driver.findElement(By.cssSelector("[name='StartCancellation-StartCancellationScreen-CancelPolicyDV-Reason']"));
				Select dropdown7 = new Select(reasonDropdown);
				dropdown7.selectByVisibleText("Policy not-taken");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'Start Cancellation')]")).click();
				Thread.sleep(3000);
				
				// Grab the changes in cost text
				
				System.out.println("Change in Cost " + driver.findElement(By.cssSelector("[id='CancellationWizard-CancellationWizard_QuoteScreen-Quote_SummaryDV-ChangeInCost'] [class='gw-value-readonly-wrapper']")).getText());
				Thread.sleep(1000);
				
				// Click on Cancel Now
				
				driver.findElement(By.cssSelector("[id='CancellationWizard-CancellationWizard_QuoteScreen-JobWizardToolbarButtonSet-BindOptions'] [role='button']")).click();
				driver.findElement(By.xpath("//div[@id='CancellationWizard-CancellationWizard_QuoteScreen-JobWizardToolbarButtonSet-BindOptions-CancelNow']//div[contains(text(), 'ancel Now')]")).click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				
				// Grab the transaction text and Click on policy link
				
				System.out.println(driver.findElement(By.xpath("//div[@id='JobComplete-JobCompleteScreen-Message']/div")).getText());
				
				// Click on policy link
				
				driver.findElement(By.cssSelector("[id='JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy'] [role='link']")).click();
				Thread.sleep(5000);
		
// Reinstate Policy Transaction					
				
				// Click on New Transaction dropdown button and Select Reinstate Policy option
				
				driver.findElement(By.cssSelector("[id='PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-0']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-ReinstatePolicy']/div/div[2]")).click();
				Thread.sleep(2000);
				
				// Select the mandatory field on Start Reinstatement screen
				
				WebElement reason2dropdown = driver.findElement(By.cssSelector("[name='ReinstatementWizard-ReinstatementWizard_ReinstatePolicyScreen-ReinstatePolicyDV-ReasonCode']"));
				Select dropdown8 = new Select(reason2dropdown);
				dropdown8.selectByVisibleText("Other");
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("[name='ReinstatementWizard-ReinstatementWizard_ReinstatePolicyScreen-ReinstatePolicyDV-ReasonDescription']")).sendKeys("Test");
				Thread.sleep(1000);
				
				// Click on Quote button
				
				driver.findElement(By.xpath("//div[@id='ReinstatementWizard-ReinstatementWizard_ReinstatePolicyScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-Quote']/div/div[contains(text(), 'uote')]")).click();
				Thread.sleep(5000);
				
				// Grab the changes in cost text
				
				System.out.println("Change in Cost " + driver.findElement(By.cssSelector("[id='ReinstatementWizard-ReinstatementWizard_QuoteScreen-Quote_SummaryDV-ChangeInCost'] [class='gw-value-readonly-wrapper']")).getText());
				Thread.sleep(1000);
				
				// Click on Reinstate button
				
				driver.findElement(By.xpath("//div[@id='ReinstatementWizard-ReinstatementWizard_QuoteScreen-JobWizardToolbarButtonSet-Reinstate']/div/div[contains(text(), 'einstate')]")).click();
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				
				// Grab the transaction no on console
				
				System.out.println(driver.findElement(By.xpath("//div[@id='JobComplete-JobCompleteScreen-Message']/div")).getText());
				
				// Click on policy link
				
				driver.findElement(By.cssSelector("[id='JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy'] [role='link']")).click();
				Thread.sleep(5000);
				
// Renew Policy Transaction					
				
				// Click on New Transaction dropdown button and Select Renew Policy option
				
				driver.findElement(By.cssSelector("[id='PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-0']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@id='PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-RenewPolicy']/div/div[2]")).click();
				Thread.sleep(5000);		
				
				// Click on Next button
				
				driver.findElement(By.cssSelector("[id='RenewalWizard-Next'] [role='button']")).click();
				Thread.sleep(2000);
				
				// Click on Edit Policy Transaction button
				
				driver.findElement(By.xpath("//div[@role='button']/div[contains(text(), 'dit Policy Transaction')]")).click();
				Thread.sleep(2000);
				
				// Navigate to the Modifiers screen
				
				driver.findElement(By.cssSelector("[id='RenewalWizard-LOBWizardStepGroup-Modifiers'] [role='menuitem']")).click();
				
				// Click on Quote button
				
				driver.findElement(By.xpath("//div[@id='RenewalWizard-LOBWizardStepGroup-LineWizardStepSet-GL7ModifiersScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-Quote']//div[contains(text(), 'uote')]")).click();
				Thread.sleep(5000);
				
				// Grab the Total Premium text
				
				System.out.println("Total Renewal Premium " + driver.findElement(By.cssSelector("[id='RenewalWizard-PostQuoteWizardStepSet-RenewalWizard_QuoteScreen-Quote_SummaryDV-TotalPremium'] [class='gw-value-readonly-wrapper']")).getText());
				Thread.sleep(1000);
				
				// Click on Bind Options button and Click on Issue Now
				
				driver.findElement(By.cssSelector("[id='RenewalWizard-PostQuoteWizardStepSet-RenewalWizard_QuoteScreen-JobWizardToolbarButtonSet-BindOptions'] [role='button']")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("[id=\"RenewalWizard-PostQuoteWizardStepSet-RenewalWizard_QuoteScreen-JobWizardToolbarButtonSet-BindOptions-IssueNow\"] [class='gw-shortcutKey']")).click();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				Thread.sleep(4000);
				
				// Click on Clear button
				
				driver.findElement(By.xpath("//div[@id='WebMessageWorksheet-WebMessageWorksheetScreen-WebMessageWorksheet_ClearButton']/div/div[2]")).click();
				Thread.sleep(2000);
				
				// Click on Payment screen from side bar
				
				driver.findElement(By.xpath("//div[@id='RenewalWizard-BillingInfo']//div[contains(text(), 'Payment')]")).click();
				Thread.sleep(6000);
				
				// Click on Bind Options button and Click on Issue Now
				
				driver.findElement(By.cssSelector("[id='RenewalWizard-PostQuoteWizardStepSet-RenewalWizard_PaymentScreen-JobWizardBillingToolbarButtonSet-BindOptions'] [role='button']")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("[id=\"RenewalWizard-PostQuoteWizardStepSet-RenewalWizard_PaymentScreen-JobWizardBillingToolbarButtonSet-BindOptions-IssueNow\"] [class='gw-shortcutKey']")).click();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				Thread.sleep(4000);
				
				// Grab the transaction text and Click on policy link
				
				System.out.println(driver.findElement(By.cssSelector("[id='JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy'] [role='link']")).getText());
				Thread.sleep(2000);
				*/				
	}
	
}