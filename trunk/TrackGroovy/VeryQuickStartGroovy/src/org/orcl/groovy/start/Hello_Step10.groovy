// Step 12: First parameter - it alias
def sayHello(name) {
        println("Hello $name!")
}

def names = ["SintSi", "Kaitlyn", "Keira"]

names += 'Jim'
names -= 'SintSi'
names.sort()

//def clos = {name -> sayHello(name)} // closure
//names.each clos
names.each {sayHello(it)} // closure