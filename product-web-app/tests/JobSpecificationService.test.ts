import axios, { AxiosError } from 'axios';
import chai from 'chai';
import MockAdapter from 'axios-mock-adapter';
import JobSpecificationService from '../service/JobSpecificationService.js';
import { response } from 'express';


const { expect } = chai;
const jobSpecificationService = new JobSpecificationService();
(jobSpecificationService as any).API_URL = 'http://localhost:8080';

const spec = {

    roleId: 1,
    summary: 'Detailed description for developer role.',
    description: 'tester_test',
    specificationLink: 'http://sharepoint.com/developer-spec'
};

describe('JobSpecificationService', () => {
  describe('getJobSpecification', () => {
    it('should return the job spec  from response', async () => {
      const mock = new MockAdapter(axios);
      const roleId = 1;
      mock.onGet('URL+/api/job-specification/'+1).reply(200, roleId);
      const results = await jobSpecificationService.getJobSpecification(1);
      expect(response).to.deep.equal(roleId);
    });

    it('should throw exception when 500 error returned from axios', async () => {
      const mock = new MockAdapter(axios);
      mock.onGet('http://localhost:8080/api/job-specification/'+1).reply(500);
      let error: any;
      try {
        await jobSpecificationService.getJobSpecification(1);
      } catch (e: unknown) {
        error = e as AxiosError;
      }
      expect(error.message).to.equal('Error jobServiceError');
    });  
  });
});