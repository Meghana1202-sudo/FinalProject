import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLoanTypeComponent } from './add-loan-type.component';

describe('AddLoanTypeComponent', () => {
  let component: AddLoanTypeComponent;
  let fixture: ComponentFixture<AddLoanTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddLoanTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLoanTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
