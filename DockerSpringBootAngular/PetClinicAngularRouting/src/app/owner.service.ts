import { Injectable } from '@angular/core';
import { Owner } from './owner';
import { Pet } from './pet';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {
  baseUrl = "http://localhost:8282";

  constructor(private http: HttpClient) {}

  findOwnerByPhone(phone: String): Owner {
    return new Owner(0, "Gala Winters", "11th Cherry St, Westwood, MO", "123 123 1234", "gala@me.com");
  }

  findOwnerByEmail(email: String): Owner {
    return new Owner(0, "Walter Couff", "89 Barry Rd., Liberty, MO", "456", "walter@me.com");
  }

  saveOwner(owner: any): Observable<String> {
    let endPoint = "/owner/createOwner";
    return this.http.post<String>(this.baseUrl + endPoint, owner);
  }
}
