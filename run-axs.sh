#!/bin/bash

CMD="\${JAVA_HOME}/bin/java -Xmx512m -cp \${SPARK_HOME}/conf:\${SPARK_HOME}/jars/* org.apache.spark.deploy.SparkSubmit --master local[2] --conf spark.cores.max=1 --class org.apache.spark.sql.hive.thriftserver.HiveThriftServer2 --executor-memory 512m spark-internal"

docker run -it --rm  -p 10000:10000 -v $PWD/metastore_db:/opt/spark/metastore_db -v $PWD/hive_data:/opt/spark/hive_data ctslater/spark-axs-hive sh -c  "$CMD"
