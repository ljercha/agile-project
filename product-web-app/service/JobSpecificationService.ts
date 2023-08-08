import axios from 'axios';
import JobSpecification from '../model/JobSpecification.js';

export default class JobSpecificationService {
  async getJobSpecification(this: any, id: number) : Promise<JobSpecification> {
    try {
      console.log('GET: ' + `/api/job-specification/${id}`);
      const response = await axios.get(`/api/job-specification/${id}`);
      return response.data;
    } catch (e) {
      throw new Error('cant get job specification');
    }
  }
}
