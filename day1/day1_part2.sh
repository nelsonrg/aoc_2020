#!/bin/bash

# Read in file
mapfile -t expenses < input

len=${#expenses[@]}

for ((i=0; i<$len; i++))
do
    for ((j=i; j<$len; j++))
    do
	for ((k=j; k<$len; k++))
	do
            if (( ${expenses[i]} + ${expenses[j]} + ${expenses[k]} == 2020 ))
	    then
		answer=$(( ${expenses[i]} * ${expenses[j]} * ${expenses[k]} ))
		echo $answer
		exit 0
	    fi
	done
    done    
done 
