git checkout add-nice-printer-for-string
echo "//add-nice-printer-for-string change 1 original branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "first changes to add-nice-printer-for-string"

newbranch=$1

test
test -z "$1" && {
	 $newbranch = "branch1"+date +%s;
	 echo "$newbranch"
	}
