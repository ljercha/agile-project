import { Application, Request, Response } from 'express';
import JobSpecificationService from '../service/JobSpecificationService.js';
import JobSpecification from '../model/JobSpecification.js';
/* eslint-disable */
export default class JobSpecificationController {
  init(app: Application) {
    const jobSpecificationService = new JobSpecificationService();
    app.get('/job-specification/:id', async (req: Request, res: Response) => {
      let data: JobSpecification | undefined;
      try {
        data = await jobSpecificationService.getJobSpecification(parseInt(req.params.id));
      } catch (e) {
        console.log(e);
        res.status(500).send('Error JobSpecification');
      }
      /* eslint-enable */
      res.render('job-specification', { jobSpecification: data });
    });
  }
}
