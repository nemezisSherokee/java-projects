clear

newbranch=$1
newbranch2=$2
 
test -z "$1" && {
	 newbranch="branch1_$(date +%s)";
	 echo "$newbranch"
	}

test -z "$2" && {
	 newbranch2="branch2_$(date +%s)";
	 echo "$newbranch2"
	}

git checkout -b $newbranch add-nice-printer-for-string
echo "//add-nice-printer-for-string change 1 new branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "first changes to new branch"

git checkout -b $newbranch2 $newbranch
echo "//add-nice-printer-for-string change 1 new new branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "first changes to new new branch"

git checkout add-nice-printer-for-string
echo "//add-nice-printer-for-string change 1 original branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "first changes to add-nice-printer-for-string"


git checkout add-nice-printer-for-string
echo "//add-nice-printer-for-string change 2 original branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "second changes to add-nice-printer-for-string"


git checkout  $newbranch
echo "//add-nice-printer-for-string change 2 new branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "second changes to new branch"

git checkout  $newbranch2
echo "//add-nice-printer-for-string change 2 new new branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "second changes to new new branch"
	

git checkout add-nice-printer-for-string
echo "//add-nice-printer-for-string change 3 original branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "third changes to add-nice-printer-for-string"


git checkout  $newbranch
echo "//add-nice-printer-for-string change 3 new branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "third changes to new branch"

git checkout  $newbranch2 
echo "//add-nice-printer-for-string change 2 new new branch" >> ./gitproject/src/main/java/com/project/git/gitproject/App.java
git add *
git commit -m "third changes to new new branch"