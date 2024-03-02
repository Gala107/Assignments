import { Owner } from "./owner";
import { Pet } from "./pet";

export class Visit {

    id: number;
    date: string;
    time: string;
    reason: string;
    owner: Owner;
    pet: Pet;

    constructor(id: number, date: string, time: string, reason: string, owner: Owner, pet: Pet) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.owner = owner;
        this.pet = pet;
    }
}
