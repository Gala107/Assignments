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