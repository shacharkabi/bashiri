import { Component, OnInit , Input} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Contact } from '../contact/contact';
import { ContactService }  from '../contact.service';


@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['../extcss/vendor/bootstrap/css/bootstrap.min.css',
    '../extcss/fonts/font-awesome-4.7.0/css/font-awesome.min.css',
    '../extcss/fonts/Linearicons-Free-v1.0.0/icon-font.min.css',
    '../extcss/vendor/animate/animate.css',
    '../extcss/vendor/css-hamburgers/hamburgers.min.css',
    '../extcss/vendor/animsition/css/animsition.min.css',
    '../extcss/vendor/select2/select2.min.css',
    '../extcss/vendor/daterangepicker/daterangepicker.css',
    '../extcss/css/util.css',
    '../extcss/css/main.css',
    './contact-details.component.css']
})

export class ContactDetailsComponent implements OnInit {

  @Input() contact: Contact;

  constructor(private contactService: ContactService,private route: ActivatedRoute,private location: Location ) { }

  ngOnInit() {
    this.getContact();
  }

  getContact(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.contactService.getContact(id)
      .subscribe(contact => this.contact = contact);
  }

}
