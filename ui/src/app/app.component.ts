import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Element } from './core/models/element';
import { BackendService } from './core/service/backend.service';
import { ElementModalComponent } from './element-modal/element-modal.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Periodic Table of Elements';
  elements: Element[] = [];

  constructor(
    private backendService: BackendService,
    private modalService: NgbModal
  ) {
    this.backendService.getElements().subscribe((elements: Element[]) => {
      if (elements) {
        this.elements = elements;
      }
    });
  }

  public openModal(element: Element) {
    const modal = this.modalService.open(ElementModalComponent, { centered: true, size: 'xl' });
    modal.componentInstance.element = element;
  }
}
