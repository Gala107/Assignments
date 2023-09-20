// 1. Create a JS function that takes 5 random numbers as parameters.
// 2. The function should return a string with the 5 numbers in order from low to high separated by ":".
// In order to pass 'rest' argument into function with multiple parameters,
// the array('rest' argument) has to be a tuple: have predefined size and predefined elements type.
let randomNums = [
    Math.floor(Math.random() * 101),
    Math.floor(Math.random() * 101),
    Math.floor(Math.random() * 101),
    Math.floor(Math.random() * 101),
    Math.floor(Math.random() * 101)
];
// 'arguments' object is not accessible in arrow functions, therefore expression function,
// practising with 'arguments'
// 'rest' parameter is preferable to 'arguments' object.
let sortNumbers = function (n1, n2, n3, n4, n5) {
    let numbers = Array.from(arguments).sort((a, b) => a - b);
    return numbers.join(":");
};
console.log(randomNums);
console.log(sortNumbers(...randomNums));
