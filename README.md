# spring-boot-task-3 with spring filter

In this task
firstly, store admin username and password to postgres db
secondly, when admin login creates a session and stored in redis db with duration 1 minute
and finally, when we hit /student/** it filter if there is admin session or not in redis db
