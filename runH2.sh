java -cp ~/.m2/repository/com/h2database/h2/1.4.200/h2-1.4.200.jar \
org.h2.tools.Server \
-webAllowOthers \
-tcpAllowOthers \
-pgAllowOthers \
-ifNotExists
