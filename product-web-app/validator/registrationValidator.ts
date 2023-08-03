import Employee from '../model/register.js';

export default function registerValidator(input: Employee) {
  // Minimum password length (you can adjust this as needed)
  const { email, password, role } = input;
  const minLength: number = 8;

  if (/\s/.test(email)) {
    throw Error('Email cannot contain whitespace.');
  }

  if (password.length < minLength) {
    // Check if the password meets the minimum length requirement
    throw Error(`Password must be at least ${minLength} characters long.`);
  }

  // Check if the password contains at least one lowercase letter
  if (!/(?=.*[a-z])/.test(password)) {
    throw Error('Password must contain at least one lowercase letter.');
  }

  // Check if the password contains at least one uppercase letter
  if (!/(?=.*[A-Z])/.test(password)) {
    throw Error('Password must contain at least one uppercase letter.');
  }

  // Check if the password contains at least one special character
  if (!/(?=.*[!@#$%^&*(),.?":{}|<>])/.test(password)) {
    throw Error('Password must contain at least one special character.');
  }

  // Check if the password has no whitespace
  if (/\s/.test(password)) {
    throw Error('Password cannot contain whitespace.');
  }

  if (!(role === 'Admin' || role === 'Employee')) {
    throw Error('You must choose your role from the form.');
  }

  return null;
}
