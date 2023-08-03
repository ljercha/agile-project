import chai from 'chai';
import registrationValidator from '../validator/registrationValidator.js';
import Employee from '../model/register.js';

const { expect } = chai;
let errorMessage = '';

describe('registrationValidator', () => {
  describe('validateEmployee', () => {
    it('should return null when no errors', () => {
      const employee: Employee = {
        email: 'test@kainos.com',
        password: 'Test123!',
        role: 'Employee',
      };

      expect(registrationValidator(employee)).to.be.null;
    });

    it('should return error when password has no uppercase', () => {
      const employee: Employee = {
        email: 'test@kainos.com',
        password: 'test123!',
        role: 'Employee',
      };

      try {
        registrationValidator(employee);
      } catch (error) {
        errorMessage = error instanceof Error ? error.message : String(error);
      } finally {
        expect(errorMessage).to.equal('Password must contain at least one uppercase letter.');
      }
    });

    it('should return error when password has no lowercase', () => {
      const employee: Employee = {
        email: 'test@kainos.com',
        password: 'TEST123!',
        role: 'Employee',
      };

      try {
        registrationValidator(employee);
      } catch (error) {
        errorMessage = error instanceof Error ? error.message : String(error);
      } finally {
        expect(errorMessage).to.equal('Password must contain at least one lowercase letter.');
      }
    });

    it('should return error when password has no special character', () => {
      const employee: Employee = {
        email: 'test@kainos.com',
        password: 'Test1234',
        role: 'Employee',
      };

      try {
        registrationValidator(employee);
      } catch (error) {
        errorMessage = error instanceof Error ? error.message : String(error);
      } finally {
        expect(errorMessage).to.equal('Password must contain at least one special character.');
      }
    });

    it('should return error when password contain whitespace.', () => {
      const employee: Employee = {
        email: 'test@kainos.com',
        password: 'Test 1234!',
        role: 'Employee',
      };

      try {
        registrationValidator(employee);
      } catch (error) {
        errorMessage = error instanceof Error ? error.message : String(error);
      } finally {
        expect(errorMessage).to.equal('Password cannot contain whitespace.');
      }
    });

    it('should return error when password shorter than 8 characters', () => {
      const employee: Employee = {
        email: 'test@kainos.com',
        password: 'Test12!',
        role: 'Employee',
      };

      try {
        registrationValidator(employee);
      } catch (error) {
        errorMessage = error instanceof Error ? error.message : String(error);
      } finally {
        expect(errorMessage).to.equal('Password must be at least 8 characters long.');
      }
    });

    it('should return error when role is not provided', () => {
      const employee: Employee = {
        email: 'test@kainos.com',
        password: 'Test123!',
        role: 'Hacker',
      };

      try {
        registrationValidator(employee);
      } catch (error) {
        errorMessage = error instanceof Error ? error.message : String(error);
      } finally {
        expect(errorMessage).to.equal('You must choose your role from the form.');
      }
    });
  });
});
