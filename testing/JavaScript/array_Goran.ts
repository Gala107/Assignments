// Create a JS function
// That takes an array of 5 numbers as a parameter
// The functions returns the same array with values in the 2nd index position and 3rd index position switched.
let switchIndexNum = (numbers: number[], index1: number, index2: number) => {
    console.log(numbers);
    numbers[index2] = numbers.splice(index1, 1, numbers[index2])[0];
    return numbers;
}

let numbers: number[] = [];
for (let i = 0; i < 5; i++) {
    // Generate random integer from 0 to 100 and push on the array
    numbers.push(Math.floor(Math.random() * 101));
}
console.log(switchIndexNum(numbers, 2, 3));
console.log("Numbers at indexes 2 and 3 are switched.");