#!/bin/bash

# set the following environment variables
# export INIT_SLEEP_SECONDS=5;


echo "----------------------------------------------------------------------
    Starting Gonsul
    ----------------------------------------------------------------------"

sleep $INIT_SLEEP_SECONDS

./gonsul --config=/gonsul.conf

