const list = [1, 2, 3]

/*
const num1 = list[0] // --> 1
const num2 = list[1] // --> 2
*/

const [num2, , num1] = list;

console.log(num1);
console.log(num2);