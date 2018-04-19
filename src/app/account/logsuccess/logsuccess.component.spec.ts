import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogsuccessComponent } from './logsuccess.component';

describe('LogsuccessComponent', () => {
  let component: LogsuccessComponent;
  let fixture: ComponentFixture<LogsuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogsuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogsuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
