#!/bin/bash

# set the following environment variables
# export INIT_SLEEP_SECONDS=5;

echo "----------------------------------------------------------------------
    Starting Gonsul
    ----------------------------------------------------------------------"
# Copy .ssh files from bind-mount to the user's home directory.
# Permissions and ownership of the copy can be modified without propagating changes to the host.
cp -R /tmp/.ssh /.ssh



sleep $INIT_SLEEP_SECONDS

./Gonsul/gonsul --config=./Gonsul/gonsul.conf
