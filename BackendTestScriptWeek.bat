  
@echo off 
SETLOCAL enabledelayedexpansion
cd /d %~dp0\mock_transactions
set back=%cd%
for /d %%c in (*) do (
	cd %cd%\%%c\Input
	if not exist "%cd%\%%c\OutputDTF\" (mkdir "%cd%\%%c\OutputDTF")
	if not exist "%cd%\%%c\Merged\" (mkdir "%cd%\%%c\Merged")
    <make merged dtf text file>
	for %%f in (*) do (
		"%~dp0FrontEnd"\FrontEnd.exe "%cd%\current_user_accounts.txt" "%cd%\available items.txt" "%cd%\%%c\OutputDTF\%%f" < "%cd%\%%c\Input\%%f"
		
	)
	cd %back%

	cd %cd%\%%c\OutputDTF

	for %%f in (*) do type "%%f" > %back%\%%c\Merged\mergedDTF.txt 

	cd %back%

	cd /d %~dp0\Backend
	javac src\*.java
	java src\main.java "%cd%\Day1\MergedF\mergedDTF.txt" 

	cd %back%
)
ENDLOCAL