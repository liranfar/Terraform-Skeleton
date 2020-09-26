#!/usr/bin/env bash

/etc/init.d/filebeat start

exec bash -c /usr/local/bin/jenkins.sh