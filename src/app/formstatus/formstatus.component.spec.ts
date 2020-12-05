import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormstatusComponent } from './formstatus.component';

describe('FormstatusComponent', () => {
  let component: FormstatusComponent;
  let fixture: ComponentFixture<FormstatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormstatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormstatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
