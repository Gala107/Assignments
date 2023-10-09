import { Time } from "@angular/common";

export class ClientMeeting {
    constructor(
        public id: number,
        public meetDate: Date,
        public meetTime: Time,
        public note: string,
        public clientId: number
    ){};
}
