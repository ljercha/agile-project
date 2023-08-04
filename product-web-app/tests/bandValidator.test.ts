import chai from 'chai';
import validateBand from '../validator/bandValidator.js';

const { expect } = chai;

describe('bandValidator', () => {
  describe('validateBand', () => {
    it('should return null when no errors', () => {
      const band = {
        name: 'tomek',
        level: 'Mocha',
        responsibilities: 'Chai',
      };

      expect(validateBand(band)).to.be.null;
    });

    it('should return error when name is less than 1 char', () => {
      const band = {
        name: '',
        level: 'Mocha',
        responsibilities: 'Chai',
      };

      expect(validateBand(band)).to.equal('name must be at least 1 characters');
    });
  });
});
