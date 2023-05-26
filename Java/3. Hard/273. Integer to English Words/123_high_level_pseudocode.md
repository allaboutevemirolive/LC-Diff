First we check if the input number is zero or not

If not zero proceed :

Check if input number less than 20 (special case)
	
	Any input that fall under this will map with
	
	belowTwenty = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };



Check if input number less than 100 (special case)

	Any input that fall under this will be map with
	
	tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
	
	Example : 
	
	23 = twenty three
	
	
	# Process first place in 23
	
	Divide 23 by 10 to get 2, which is the first place
	
	Then we map 2 with tens map
	
	We will get Twenty
	
	append ' ' to it ()
	
	
	# Process 3 in 23 (rest of the number / places)
	
	To get 3, we do remainder. 23 % 10 = 3
	
	Then we map 2 with belowTwenty map



Check if input number less than 1000

	example : 
	
	123 = one hundred twenty three
	
	# Process 1 in 123
	
	Divide 123 by 100 to get 1, which is the first place
	
	Recursicvely process 1 so it will fall under "Check if input number less than 20 (special case)" 
    
    Then we map 1 with belowTwenty map
	
	append 'hundred' to it
	
	# Process 23 in 123 (rest of the number)
	
	To get 23, we do remainder. 123 % 100 = 23
	
	recursively process 23 (23 will fall into "Check if input number less than 100")
	
	

Check if input number less than 1000000



Check if input number less than 1000000000 (divide 1000000 "million")



Check if input number MORE than 1000000000 (divide 1000000 "million" but append billion)