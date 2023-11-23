import schedule
import time
import os

def git_commit_and_push():
    os.system("git add .")
    os.system('git commit -m "Auto commit"')
    os.system("git push")

# 设置每半小时定时执行git commit 和 git push
schedule.every(1).minutes.do(git_commit_and_push)

while True:
    schedule.run_pending()
    time.sleep(1)