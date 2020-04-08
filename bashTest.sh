HOM=/Users/harrythasarathan/Documents/Phase5_backend/CSCI3060BackEnd
BASE=./mock_transactions
DIRS=./mock_transactions/*
for f in $DIRS
do
	INP=$f/Input/*
    OUT=$f/OutputDTF
	TERMOUT = $f/Termout 
	i=0
	for g in $INP
	do
		((i++))
		TEST=${g##*/}
		#check inputs are got correctly
		#printf "${TEST}"
		
		./Frontend/FrontEnd.exe "${HOM}/test_documents/current_user_accounts.txt" "${HOM}/test_documents/available items.txt" "${OUT}/${TEST}" > "${TERMOUT}/${TEST}" <$g 
		
	done

    cat $OUT/* > $f/Merged/mergedDTF.txt 
    #javac $HOM/Backend/src/*.java
    #java $HOM/Backend/src/main "${d}/Merged/mergedDTF.txt"
done