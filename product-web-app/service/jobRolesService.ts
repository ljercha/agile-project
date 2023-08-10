import axios from 'axios';
import { JobRole } from '../model/jobRole.js';

export default class JobRoleService {
  private API_URL: string;

  constructor() {
    this.API_URL = process.env.API_URL || '';
  }

  async getAllJobRoles(): Promise<JobRole[]> {
    try {
      const response = await axios.get(`${this.API_URL}/job-roles`);
      return response.data;
    } catch (e) {
      throw new Error('Error jobRoleService');
    }
  }
}
