import axios, { AxiosError } from 'axios';
import chai from 'chai';
import MockAdapter from 'axios-mock-adapter';
import JobRoleService from '../service/jobRolesService.js';

const { expect } = chai;
const jobRolesService = new JobRoleService();
(jobRolesService as any).API_URL = 'http://localhost:8080/api';

const jobRole = {
  jobRoleId: 1,
  roleTitle: 'Engineering',
};

describe('JobRoleService', () => {
  describe('getAllJobRoles', () => {
    it('should return all job roles from response', async () => {
      const mock = new MockAdapter(axios);
      const data = [jobRole];
      mock.onGet('http://localhost:8080/api/job-roles').reply(200, data);
      const results = await jobRolesService.getAllJobRoles();
      expect(results[0]).to.deep.equal(jobRole);
    });

    it('should throw exception when 500 error returned from axios', async () => {
      const mock = new MockAdapter(axios);
      mock.onGet('http://localhost:8080/api/job-roles').reply(500);
      let error: any;
      try {
        await jobRolesService.getAllJobRoles();
      } catch (e: unknown) {
        error = e as AxiosError;
      }
      expect(error.message).to.equal('Error jobRoleService');
    });

    it('should return empty list/array when such is received', async () => {
      const mock = new MockAdapter(axios);
      const data: any[] = [];
      mock.onGet('http://localhost:8080/api/job-roles').reply(200, data);
      const results = await jobRolesService.getAllJobRoles();
      expect(results).to.deep.equal([]);
    });
  });
});
