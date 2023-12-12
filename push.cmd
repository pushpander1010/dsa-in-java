@echo off
set name= commit_%date%_%time%
git add .
git commit -m %name%
git push origin main
pause