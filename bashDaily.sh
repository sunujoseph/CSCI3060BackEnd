HOM=/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd
BASE=./mock_transactions
#DIRS=./mock_transactions/*

INP=$BASE/Day1/Input/*
OUT=$BASE/Day1/OutputDTF/

i=0
for g in $INP
do
    ((i++))
    TEST=${g##*/}
    #check inputs are got correctly
    #printf "${TEST}"
    
    ./Frontend/FrontEnd.exe "${HOM}/test_documents/current_user_accounts.txt" "${HOM}/test_documents/available items.txt" "${OUT}/${TEST}" <$g 
    
done

cat $OUT/* > $BASE/Day1/Input//Merged/mergedDTF.txt 
javac $HOM/Backend/src/*.java
java $HOM/Backend/src/main "${BASE}/Day1/Input//Merged/mergedDTF.txt"
