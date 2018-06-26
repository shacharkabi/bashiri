import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactComponent }      from './contact/contact.component';
import { ContactDetailsComponent }  from './contact-details/contact-details.component';

const routes: Routes = [
  { path: 'detail/:id', component: ContactDetailsComponent },
  { path: 'searchContacts', component: ContactComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}