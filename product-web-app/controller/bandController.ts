import { Application, Request, Response } from 'express';
import addBand from '../service/bandService.js';
import Band from '../model/band.js';

export default function bandController(app: Application) {
  app.get('/admin/add-band', async (req: Request, res: Response) => {
    res.render('add-band');
  });

  app.post('/admin/add-band', async (req: Request, res: Response) => {
    const data: Band = req.body;

    try {
      // eslint-disable-next-line @typescript-eslint/no-unused-vars
      const response = await addBand(data);
    } catch (e) {
      // eslint-disable-next-line no-console
      console.error(e);
    }
    res.render('add-band');
  });
}
