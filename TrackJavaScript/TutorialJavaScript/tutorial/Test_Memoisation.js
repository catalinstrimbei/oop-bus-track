function operationFactory(operation, initialValue) {
	var sum = initialValue;
	if (operation == "+") {
		return function(x) {
			sum += x;
			return sum;
		}
	}
	;
	if (operation == "-") {
		return function(x) {
			sum -= x;
			return sum;
		}
	}
	;
	if (operation == "*") {
		return function(x) {
			sum *= x;
			return sum;
		}
	}
	;
}
//console.log('sum is' + sum);
var add = operationFactory("+", 0);
var subtract = operationFactory("-", 200);
var multiply = operationFactory("*", 10.0);
add(100);
console.log(add(200));
//console.log('sum is' + sum);
subtract(100);
console.log(subtract(50));
//console.log('sum is' + sum);
multiply(0.5);
//console.log(multiply(0.5));
//console.log('sum is' + sum);

try{phantom.exit();}catch(e){}