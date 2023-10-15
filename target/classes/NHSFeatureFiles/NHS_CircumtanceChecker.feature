Feature: NHS Circumstance Checker

Background: Initiazlize browser and launch NHS Application
Given user navigate to NHS application

@Positive_England
Scenario Outline: Verify NHS Cost Applicable for England
When user click "Start Now" button in NHS_Start Page
When user click "<WhereYouLive>" RadioButton in NHS_WhereYouLive Page
When user click "<GPPracticeInScotlandOrWales>" RadioButton in NHS_GPPractice Page
When user click "<DentalPracticeCountry>" RadioButton in NHS_DentalPracticeCountry Page
When user enter "<DOB>" textBox in NHS_DOB Page
When user click "<DoYouLiveWithPartner>" RadioButton in NHS_Partner Page
When user click "<ClaimAnyBenfitsOrTaxCredits>" RadioButton in NHS_ClaimBenfitsTaxCredits Page
When user click "<GetPaidUniversalCredit>" RadioButton in NHS_UniversalCredit Page
When user click "<Benefits>" RadioButton in NHS_Benefits Page
Then user verify result Page

Examples:
|WhereYouLive|GPPracticeInScotlandOrWales|DentalPracticeCountry|DOB|DoYouLiveWithPartner|ClaimAnyBenfitsOrTaxCredits|GetPaidUniversalCredit|Benefits|
|England|Yes|England|11-09-1989|No|Yes|No, we get a different benefit|Tax Credits;Income Support|
|England|Yes|England|12-10-1979|Yes|Yes|No, I get a different benefit|Income Support|

@Negative_DOBInvalid_Wales
Scenario Outline: Verify NHS Cost Applicable for Wales
When user click "Start Now" button in NHS_Start Page
When user click "<WhereYouLive>" RadioButton in NHS_WhereYouLive Page
When user click "<GPPracticeInScotlandOrWales>" RadioButton in NHS_GPPractice Page
When user click "<DentalPracticeCountry>" RadioButton in NHS_DentalPracticeCountry Page
When user enter "<DOB>" textBox in NHS_DOB Page
When user click "<DoYouLiveWithPartner>" RadioButton in NHS_Partner Page
When user click "<ClaimAnyBenfitsOrTaxCredits>" RadioButton in NHS_ClaimBenfitsTaxCredits Page
When user click "<GetPaidUniversalCredit>" RadioButton in NHS_UniversalCredit Page
When user click "<Benefits>" RadioButton in NHS_Benefits Page
Then user verify result Page

Examples:
|WhereYouLive|GPPracticeInScotlandOrWales|DentalPracticeCountry|DOB|DoYouLiveWithPartner|ClaimAnyBenfitsOrTaxCredits|GetPaidUniversalCredit|Benefits|
|Wales|Yes|England|11-09-1600|No|Yes|No, we get a different benefit|Tax Credits;Income Support|