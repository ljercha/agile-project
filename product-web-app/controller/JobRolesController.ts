import { Application, Request, Response } from "express";
import { JobRole } from "../model/jobRole.js";
import JobRoleService from "../service/jobRolesService.js";


export default class JobRolesController {
    constructor(app: Application) {
        app.get("/job-roles", async (req: Request, res: Response) => {
        const jobRoleService = new JobRoleService();
        try {
            let jobRoles: JobRole[] = await jobRoleService.getAllJobRoles();
            // if (jobRoles.length=0) {
            //     res.status(200).send('Error JobRolesController');
            // }
            res.render('job-roles', {jobRoles: jobRoles})
        } catch(e) {
            console.log(e);
            res.status(500).send('Error JobRolesController');
        }
    })
}
}
