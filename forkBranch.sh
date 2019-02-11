clear

git checkout add-nice-printer-for-string
echo "//add-nice-printer-for-string change 1 original branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "first changes to add-nice-printer-for-string"

newbranch=$1

test
test -z "$1" && {
	 newbranch="branch1_$(date +%s)";
	 echo "$newbranch"
	}

	git checkout -b $newbranch add-nice-printer-for-string
echo "//add-nice-printer-for-string change 1 new branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "first changes to new branch"


git checkout add-nice-printer-for-string
echo "//add-nice-printer-for-string change 2 original branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "second changes to add-nice-printer-for-string"


git checkout -b $newbranch
echo "//add-nice-printer-for-string change 2 new branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "second changes to new branch"

	
