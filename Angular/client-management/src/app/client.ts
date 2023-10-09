import { Address } from "./address";

export class Client {
    constructor(
        public id: number,
        public firstName: string,
        public lastName: string,
        public category: string,
        public busType: string,
        public description: string,
        public phone: string,
        public email: string,
        public address: Address
    ) {}
}
