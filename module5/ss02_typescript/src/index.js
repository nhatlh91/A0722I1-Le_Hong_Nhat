var qty = 20;
var result = [0, 1];
var sum = 0;
function fibo(a, b) {
    var c = a + b;
    result.push(c);
    if (result.length < qty) {
        fibo(b, c);
    }
}
fibo(0, 1);
console.log("Dãy fibonnaci:");
console.log(result);
result.forEach(function (value) { return sum += value; });
console.log("C\u00F3 t\u1ED5ng l\u00E0: ".concat(sum));
