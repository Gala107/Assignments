import { Bpi } from "./bpi";

export class BpiList {
    constructor(
        public EUR: Bpi,
        public GBP: Bpi,
        public USD: Bpi,
    ) {};
}
