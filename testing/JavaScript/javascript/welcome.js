const circle = {
    radius: 2,
    drawpicture() {console.log('my method!');}
}

for (let key in circle)
    console.log(key, circle[key]);

for (let key of Object.keys(circle))
    console.log(key);

for (let entry of Object.entries(circle))
    console.log(entry);

    let o = {};
    console.log(o.constructor === Object); //true
    let a = new Object;
    console.log(a.constructor === Object); //true
    let b = [];
    console.log(b.constructor === Array); //true
    console.log("\n ********* \n");

    let user = {
        name: 'Gala',
        email: 'gala@example.com',
        address: {
            addLine: '101 Cherry Rd',
            city: 'Dreamvillage',
            zipCode: 101
        },
        orders: [
            {oid: 1, sum: '100'},
            {oid: 2, sum: '300'}
        ]
    }
    console.log("        user name:  " + user.name);
    console.log("user address line:  " + user.address.addLine);
    console.log("      order 1 sum:  " + user.orders[1].sum);   
    console.log("\n ********* \n");

// all objects have constructor by DEFAULT
let ab = {};
console.log("ab is {}, ab constructor: " + ab.constructor); // function Object()
ab = new Object;
console.log("ab is new Object, ab constructor: " + ab.constructor); // function Object()
ab = [];
console.log("ab is Array, ab constructor: " + ab.constructor); // function Array();
console.log("\n ********* \n");

// arrays
const ages = [52, 19, 29, 44];
ages.splice(1, 2);
console.log("ages after splice where 2 elements are removed starting at index=1:    " + ages);
console.log("\n ********* \n");

// how to create empty array
let c = [1, 2, 3];
c = [];   // assign empty array
c.length = 0;  // set lentgh to 0
c = [1, 2, 3];
c.splice(0, c.length);
c = [1, 2, 3];
while (c.length > 0) {
    c.pop();
}

// spread operator used in function calls for multiple parameters
function sum(x, y, z) {
    return x + y + z;
  }
const numbers = [1, 2, 3];
console.log(sum(...numbers));


// clone arrays using spread operator
const arr = [1, 2, 3];
const arr2 = [...arr]; // like arr.slice()
arr2.push(4);   //  arr2 becomes [1, 2, 3, 4]
console.log(...arr);          // 1 2 3
console.log(...arr2);         // 1 2 3 4

// use spread in functions
function sum(x, y, z) {
    console.log(x);
    console.log(y);
    console.log(z);
    console.log(x + y + z);
}
const num = [2, 4, 8, 9];
sum(...num);
console.log(`the num value is ${num}!!!`);
console.log("\n ********* \n");

// arrow function
let addup = (a, b) => a + b;
console.log(addup(3, 6));

// In order to prompt from command line, run this command to add prompt-sync to your library:
// ...javascript$ npm i prompt-sync
let prompt = require('prompt-sync')();
let choice = prompt("Enter Your Choice: ");
console.log(`Choice entered is ${choice}.`);

