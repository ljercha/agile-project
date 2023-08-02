export default interface Employee {
  email: string;
  password: string;
  role: 'Admin' | 'Employee';
}
