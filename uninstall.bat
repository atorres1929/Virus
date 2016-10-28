cd C:
RD /S /Q "%CD%\Virus"
del "%APPDATA%\Microsoft\Windows\Start Menu\Programs\Startup\virus.bat"
RD /S /Q "%APPDATA%\Not a Virus"
echo =======================================================
echo You should now be clear of the Virus
@pause