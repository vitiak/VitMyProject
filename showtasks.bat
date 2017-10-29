call runcrud.bat
if "%ERRORLEVEL%" == "0" goto fail

start chrome.exe --new-window http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo runcrud.bat has errors - breaking work
echo There were errors

:end
echo.
echo Work is finished.
