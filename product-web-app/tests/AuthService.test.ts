import axios from 'axios';
// eslint-disable-next-line import/no-extraneous-dependencies
import MockAdapter from 'axios-mock-adapter';
import chai from 'chai';
import dotenv from 'dotenv';
import { register } from '../service/AuthService.js';
import Employee from '../model/register.js';

dotenv.config();

const { expect } = chai;
const BASE_URL = process.env.API_URL;

const employee: Employee = {
  email: 'test@kainos.com',
  password: 'Test123!',
  role: 'Employee',
};

describe('AuthService', () => {
  describe('registerEmployee', () => {
    it('should return id', async () => {
      const mock = new MockAdapter(axios);
      const employeeId = 1;

      mock.onPost(`${BASE_URL}/auth/register`, employee).reply(201, employeeId);

      const response = await register(employee);
      expect(response).to.equal(employeeId);
    });

    it('should return error 400 when pass invalid data', async () => {
      const mock = new MockAdapter(axios);
      mock.onPost(`${BASE_URL}/auth/register`, employee).reply(400);

      try {
        await register(employee);
      } catch (error) {
        const errorMessage: string = error instanceof Error ? error.message : String(error);
        expect(errorMessage).to.equal('Registration failed! Please try again.');
      }
    });
  });
});
