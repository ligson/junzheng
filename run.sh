#!/bin/bash
lib="/home/boful/tomcat/webapps/bmc/WEB-INF/lib"
cp="./"
for line in `ls $lib`
{
        cp="$lib/$line:$cp"
}
echo "开始编译$1.java"
javac -classpath $cp -encoding utf-8 $1.java
echo "编译$1.java成功"
echo "开始运行$1"
java -classpath $cp  $1