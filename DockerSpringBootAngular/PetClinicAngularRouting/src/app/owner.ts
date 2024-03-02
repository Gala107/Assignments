import { Pet } from "./pet";

export class Owner {

    id: number;
    name: string;
    address: string;
    phone: string;
    email: string;

    constructor(id:number, name: string, address: string, phone: string, email: string) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
