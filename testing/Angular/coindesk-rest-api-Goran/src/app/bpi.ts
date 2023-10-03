import { Eur } from "./eur";
import { Gbp } from "./gbp";
import { Usd } from "./usd";


export class Bpi {
    
    constructor(
        public USD: Usd, 
        public EUR: Eur, 
        public GBP: Gbp
        ) {};
}
