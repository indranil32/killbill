export CATALINA_OPTS="$CATALINA_OPTS -server -showversion -XX:+PrintCommandLineFlags -XX:+UseCodeCacheFlushing -XX:PermSize=512m -XX:MaxPermSize=1G -Xms1G -Xmx2G -XX:+CMSClassUnloadingEnabled -XX:-OmitStackTraceInFastThrow -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSConcurrentMTEnabled -XX:+CMSParallelRemarkEnabled -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -XX:+ScavengeBeforeFullGC -XX:+CMSScavengeBeforeRemark -XX:NewSize=600m -XX:MaxNewSize=900m -XX:SurvivorRatio=10 -XX:+DisableExplicitGC -Djava.security.egd=file:/dev/./urandom -Dorg.killbill.server.test.mode=true -Dorg.killbill.server.properties=file:///var/lib/killbill/killbill-server.properties -Dlogback.configurationFile=/var/lib/killbill/logback.xml -Dorg.killbill.server.http.gzip=true"
