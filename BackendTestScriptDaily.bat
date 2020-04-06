@echo off 
SETLOCAL enabledelayedexpansion
cd /d %~dp0\mock_transactions

set back=%cd%

cd %cd%\Day1\Input
if not exist "%cd%\Day1\OutputDTF\" (mkdir "%cd%\Day1\OutputDTFs")
if not exist "%cd%\Day1\Merged\" (mkdir "%cd%\Day1\Merged")

for %%f in (*) do (
    "%~dp0FrontEnd"\FrontEnd.exe "%cd%\current_user_accounts.txt" "%cd%\available items.txt" "%cd%\Day1\OutputDTF\%%f" < "%cd%\Day1\Input\%%f"
    
)

cd %back%

cd %cd%\Day1\OutputDTF

for %%f in (*) do type "%%f" > %back%\Day1\Merged\mergedDTF.txt 

cd %back%

cd /d %~dp0Backend
javac src\*.java
java src\main.java "%cd%\Day1\MergedF\mergedDTF.txt" 



ENDLOCAL