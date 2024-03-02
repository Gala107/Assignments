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

  findOwner(findBy: any, ownerInfo: any): Observable<Owner> {
    let endPoint = "/owner/getOwner/";
    return this.http.get<Owner>(this.baseUrl + endPoint + findBy + "/" + ownerInfo);
  }

  // saveOwner(owner: any): Observable<string> {
  //   let endPoint = "/owner/createOwner";
  //   return this.http.post(this.baseUrl + endPoint, owner,{responseType:"text"});
  // }

  saveOwner(owner: any): Observable<Owner> {
    let endPoint = "/owner/createOwner";
    return this.http.post<Owner>(this.baseUrl + endPoint, owner);
  }
}
