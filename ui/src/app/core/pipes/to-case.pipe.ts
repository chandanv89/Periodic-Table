import { Pipe, PipeTransform } from '@angular/core';

/**
 * This pipe is used to convert a string to a specific case.
 *
 * Valid options are:
 * - lower
 * - upper
 * - sentence
 * - title
 *
 * Examples:
 * - `{{ 'hello world' | toCase: 'lower' }}` will result in 'hello world'
 * - `{{ 'hello world' | toCase: 'upper' }}` will result in 'HELLO WORLD'
 * - `{{ 'hello world' | toCase: 'sentence' }}` will result in 'Hello world'
 * - `{{ 'hello world' | toCase: 'title' }}` will result in 'Hello World'
 */
@Pipe({
  name: 'toCase',
})
export class ToCasePipe implements PipeTransform {
  /**
   * This pipe is used to convert a string to a specific case.
   *
   * Valid options are:
   * - lower
   * - upper
   * - sentence
   * - title
   *
   * Examples:
   * - `{{ 'hello world' | toCase: 'lower' }}` will result in 'hello world'
   * - `{{ 'hello world' | toCase: 'upper' }}` will result in 'HELLO WORLD'
   * - `{{ 'hello world' | toCase: 'sentence' }}` will result in 'Hello world'
   * - `{{ 'hello world' | toCase: 'title' }}` will result in 'Hello World'
   */
  transform(value: any, opt: 'lower' | 'upper' | 'sentence' | 'title'): string {
    switch (opt) {
      case 'lower':
        return (value + '').trim().toLowerCase();
      case 'upper':
        return (value + '').trim().toUpperCase();
      case 'sentence':
        return (
          (value + '').trim().charAt(0).toUpperCase() +
          (value + '').trim().slice(1).toLowerCase()
        );
      case 'title':
        return (value + '')
          .trim()
          .split(' ')
          .map(
            (word: string) =>
              word.charAt(0).toUpperCase() + word.slice(1).toLowerCase()
          )
          .join(' ');
    }
  }
}
