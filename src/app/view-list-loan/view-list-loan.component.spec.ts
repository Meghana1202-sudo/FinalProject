import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewListLoanComponent } from './view-list-loan.component';

describe('ViewListLoanComponent', () => {
  let component: ViewListLoanComponent;
  let fixture: ComponentFixture<ViewListLoanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewListLoanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewListLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
