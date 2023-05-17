let qty:number=20;
let result:number[]=[0,1];
let sum:number = 0;
function fibo(a: number, b: number) {
    let c = a + b;
    result.push(c);
    if (result.length < qty) {
        fibo(b, c);
    }
}

fibo(0,1);
console.log("Dãy fibonnaci:");
console.log(result);
result.forEach(value => sum+=value)
console.log(`Có tổng là: ${sum}`)