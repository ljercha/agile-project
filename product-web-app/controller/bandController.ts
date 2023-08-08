import { Application, Request, Response } from 'express';
import Band from '../model/band.js';
import BandService from '../service/bandService.js';

export default class BandController {
  initializeRoutes(app: Application) {
    app.get('/admin/add-band', this.renderAddBandPage);
    app.post('/admin/add-band', this.addBand);
  }

  async renderAddBandPage(req: Request, res: Response){
    res.render('add-band');
  };

  async addBand(req: Request, res: Response){
    const data: Band = req.body;
    const bandService = new BandService();

    try {
      await bandService.addBand(data);
    } catch (e) {
      res.locals.errormessage = 'Failed to add band';
    }
    res.render('add-band');
  };
}
