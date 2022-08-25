let operator,a,b;
function num1() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'1');
}
function num2() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'2');
}
function num3() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'3');
}
function num4() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'4');
}
function num5() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'5');
}
function num6() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'6');
}
function num7() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'7');
}
function num8() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'8');
}
function num9() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'9');
}
function num0() {
    let vp = document.getElementById('viewport').value;
    document.getElementById('viewport').innerHTML=(vp+'0');
}

function add() {
    a = parseInt(document.getElementById('viewport').value);
    operator = 1;
    document.getElementById('viewport').innerHTML=('');
    console.log (a);
}
function sub() {
    a = parseInt(document.getElementById('viewport').value);
    operator = 2;
    document.getElementById('viewport').innerHTML=('');
    console.log (a);
}
function mod() {
    a = parseInt(document.getElementById('viewport').value);
    operator = 3;
    document.getElementById('viewport').innerHTML=('');
    console.log (a);
}
function div() {
    a = parseInt(document.getElementById('viewport').value);
    operator = 4;
    document.getElementById('viewport').innerHTML=('');
    console.log (a);
}
function act() {
    b = parseInt(document.getElementById('viewport').value);
    let result;
    switch (operator) {
        case 1:
            result = a + b;
            break;
        case 2:
            result = a - b;
            break;
        case 3:
            result = a * b;
            break;
        case 4:
            result = a / b;
            break;
    }
    document.getElementById('viewport').innerHTML=(result);
}
function reset() {
    document.getElementById('viewport').innerHTML = ('');
    // console.log (a);
}