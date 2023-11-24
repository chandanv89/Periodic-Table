import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElementImagesComponent } from './element-images.component';

describe('ElementImagesComponent', () => {
  let component: ElementImagesComponent;
  let fixture: ComponentFixture<ElementImagesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ElementImagesComponent]
    });
    fixture = TestBed.createComponent(ElementImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
