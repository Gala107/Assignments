import { Pet } from "./pet";

export class Owner {

    id: number;
    name: String;
    address: String;
    phone: String;
    email: String;

    constructor(id:number, name: String, address: String, phone: String, email: String) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
