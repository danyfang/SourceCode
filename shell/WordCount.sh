# !/bin/bash
# this bash script is a word count program, displays the word with frequency 
# in frequency descending order
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{ print $2, $1 }'
