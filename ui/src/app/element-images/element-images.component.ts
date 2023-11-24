import { CommonModule, NgFor, NgIf } from '@angular/common';
import {
  CUSTOM_ELEMENTS_SCHEMA,
  Component,
  Input,
  NO_ERRORS_SCHEMA,
  ViewChild
} from '@angular/core';
import {
  NgbCarousel,
  NgbCarouselConfig,
  NgbCarouselModule,
  NgbSlideEvent,
  NgbSlideEventSource,
} from '@ng-bootstrap/ng-bootstrap';
import { Image } from '../core/models/image';

@Component({
  selector: 'app-element-images',
  templateUrl: './element-images.component.html',
  styleUrls: ['./element-images.component.css'],
  standalone: true,
  schemas: [NO_ERRORS_SCHEMA, CUSTOM_ELEMENTS_SCHEMA],
  imports: [NgbCarouselModule, CommonModule, NgFor, NgIf],
  providers: [NgbCarouselConfig],
})
export class ElementImagesComponent {
  @Input() images!: Image[];

  paused = false;
  unpauseOnArrow = false;
  pauseOnIndicator = false;
  pauseOnHover = true;
  pauseOnFocus = true;

  @ViewChild('carousel', { static: true }) carousel!: NgbCarousel;

  constructor(private config: NgbCarouselConfig) {
    // customize default values of carousels used by this component tree
    config.showNavigationArrows = true;
    config.showNavigationIndicators = true;
    console.log('constructor: ', this.images);
  }

  togglePaused() {
    if (this.paused) {
      this.carousel.cycle();
    } else {
      this.carousel.pause();
    }
    this.paused = !this.paused;
  }

  onSlide(slideEvent: NgbSlideEvent) {
    if (
      this.unpauseOnArrow &&
      slideEvent.paused &&
      (slideEvent.source === NgbSlideEventSource.ARROW_LEFT ||
        slideEvent.source === NgbSlideEventSource.ARROW_RIGHT)
    ) {
      this.togglePaused();
    }
    if (
      this.pauseOnIndicator &&
      !slideEvent.paused &&
      slideEvent.source === NgbSlideEventSource.INDICATOR
    ) {
      this.togglePaused();
    }
  }
}
