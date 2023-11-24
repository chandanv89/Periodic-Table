import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Element } from '../models/element';

@Injectable({
  providedIn: 'root',
})
export class BackendService {
  apiBaseUrl = '';

  constructor(private httpClient: HttpClient) {
    this.apiBaseUrl = environment.apiBaseUrl;
  }

  public getElements(): Observable<Element[]> {
    const elementsEndpoint = environment.elementsEndpoint;

    return this.httpClient.get<Element[]>(
      `${this.apiBaseUrl}${elementsEndpoint}`
    );
  }

  public getWikiSummary(name: string): Observable<any> {
    const wikiSummaryEndpoint = environment.wikiSummaryEndpoint.replace(
      '{elementName}',
      name
    );

    return this.httpClient.get<any>(`${this.apiBaseUrl}${wikiSummaryEndpoint}`);
  }

  public getImages(name: string): Observable<string[]> {
    const imagesEndpoint = environment.imagesEndpoint.replace(
      '{elementName}',
      name
    );

    return this.httpClient.get<string[]>(`${this.apiBaseUrl}${imagesEndpoint}`);
  }
}
