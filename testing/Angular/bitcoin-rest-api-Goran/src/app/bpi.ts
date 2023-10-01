import { compileDeclareClassMetadata } from "@angular/compiler"
import { raceWith } from "rxjs"

export class Bpi {
    constructor (
        public code: string,
        public rate: string,
        public description: string) {};   
 }
