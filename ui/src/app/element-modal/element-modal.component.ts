import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Element } from '../core/models/element';
import { Image } from '../core/models/image';
import { BackendService } from '../core/service/backend.service';

@Component({
  selector: 'app-element-modal',
  templateUrl: './element-modal.component.html',
  styleUrls: ['./element-modal.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class ElementModalComponent implements OnInit {
  @Input() element!: Element;

  loaded = false;
  closeResult!: string;
  summary: any;

  images: Image[] = [];

  constructor(
    public modal: NgbActiveModal,
    private backendService: BackendService
  ) {}

  ngOnInit(): void {
    this.fetchWikiData();
  }

  private fetchWikiData() {
    this.backendService
      .getWikiSummary(this.element.name)
      .subscribe((summary: any) => {
        this.summary = summary?.extract_html;
        this.fetchImages();
      });
  }

  private fetchImages() {
    this.backendService.getImages(this.element.name).subscribe((images) => {
      this.images = images.map((image) => {
        return {
          src: image,
          alt: this.element.name,
        };
      });
      this.loaded = true;
    });
  }
}
