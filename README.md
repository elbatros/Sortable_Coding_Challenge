# Sortable Coding Challenge

## Summary
This application is for the Sortable Coding Challenge (https://sortable.com/challenge/) using Java. It reads in data from products.txt
and lisings.txt (both located in the project folder), parses and filters the data which is then written to a text file. 


## Implementation
1. Read in data and store into Json objects
2. Filter data
    - first by manufacturer
    - second based on model string
    - third based on first word of name
    - lastly based on second word of name
3. Convert and write to output file 


## Installation 

1. go to project directory on the terminal
2. run chmod +x build.sh
3. run ./build.sh "path/to/outputTextFile.txt"
