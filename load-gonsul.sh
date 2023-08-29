#!/bin/bash

# set the following environment variables
# export INIT_SLEEP_SECONDS=5;
sleep $INIT_SLEEP_SECONDS

echo "----------------------------------------------------------------------
    Starting Gonsul"

gonsul --config=$CONFIG_DIR/gonsul.conf
fi
