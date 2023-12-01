import { ToElectronConfigPipe } from './to-electron-config.pipe';

describe('ToElectronConfigPipe', () => {
  it('create an instance', () => {
    const pipe = new ToElectronConfigPipe();
    expect(pipe).toBeTruthy();
  });
});
