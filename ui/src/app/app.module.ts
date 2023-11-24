import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import {
  NgbModalModule,
  NgbModule
} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SafeUnitPipe } from './core/pipes/safe-unit.pipe';
import { ToCasePipe } from './core/pipes/to-case.pipe';
import { ToHtmlClassNamePipe } from './core/pipes/to-html-class-name.pipe';
import { ElementImagesComponent } from './element-images/element-images.component';
import { ElementModalComponent } from './element-modal/element-modal.component';
import { ElementComponent } from './element/element.component';
import { LoaderAnimationComponent } from './loader-animation/loader-animation.component';

@NgModule({
  declarations: [
    AppComponent,
    ElementComponent,
    ElementModalComponent,
    ToHtmlClassNamePipe,
    ToCasePipe,
    SafeUnitPipe,
    LoaderAnimationComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    NgbModalModule,
    ElementImagesComponent,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
