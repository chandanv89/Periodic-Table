import { Component, Input } from '@angular/core';
import { Element } from '../core/models/element';

@Component({
  selector: 'app-element',
  templateUrl: './element.component.html',
  styleUrls: ['./element.component.css'],
})
export class ElementComponent {
  @Input() element!: Element;

  constructor() {
    this.element = {} as Element;
  }
}
