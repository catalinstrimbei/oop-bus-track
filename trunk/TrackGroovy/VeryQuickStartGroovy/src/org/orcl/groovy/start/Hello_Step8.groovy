/* First Attempt: not working - can't use {} sintax to declare array - use [] instead
def sayHello(name) {
	println("Hello $name!")
}

String[] names = {"SintSi", "Kaitlyn", "Keira"}  
for (String name : names) {     
	sayHello(name)
}
*/

/* Second attempt: working use [] for Groovy arrays
def sayHello(name) {
	println("Hello $name!")
}

String[] names = ["SintSi", "Kaitlyn", "Keira"]

for (String name : names) {
	sayHello(name)
}
*/

/* Third attempt: wotking- use def for arrays
def sayHello(name) {
	println("Hello $name!")
}

def names = ["SintSi", "Kaitlyn", "Keira"]

for (def name : names) {
	sayHello(name)
}
*/

/* Last attempt: use for with in keyword and sort on arrays*/
def sayHello(name) {
	println("Hello $name!")
}

def names = ["SintSi", "Kaitlyn", "Keira"]

names.sort()

for (name in names) {
	sayHello(name)
}