import { ToHtmlClassNamePipe } from './to-html-class-name.pipe';

describe('ToHtmlClassNamePipe', () => {
  it('create an instance', () => {
    const pipe = new ToHtmlClassNamePipe();
    expect(pipe).toBeTruthy();
  });
});
