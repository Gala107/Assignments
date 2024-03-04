import { Owner } from "./owner";
import { Visit } from "./visit";

export class Pet {

    id = 0;
    name = '';
    type = '';
    dob = '';
    breed = '';
    ownerId = 0;
    visits: Visit[] = [];

    public constructor(init?: Partial<Pet>) {
        Object.assign(this, init);
    }
}
