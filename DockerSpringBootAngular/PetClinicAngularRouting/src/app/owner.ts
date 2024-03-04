import { Pet } from "./pet";

export class Owner {

    id = 0;
    name = '';
    address = '';
    phone = '';
    email = '';
    pets: Pet[] = [];

    public constructor(init?: Partial<Owner>) {
        Object.assign(this, init);
    }
}