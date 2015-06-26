java -Xmx1024M -Xss2M -XX:+CMSClassUnloadingEnabled -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9000 -jar `dirname $0`/sbt-launch-0.13.1.jar "$@"
