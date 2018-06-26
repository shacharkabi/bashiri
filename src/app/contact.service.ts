import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Contact } from './contact/contact';
import { CONTACTS } from './mock-contacts';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor() { }


  getContacts(): Observable<Contact[]> {
    return of(CONTACTS);
  }

  getContact(id: number): Observable<Contact> {
    console.log('contact id is ' + id);
    return of(CONTACTS.find(contact => contact.id === id));
  }

}
