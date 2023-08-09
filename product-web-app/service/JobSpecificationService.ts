import axios from 'axios';
import JobSpecification from '../model/JobSpecification.js';

export default class JobSpecificationService {
  this: any;
  /* eslint-disable */
  async getJobSpecification(this: any, id: number): Promise<JobSpecification> {
    /* eslint-enable */
    try {
      const response = await axios.get(`/api/job-specification/${id}`);
      return response.data;
    } catch (e) {
      throw new Error('cant get job specification');
    }
  }
}
