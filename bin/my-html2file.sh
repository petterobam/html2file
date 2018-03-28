#!/bin/bash
# author:petterobam
# url:https://github.com/petterobam/my-html2file


# Usage: sh my-html2file.sh start "-Xms128m -Xmx128m"
# Usage: sh my-html2file.sh stop
# Usage: sh my-html2file.sh status
# Usage: sh my-html2file.sh reload 10
# Usage: sh my-html2file.sh log

env_args="-Xms128m -Xmx128m"
sleeptime=0
arglen=$#

# get my-html2file pid
get_pid(){
    pname="`find .. -name 'my-html2file*.jar'`"
    pname=${pname:3}
    pid=`ps -ef | grep $pname | grep -v grep | awk '{print $2}'`
    echo "$pid"
}

startup(){
    pid=$(get_pid)
    if [ "$pid" != "" ]
    then
        echo "my-html2file already startup!"
    else
        jar_path=`find .. -name 'my-html2file*.jar'`
        echo "jarfile=$jar_path"
        cmd="java $1 -jar $jar_path > ./my-html2file.out < /dev/null &"
        echo "cmd: $cmd"
        java $1 -jar $jar_path > ./my-html2file.out < /dev/null &
        echo "---------------------------------"
        echo "启动完成，按CTRL+C退出日志界面即可>>>>>"
        echo "---------------------------------"
        show_log
    fi
}

shut_down(){
    pid=$(get_pid)
    if [ "$pid" != "" ]
    then
        kill -9 $pid
        echo "my-html2file is stop!"
    else
        echo "my-html2file already stop!"
    fi
}

show_log(){
    tail -f my-html2file.out
}

show_help(){
    echo -e "\r\n\t欢迎使用my-html2file Blog"
    echo -e "\r\nUsage: sh my-html2file.sh start|stop|reload|status|log"
    exit
}

show_status(){
    pid=$(get_pid)
    if [ "$pid" != "" ]
    then
        echo "my-html2file is running with pid: $pid"
    else
        echo "my-html2file is stop!"
    fi
}

if [ $arglen -eq 0 ]
 then
    show_help
else
    if [ "$2" != "" ]
    then
        env_args="$2"
    fi
    case "$1" in
        "start")
            startup "$env_args"
            ;;
        "stop")
            shut_down
            ;;
        "reload")
            echo "reload"
            ;;
        "status")
            show_status
            ;;
        "log")
            show_log
            ;;
    esac
fi