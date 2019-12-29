#!/bin/bash

VERSION="0.36.0"

echo $(pwd)

function get_ktlint()
{
  curl -SLO https://github.com/pinterest/ktlint/releases/download/$VERSION/ktlint
  chmod a+x ktlint
}

if [ ! -e ktlint ]
then
  get_ktlint
else
  VER=$(./ktlint --version)
  if [[ "$VER" != "$VERSION" ]]
  then
    rm ktlint
    get_ktlint
  fi
fi
