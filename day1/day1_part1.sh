#!/bin/bash

# Read in file
mapfile -t expenses < input

len=${#expenses[@]}

for (( i=0; i<$len; i++ ))
do
    for (( j=i; j<$len; j++ ))
    do
        if (( ${expenses[i]} + ${expenses[j]} == 2020 ))
	then
	    answer=$(( ${expenses[i]} * ${expenses[j]} ))
	    echo $answer
	    exit 0
	fi
    done    
done    
