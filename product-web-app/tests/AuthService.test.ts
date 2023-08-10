import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import chai from 'chai';
import AuthService from '../service/authService.js';
import User from '../model/register.js';
import Login from '../model/login.js';

const { expect } = chai;

const authService = new AuthService();

(authService as any).API_URL = 'http://localhost:8080/api';

const user: User = {
  email: 'test@kainos.com',
  password: 'Test123!',
  role: 'Employee',
};
const login: Login = {
  email: 'test@kainos.com',
  password: 'Test123!',
}
const tokenValue: string = 'NOT_HARDCODED_TOKEN_VALUE'; 
const cookie: string = 'access_token=NOT_HARDCODED_TOKEN_VALUE;Version=69'; 

describe('AuthService', () => {
  describe('registerUser', () => {
    it('should return id when passing correct input data', async () => {
      const mock = new MockAdapter(axios);
      const userId = 1;

      mock.onPost('http://localhost:8080/api/auth/register', user).reply(200, userId);

      const response = await authService.register(user);
      expect(response).to.equal(userId);
    });

    it('should return error 400 when pass invalid data', async () => {
      const mock = new MockAdapter(axios);
      mock.onPost('http://localhost:8080/api/auth/register', user).reply(400);

      try {
        await authService.register(user);
      } catch (error) {
        const errorMessage: string = error instanceof Error ? error.message : String(error);
        expect(errorMessage).to.equal('Registration failed! Please try again.');
      }
    });

    it('should return JWT token when correct credential provided', async () => {
      const mock = new MockAdapter(axios);
      mock.onPost('http://localhost:8080/api/auth/login', login).reply(200, cookie);
      console.log('cookie: ', cookie)
      const response = await authService.login(login);
      console.log('cookie: ', response)
      expect(response).to.equal(tokenValue);
    })

  });
});
