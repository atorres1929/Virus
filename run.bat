@echo off
cd C:
mkdir "%APPDATA%\Not a Virus"
copy "%CD%\Virus\dist\Virus.jar" "%APPDATA%\Not a Virus\Virus.jar"
javaw -jar "%APPDATA%\Not a Virus\Virus.jar"
@echo Instalation complete! Enjoy your virus!
@pause