import axios, { AxiosError } from "axios";
import chai from "chai";
import JobRoleService from "./jobRolesService.js";
import MockAdapter from "axios-mock-adapter"
const expect = chai.expect
const jobRolesService = new JobRoleService();
jobRolesService['API_URL'] = "http://localhost:3000";

const jobRole = {
    jobRoleId: 1,
    roleTitle: 'Engineering'
}

describe('JobRoleService', function () {
    describe('getAllJobRoles', function () {
        it('should return all job roles from response', async () => {
            var mock = new MockAdapter(axios);
            const data = [jobRole]
            mock.onGet(jobRolesService['API_URL'] + '/api/job-roles').reply(200, data)
            var results = await jobRolesService.getAllJobRoles();
            expect(results[0]).to.deep.equal(jobRole)
        })
        
        it('should throw exception when 500 error returned from axios', async () => {
            var mock = new MockAdapter(axios);
            mock.onGet(jobRolesService['API_URL'] + '/api/job-roles').reply(500);
            let error: any;
            try {
                await jobRolesService.getAllJobRoles()
            } catch (e: unknown) {
                 error = e as AxiosError;
            }
            expect(error.message).to.equal('Error jobRoleService')
        })
    
        it('should return empty list/array when such is received', async () => {
            var mock = new MockAdapter(axios);
            const data: any[] = [];
            mock.onGet(jobRolesService['API_URL'] + '/api/job-roles').reply(200, data)
            var results = await jobRolesService.getAllJobRoles();
            expect(results).to.deep.equal([])
        })
    })
})
