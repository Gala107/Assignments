// 1.Create a class object named "Person"
// 2. Add the below properties: id, name, department
// 3. Add a constructor that takes the below parameters: id, name and department.
// 4. Have the constructor set the instance properties.
// 5. Add a class function that returns the below: department + id.
// 6. Set a reference to an instance of the object and name it "person"
// 7. Write to console the class function output.
// 8. Run your code
var Person = /** @class */ (function () {
    function Person(id, name, department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    Person.prototype.getDepartmentId = function () {
        // template literal for string interpolation
        return "".concat(this.department, " ").concat(this.id);
    };
    return Person;
}());
var person = new Person(700, "Gala", "Coding Department");
console.log(person.getDepartmentId());
