#!/bin/bash

echo $(pwd)

if [ ! -e ktlint ]
then
  curl -SLO https://github.com/shyiko/ktlint/releases/download/0.31.0/ktlint
  chmod a+x ktlint
fi