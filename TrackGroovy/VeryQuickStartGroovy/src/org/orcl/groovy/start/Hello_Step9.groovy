// Step 9: Adding or Removing Entries
def sayHello(name) {
	println("Hello $name!")
}

def names = ["SintSi", "Kaitlyn", "Keira"]

names += 'Jim' // add 
names -= 'SintSi' // remove

names.sort()

for (name in names) {
	sayHello(name)
}

