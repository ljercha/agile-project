import axios from 'axios';
// eslint-disable-next-line import/no-extraneous-dependencies
import MockAdapter from 'axios-mock-adapter';
import chai from 'chai';
import { register, API_URL } from '../service/AuthService.js';
import User from '../model/register.js';

const { expect } = chai;

const user: User = {
  email: 'test@kainos.com',
  password: 'Test123!',
  role: 'Employee',
};

describe('AuthService', () => {
  describe('registerUser', () => {
    it('should return id when passing correct input data', async () => {
      const mock = new MockAdapter(axios);
      const userId = 1;

      mock.onPost(`${API_URL}/auth/register`, user).reply(201, userId);

      const response = await register(user);
      expect(response).to.equal(userId);
    });

    it('should return error 400 when pass invalid data', async () => {
      const mock = new MockAdapter(axios);
      mock.onPost(`${API_URL}/auth/register`, user).reply(400);

      try {
        await register(user);
      } catch (error) {
        const errorMessage: string = error instanceof Error ? error.message : String(error);
        expect(errorMessage).to.equal('Registration failed! Please try again.');
      }
    });
  });
});
