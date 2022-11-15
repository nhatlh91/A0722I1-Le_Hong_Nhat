let objPart1 = document.getElementById("firstPart");
let objPart2 = document.getElementById("secondPart");
let objPart3 = document.getElementById("thirdPart");
let objPart4 = document.getElementById("fourthPart");
let objPart5 = document.getElementById("fifthPart");

function partChange(part) {
    switch (part) {
        case 1:
            if (objPart1.getAttribute('src') === 'img_for_puzzle/cat1.jpg') {
                objPart1.src = "img_for_puzzle/monkey1.jpg"
            } else if (objPart1.getAttribute('src') === 'img_for_puzzle/monkey1.jpg') {
                objPart1.src = "img_for_puzzle/panda1.jpg";
            } else {
                objPart1.src = "img_for_puzzle/cat1.jpg"
            }
            break;
        case 2:
            if (objPart2.getAttribute('src') === 'img_for_puzzle/cat2.jpg') {
                objPart2.src = "img_for_puzzle/monkey2.jpg"
            } else if (objPart2.getAttribute('src') === 'img_for_puzzle/monkey2.jpg') {
                objPart2.src = "img_for_puzzle/panda2.jpg";
            } else {
                objPart2.src = "img_for_puzzle/cat2.jpg"
            }
            break;
        case 3:
            if (objPart3.getAttribute('src') === 'img_for_puzzle/cat3.jpg') {
                objPart3.src = "img_for_puzzle/monkey3.jpg"
            } else if (objPart3.getAttribute('src') === 'img_for_puzzle/monkey3.jpg') {
                objPart3.src = "img_for_puzzle/panda3.jpg";
            } else {
                objPart3.src = "img_for_puzzle/cat3.jpg"
            }
            break;
        case 4:
            if (objPart4.getAttribute('src') === 'img_for_puzzle/cat4.jpg') {
                objPart4.src = "img_for_puzzle/monkey4.jpg"
            } else if (objPart4.getAttribute('src') === 'img_for_puzzle/monkey4.jpg') {
                objPart4.src = "img_for_puzzle/panda4.jpg";
            } else {
                objPart4.src = "img_for_puzzle/cat4.jpg"
            }
            break;
        case 5:
            if (objPart5.getAttribute('src') === 'img_for_puzzle/cat5.jpg') {
                objPart5.src = "img_for_puzzle/monkey5.jpg"
            } else if (objPart5.getAttribute('src') === 'img_for_puzzle/monkey5.jpg') {
                objPart5.src = "img_for_puzzle/panda5.jpg";
            } else {
                objPart5.src = "img_for_puzzle/cat5.jpg"
            }
            break;
    }
    check();
}
function check() {
    if (objPart1.getAttribute('src') === 'img_for_puzzle/cat1.jpg' && objPart2.getAttribute('src') === 'img_for_puzzle/cat2.jpg'
        && objPart3.getAttribute('src') === 'img_for_puzzle/cat3.jpg' && objPart4.getAttribute('src') === 'img_for_puzzle/cat4.jpg'
        && objPart5.getAttribute('src') === 'img_for_puzzle/cat5.jpg') {
        objPart1.style.border = 'solid 5px green';
        objPart2.style.border = 'solid 5px green';
        objPart3.style.border = 'solid 5px green';
        objPart4.style.border = 'solid 5px green';
        objPart5.style.border = 'solid 5px green';
    } else if (objPart1.getAttribute('src') === 'img_for_puzzle/monkey1.jpg' && objPart2.getAttribute('src') === 'img_for_puzzle/monkey2.jpg'
        && objPart3.getAttribute('src') === 'img_for_puzzle/monkey3.jpg' && objPart4.getAttribute('src') === 'img_for_puzzle/monkey4.jpg'
        && objPart5.getAttribute('src') === 'img_for_puzzle/monkey5.jpg') {
        objPart1.style.border = 'solid 5px red';
        objPart2.style.border = 'solid 5px red';
        objPart3.style.border = 'solid 5px red';
        objPart4.style.border = 'solid 5px red';
        objPart5.style.border = 'solid 5px red';
    } else if (objPart1.getAttribute('src') === 'img_for_puzzle/panda1.jpg' && objPart2.getAttribute('src') === 'img_for_puzzle/panda2.jpg'
        && objPart3.getAttribute('src') === 'img_for_puzzle/panda3.jpg' && objPart4.getAttribute('src') === 'img_for_puzzle/panda4.jpg'
        && objPart5.getAttribute('src') === 'img_for_puzzle/panda5.jpg') {
        objPart1.style.border = 'solid 5px yellow';
        objPart2.style.border = 'solid 5px yellow';
        objPart3.style.border = 'solid 5px yellow';
        objPart4.style.border = 'solid 5px yellow';
        objPart5.style.border = 'solid 5px yellow';
    }else {
        objPart1.style.border = 'solid 5px white';
        objPart2.style.border = 'solid 5px white';
        objPart3.style.border = 'solid 5px white';
        objPart4.style.border = 'solid 5px white';
        objPart5.style.border = 'solid 5px white';
    }
}