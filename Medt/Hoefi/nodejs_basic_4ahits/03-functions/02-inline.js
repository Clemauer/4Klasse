const numbers = [1,2,3,4,5,6]

//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array

function sum (a,b){
    return a + b;
}

function mapCallbackFn(a,b,c){
    console.log(a);     // element value
    console.log(b);     // element index
    console.log(c);     // the array we call map on
}


// not yet an inline function
function double(number){
    const result = number*2;
    return result;
}

const result = numbers.map(double);
console.log(result);

// inline the function double:
const result2 = numbers.map(function (number) {return number*2});

// eine funktion ohne namen ist eine anonymous function
// funktionen können in variablen gespeichert werden;

// anonyme funktionen auf constante speichern
const myFunction = function () {console.log('hello');};