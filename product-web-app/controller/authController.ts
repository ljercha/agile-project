import { Application, Request, Response } from 'express';
import User from '../model/register.js';
import AuthService from '../service/AuthService.js';

export default function authController(app: Application) {
  app.get('/auth/register', async (req: Request, res: Response) => {
    res.render('auth/register');
  });

  app.post('/auth/register', async (req: Request, res: Response) => {
    const data: User = req.body;
    data.email += '@kainos.com';

    try {
      const authService = new AuthService();
      await authService.register(data);
      res.redirect('auth/login');
    } catch (error) {
      res.locals.errormessage = error instanceof Error ? error.message : String(error);
      if (req.body.email.endsWith('@kainos.com')) {
        req.body.email = req.body.email.replace('@kainos.com', '');
      }
      res.render('auth/register', req.body);
    }
  });
}
