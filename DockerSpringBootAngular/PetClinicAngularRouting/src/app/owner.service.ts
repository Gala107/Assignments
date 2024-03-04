import { Injectable } from '@angular/core';
import { Owner } from './owner';
import { Pet } from './pet';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {
  baseUrl = "http://localhost:8282/petclinic/";

  constructor(private http: HttpClient) {}

  findOwner(findBy: any, ownerInfo: any): Observable<Owner> {
    let endPoint = "getOwner/";
    return this.http.get<Owner>(this.baseUrl + endPoint + findBy + "/" + ownerInfo);
  }

  findOwnerById(id: any): Observable<Owner> {
    let endPoint = "getOwnerById/"
    return this.http.get<Owner>(this.baseUrl + endPoint + id);
  }

  saveOwner(owner: any): Observable<Owner> {
    let endPoint = "createOwner";
    return this.http.post<Owner>(this.baseUrl + endPoint, owner);
  }

  addPet(pet: Pet): Observable<Owner> {
    let endPoint = "addPet";
    return this.http.post<Owner>(this.baseUrl + endPoint, pet);
  }
}
