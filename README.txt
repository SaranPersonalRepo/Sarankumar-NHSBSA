>>>>>>>>>>>>>>>>>>>>>>>>>>Steps To Execute the below Feature file through Runner Class>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

Feature File Location: src\main\resources\NHSFeatureFiles\NHS_CircumtanceChecker.feature

Runner File Location: src\test\java\com\nhs\framework\runner\TestRunner.java

Run command already present in runner file. 

Before executing the runner file please follow below steps to run the tests without any issues:
==================================================================================================
Step 1: Go to Project path in you local
Step 2: Open the command prompt and set the project path
Eg: cd D:\Eclipse NHS Workspace\NHS_CheckerTool_Project

Step 3: Enter the command "mvn clean install -DskipTests"

Step to execute TestRunner.java file:
===================================================================================================
Step 4: Once build success got to Code Editor Eclipse or Intelij
Step 5: Go to the runner file location given above and Right click -> Run As -> Junit Test
Step 6: Script should be start running

Note: In Runner file you remove "tags = "@Positive_England" option to run both Postive and Negative scenario


>>>>>>>>>>>>>>>>>>>>>>>>>>Steps To Execute the below Feature file through .bat file>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Before executing the runner file please follow below steps to run the tests without any issues:
==================================================================================================
Step 1: Go to Project path in you local
Step 2: Open the command prompt and set the project path
Eg: cd D:\Eclipse NHS Workspace\NHS_CheckerTool_Project

Step 3: Enter the command "mvn clean install -DskipTests"

Step to execute .bat file:
===================================================================================================
1. To scenario double click on "NHS_CircumtanceChecker_PositiveScenario_England.bat" file present in the project

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Reports>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
1. Test report can be found in below path:
    target\NHS_TestExecutionReport.html
========
