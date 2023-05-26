words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}

Given a dictionary contain set of words.

Store all words except substring. Later will use this to check cocentenated words.

Check which words contain the most minimum word. Take note the minimum length


Recursive each word and check if the current word is cocentenation or not


A function with parameter :

- Current word
- Start : 0
- End : length of current word
- most minimum length



Check the currnt words

Check if the current words is cocentenation of several words.

slice the string from 0 to most minimum length  available

check if the current slice is contain in the dictionary.

	If if contained in it, check if the rest of slice contain in dictionary
	
	If it doesnt contain, then slice it further for the rest of the word
	
	




#	
catsdogcats
	cat
	sdogcats
		sdo
		gcats
		
		sdog
		cats
		
		sdogc
		ats
	
	cats
	dogcats
		dog
		cats

# 
dogcatsdog
	dog
	catsdog
		cat
		sdog
		
		cats
		dog
	

#
hippopotamuses
	hip
	popotamuses
	
	hipp
	opotamuses
	
	hippo
	potamuses
	
	hippop
	otamuses
	
	hippopo
	tamuses
	
	hippopot
	amuses
	
	hippopota
	muses
	
	hippopotam
	uses
	
	hippopotamu
	ses
	
	
	

#
ratcatdogcat
	rat
	catdogcat
		cat
		dogcat
			dog
			cat












