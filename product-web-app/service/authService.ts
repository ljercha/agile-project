import axios from 'axios';
import dotenv from 'dotenv';
import Employee from '../model/register.js';
import registerValidator from '../validator/registrationValidator.js';

dotenv.config();

const BASE_URL = process.env.API_URL;

async function register(employee: Employee): Promise<number> {
  registerValidator(employee);

  try {
    const response = await axios.post(`${BASE_URL}/auth/register`, employee);
    return response.data;
  } catch (error) {
    throw new Error('Registration failed! Please try again.');
  }
}

export { register, BASE_URL };
