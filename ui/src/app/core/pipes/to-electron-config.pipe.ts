import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'toElectronConfig',
})
export class ToElectronConfigPipe implements PipeTransform {
  transform(configuration: undefined | string, ...args: string[]): string {
    if (!configuration) return '';

    let htmltConfig = '';

    configuration.split(' ').forEach((config) => {
      if (config.startsWith('[')) htmltConfig += config;

      ['s', 'p', 'd', 'f'].forEach((orbital) => {
        if (config.toLowerCase().includes(orbital)) {
          htmltConfig +=
            ' ' +
            config
              .replace(orbital, '<i>' + orbital + '</i>' + '<sup>')
              .concat('</sup>');
        }
      });
    });

    return htmltConfig;
  }
}
