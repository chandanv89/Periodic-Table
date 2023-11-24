import { Pipe, PipeTransform } from '@angular/core';

/**
 * This pipe is used to safely add the provided unit to a value.
 *
 * It will only add the unit if the value is not empty or undefined.
 *
 * Examples:
 * - `{{ 1 | safeUnit: 'kg' }}` will result in '1 kg'
 * - `{{ '' | safeUnit: 'kg' }}` will result in ''
 */
@Pipe({
  name: 'safeUnit',
})
export class SafeUnitPipe implements PipeTransform {
  transform(value: any, ...args: string[]): string {
    const unit = args[0];
      
    const trimmed = (value + '').trim();
    return trimmed + (this.hasValidValue(trimmed) ? ' ' + unit : '');
  }

  private hasValidValue(value: any): boolean {
    return value && value !== 'undefined' && value !== 'unknown';
  }
}
