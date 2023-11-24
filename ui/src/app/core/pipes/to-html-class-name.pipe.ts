import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'toHtmlClassName',
})
export class ToHtmlClassNamePipe implements PipeTransform {
  transform(value: any, ...args: string[]): string {
    return (value + '').trim().replaceAll(' ', '-').toLowerCase();
  }
}
