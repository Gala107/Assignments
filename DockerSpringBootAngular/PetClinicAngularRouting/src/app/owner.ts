import { Pet } from "./pet";

export class Owner {

    id: number;
    name: String;
    address: String;
    phone: String;
    email: String;
    pets: Array<Pet>;

    constructor(id:number, name: String, address: String, phone: String, email: String, pets: Array<Pet>) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.pets = pets;
    }
}
