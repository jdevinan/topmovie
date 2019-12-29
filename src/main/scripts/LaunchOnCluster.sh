#!/bin/bash
spark-submit \
  --master yarn \
  --deploy-mode cluster \
  --executor-memory 2g \
  --class com.jd.bgc.MovieApp \
  ../bin/assignment-jar-with-dependencies-1.0-SNAPSHOT "$@"
