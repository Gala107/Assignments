import { Owner } from "./owner";

export class Pet {

    id: number;
    ownerId: number;
    name: String;
    type: String;
    dob: String;
    breed: String;
    owner: Owner;

    constructor(id: number, ownerId: number, name: String, type: String, dob: String, breed: String, owner: Owner) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.type = type;
        this.dob = dob;
        this.breed = breed;
        this.owner = owner;
    }
}
