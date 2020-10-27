#!/bin/sh

TERMINAL='xterm -hold -e'
PROJECT_PWD=`pwd`
SERVER_PATH=$PROJECT_PWD/'src/server'
SERVER_RUN_SCRIPT='buildAndRun.sh'
CLIENT_PATH=$PROJECT_PWD/'src/client/browser/lager-app'
CLIENT_RUN_SCRIPT='installAndRun.sh'

# start server
cd $SERVER_PATH
$TERMINAL ./$SERVER_RUN_SCRIPT &

# start browser client
cd $CLIENT_PATH
$TERMINAL ./$CLIENT_RUN_SCRIPT &
