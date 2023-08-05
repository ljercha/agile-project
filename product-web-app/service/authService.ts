import axios from 'axios';
import User from '../model/register.js';
import registerValidator from '../validator/registrationValidator.js';

const API_URL = process.env.API_URL || '';

async function register(user: User): Promise<number> {
  registerValidator(user);

  try {
    const response = await axios.post(`${API_URL}/auth/register`, user);
    return response.data;
  } catch (error) {
    throw new Error('Registration failed! Please try again.');
  }
}

export { register, API_URL };
