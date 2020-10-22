#!/bin/bash

[[ $1 ]] || { echo "Arguments missing" >&2; exit 1; }

TAG=$1
echo "$TAG"

git config user.email "ugdark+circleCI@gmail.com"
git config user.name "buildMan"
git add .
git status

diff=$(git diff --cached)
if [ -n "$diff" ]; then
    git commit -m "updated auto format. ${TAG}";
fi
