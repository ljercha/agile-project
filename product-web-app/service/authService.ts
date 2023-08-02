import axios from 'axios';
import Employee from '../model/register.js';
import registerValidator from '../validator/registrationValidator.js';

async function register(employee: Employee): Promise<number> {
  registerValidator(employee);

  try {
    const response = await axios.post('http://localhost:8080/api/auth/register', employee);
    return response.data;
  } catch (error) {
    throw new Error('Registration failed! Please try again.');
  }
}

export { register };
