import axios from 'axios';
import dotenv from 'dotenv';
import User from '../model/register.js';
import registerValidator from '../validator/registrationValidator.s';

dotenv.config();

const BASE_URL = process.env.API_URL;

class AuthService {
  // eslint-disable-next-line class-methods-use-this
  async register(user: User): Promise<number> {
    registerValidator(user);

    try {
      const response = await axios.post(`${BASE_URL}/auth/register`, user);
      return response.data;
    } catch (error) {
      throw new Error('Registration failed! Please try again.');
    }
  }
}

export default AuthService;
