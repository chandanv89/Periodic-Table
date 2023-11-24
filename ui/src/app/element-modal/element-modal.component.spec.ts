import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElementModalComponent } from './element-modal.component';

describe('ElementModalComponent', () => {
  let component: ElementModalComponent;
  let fixture: ComponentFixture<ElementModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ElementModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ElementModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
