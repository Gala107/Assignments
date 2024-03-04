
export class Visit {

    id = 0;
    date = '';
    time = '';
    reason = '';
    petId = 0;

    public constructor(init?: Partial<Visit>) {
        Object.assign(this, init);
    }
}
