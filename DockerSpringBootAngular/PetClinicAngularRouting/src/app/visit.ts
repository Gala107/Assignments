export class Visit {

    id: number;
    ownerId: number;
    petId: number;
    date: String;
    time: String;
    reason: String;

    constructor(id: number, ownerId: number, petId: number, date: String, time: String, reason: String) {
        this.id = id;
        this.ownerId = ownerId;
        this.petId = petId;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }
}
