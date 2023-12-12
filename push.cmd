@echo off
REM Get current date and time in a format suitable for file names or commit messages
for /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /value') do set datetime=%%I
set datestamp=%datetime:~0,4%_%datetime:~4,2%_%datetime:~6,2%
set timestamp=%datetime:~8,2%-%datetime:~10,2%-%datetime:~12,2%

cd C:\\java-work\\dsa
set name=commit_%datestamp%_%timestamp%
git add .
git commit -m "%name%"
git push origin main
pause