import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewpanelComponent } from './viewpanel.component';

describe('ViewpanelComponent', () => {
  let component: ViewpanelComponent;
  let fixture: ComponentFixture<ViewpanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewpanelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewpanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
