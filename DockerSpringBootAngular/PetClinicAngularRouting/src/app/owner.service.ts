import { Injectable } from '@angular/core';
import { Owner } from './owner';
import { Pet } from './pet';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  constructor() { }

  findOwnerByPhone(phone: String): Owner {
    return new Owner(0, "Gala Winters", "11th Cherry St, Westwood, MO", "123 123 1234", "gala@me.com", new Array<Pet>());
  }

  findOwnerByEmail(email: String): Owner {
    return new Owner(0, "Walter Couff", "89 Barry Rd., Liberty, MO", "456", "walter@me.com", new Array<Pet>());
  }

  saveOwner(owner: Owner) {
    console.log('Saving an Owner!');
  }
}
