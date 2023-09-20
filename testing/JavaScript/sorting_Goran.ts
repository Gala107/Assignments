// 1. Create a JS function that takes 5 random numbers as parameters.
// 2. The function should return a string with the 5 numbers in order from low to high separated by ":".

// In order to pass 'rest' argument into function with multiple parameters,
// the array('rest' argument) has to be a tuple: have predefined size and predefined elements type.
let randomNums: [number, number, number, number, number] = [
    Math.floor(Math.random() * 101),
    Math.floor(Math.random() * 101),
    Math.floor(Math.random() * 101),
    Math.floor(Math.random() * 101),
    Math.floor(Math.random() * 101)
];

// practising with 'arguments' object,
// it's not accessible in arrow functions, therefore expression function,
// 'rest' parameter is preferable to 'arguments' object.
let sortNumbers = function (n1: number, n2: number, n3: number, n4: number, n5: number): string {
    let numbers = Array.from(arguments).sort((a: number, b: number): number => a - b);
    return numbers.join(":");
}

console.log(randomNums);
console.log(sortNumbers(...randomNums));