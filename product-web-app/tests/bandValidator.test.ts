import chai from 'chai';
const expect = chai.expect;
import { validateBand } from '../validator/bandValidator.js'

describe('bandValidator', function () {
    describe('validateBand', function () {
      it('should return null when no errors', () => {
        let band = {
            name: "tomek",
            level: "Mocha",
            responsibilities: "Chai"
        }

        expect(validateBand(band)).to.be.null
      })

      it('should return error when name is less than 1 char', () => {
        let band = {
            name: "",
            level: "Mocha",
            responsibilities: "Chai"
        }
  
        expect(validateBand(band)).to.equal("name must be at least 1 characters")
      })
    })
});
