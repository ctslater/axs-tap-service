#!/bin/bash

# Exit on failure
set -e

gradle build assemble

cp build/libs/*.war docker/
(cd docker && docker build -t ctslater/spark-tap-service . )

